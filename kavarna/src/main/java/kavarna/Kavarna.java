package kavarna;

import java.util.HashMap;

import produkt.*;

/**
 *
 * @author Matěj Kubík
 */
public class Kavarna {

    private Pokladna pokladna = new Pokladna(500);
    private HashMap<String, Kava> nKavy = new HashMap<String, Kava>();// nabidka kavy
    private HashMap<String, Kolac> nKolace = new HashMap<String, Kolac>();// nabidka kolacu
    private HashMap<String, Integer> skladSur = new HashMap<String, Integer>() { // sklad se Surovinami
        @Override
        public Integer get(Object k) {
            return containsKey(k) ? super.get(k) : 0;
        }
    };

    private String odectiZeSkladu(Produkt produkt, int kolik) {
        String output = "";
        HashMap<String, Integer> backup = new HashMap<String, Integer>(skladSur);// zaloha skladu se surovinami
        for (String surovina : produkt.ingredience().keySet()) {
            if (skladSur.get(surovina) == null
                    || produkt.ingredience().get(surovina) * kolik > skladSur.get(surovina)) {
                skladSur = backup; // problem se surovinou -> sklad se vrati do stavu pred prodejem
                return ("Nedostatek / neexistuje " + surovina);
            } else if (produkt.ingredience().get(surovina) == skladSur.get(surovina))
                output += String.format("Pozor, došla surovina %s!", surovina);
            skladSur.put(surovina, skladSur.get(surovina) - produkt.ingredience().get(surovina) * kolik);
        }
        return "";
    }

    public void pridejSurovinu(String nazev, int kolik) {
        skladSur.put(nazev, skladSur.get(nazev) + kolik);
    }

    public void pridejSurovinu(String nazev) {
        skladSur.put(nazev, skladSur.get(nazev));
    }

    public void pridejSurovinu(String[] nazvy, int[] kolik) {
        for (int i = 0; i < nazvy.length; i++)
            skladSur.put(nazvy[i], skladSur.get(nazvy[i]) + kolik[i]);
    }

    public String pridejProdukt(String nazev, float cena, String druh, String[] suroviny, int[] mnozstvi) {
        if (nKavy.get(nazev) != null && nKolace.get(nazev) != null)
            return String.format("%s %s jiz existuje...", druh, nazev);
        if (druh == "kolac") {
            nKolace.put(nazev, new Kolac(nazev, cena, suroviny, mnozstvi));
            return nKolace.get(nazev).toString();
        } else if (druh == "kava") {
            nKavy.put(nazev, new Kava(nazev, cena, suroviny, mnozstvi));
            return nKavy.get(nazev).toString();
        } else
            return "Byl spatne zadan druh produktu...";
    }

    /**
     * TODO dodelat vyrobu kolacu
     */
    public String vyrob(String nazev, int kolik) {
        if (nKolace.get(nazev) == null)
            return "Nebyl nalezen kolac...";
        Kolac kolac = nKolace.get(nazev);
        String vysledek = odectiZeSkladu(kolac, kolik);
        if (vysledek != "")
            return vysledek;
        skladSur.put(nazev, kolik);
        return String.format("Vyrobeno %d %s.", kolik, nazev);
    }

    public String prodej(String nazev) {
        return this.prodej(nazev, 1);
    }

    public String prodej(String nazev, int kolik) {
        float cena1 = 0;
        String output = "";
        // produkt neni v nabidce
        if (nKolace.get(nazev) == null && nKavy.get(nazev) == null)
            return String.format("Nebyl nalezen produkt %s!", nazev);
        // produkt je KAVA
        else if (nKavy.get(nazev) != null) {
            Kava kava = nKavy.get(nazev);
            HashMap<String, Integer> backup = new HashMap<String, Integer>(skladSur);// zaloha skladu se surovinami
            String vysledek = odectiZeSkladu(kava, kolik);
            if (vysledek != "")
                return vysledek;
            cena1 = kava.getCena();
        }
        // produkt je KOLAC
        else {
            if (skladSur.get(nazev) == null)
                return String.format("%s nenalezen na sklade.", nazev);
            int naSklade = skladSur.get(nazev);
            if (naSklade < kolik)
                return "Neni vyroben dostatek kolacu...";
            else if (naSklade == kolik)
                output += "Byl prodan posledni kolac!!";
            skladSur.put(nazev, naSklade - kolik);
            cena1 = nKolace.get(nazev).getCena();
        }
        pokladna.pridej(cena1 * kolik);
        return String.format("\nProdano: %d %s\nZauctovano: %f\n%s", kolik, nazev, cena1 * kolik, output);
    }

    public String vypisNabidku() {

        String output = "\n\nNAZEV\tCENA";
        for (Produkt produkt : nKavy.values())
            output += String.format("\n%s\t%f", produkt.getNazev(), produkt.getCena());

        for (Produkt produkt : nKolace.values())
            output += String.format("\n%s\t%f", produkt.getNazev(), produkt.getCena());

        return output;
    }

    public String zustatekPokladny() {
        return this.pokladna.toString();
    }

    // pridavani nove ingredience i doplnovani ingredience

    public String vypisSuroviny() {
        String output = "";
        for (String surovina : this.skladSur.keySet())
            output += String.format("\n%s\t%d", surovina, this.skladSur.get(surovina));

        return "\nNAZEV\tMNOZSTVI(g/ml)" + output;
    }
}

/*
 * KAVA: cappucino - espresso 30ml, mleko, mlecna pena late - espresso 30 ml,
 * mlecna pena espresso - 30 ml espressa, crema dopio - 2x espresso espresso
 * machiato - espresso, mlecna pena
 * 
 * KOLACE:
 * 
 */
