package kavarna;

import java.util.HashMap;

import produkt.*;

/**
 *
 * @author Matěj Kubík
 */
public class Kavarna {

    private HashMap<String, Produkt> skladProdukt = new HashMap<String, Produkt>();

    private HashMap<String, Integer> skladSuroviny = new HashMap<String, Integer>() {
        @Override
        public Integer get(Object k) {
            return containsKey(k) ? super.get(k) : 0;
        }
    };
    private Pokladna pokladna = new Pokladna(500);

    public String pridejProdukt(String nazev, float cena, String druh, String[] suroviny, int[] mnozstvi) {
        if (skladProdukt.get(nazev) != null)
            return String.format("%s %s jiz existuje...", druh, nazev);
        Produkt produkt;
        if (druh == "kolac")
            produkt = new Kolac(nazev, cena, suroviny, mnozstvi);
        else if (druh == "kava")
            produkt = new Kava(nazev, cena, suroviny, mnozstvi);
        else
            return "Byl spatne zadan druh produktu...";
        skladProdukt.put(nazev, produkt);
        return produkt.toString();
    }

    // public void vyrob(String nazev, int kolik) {
    // Produkt produkt = skladProdukt.get(nazev);
    // if (produkt == null)
    // System.out.println("Nebyl nalezen produkt");
    // produkt.vyrob(kolik);
    // }

    public String prodej(String nazev, int kolik) {
        String output = "";
        Produkt produkt = skladProdukt.get(nazev);
        if (produkt == null)
            return String.format("Nebyl nalezen produkt %s!", nazev);
        else if (produkt.getClass().getName() == "produkt.Kava") {
            for (String surovina : produkt.ingredience().keySet()) {
                if (produkt.ingredience().get(surovina) * kolik > skladSuroviny.get(surovina))
                    return ("Nedostatek " + surovina);
                else if (produkt.ingredience().get(surovina) == skladSuroviny.get(surovina))
                    output += String.format("Pozor, došla surovina %s!", surovina);
                skladSuroviny.put(surovina, skladSuroviny.get(surovina) - produkt.ingredience().get(surovina));
            }
            float cena = produkt.getCena() * kolik;
            pokladna.pridej(cena);
            return String.format("\nProdano: %d %s\nZauctovano: %f\n%s", kolik, nazev, cena, output);
        }
        return "Nastala neznama chyba!!";
    }

    public String vypisNabidku() {
        String output = "\n\nNAZEV\tCENA";
        for (Produkt produkt : skladProdukt.values()) {
            output += String.format("\n%s\t%f", produkt.getNazev(), produkt.getCena());
        }
        return output;
    }

    public String zustatekPokladny() {
        return this.pokladna.toString();
    }

    // pridavani nove ingredience i doplnovani ingredience
    public void pridejSurovinu(String nazev, int kolik) {
        skladSuroviny.put(nazev, skladSuroviny.get(nazev) + kolik);
    }

    public void pridejSurovinu(String nazev) {
        skladSuroviny.put(nazev, skladSuroviny.get(nazev));
    }

    public void pridejSurovinu(String[] nazvy, int[] kolik) {
        for (int i = 0; i < nazvy.length; i++)
            skladSuroviny.put(nazvy[i], skladSuroviny.get(nazvy[i]) + kolik[i]);
    }

    public String vypisSuroviny() {
        String output = "";
        for (String surovina : this.skladSuroviny.keySet())
            output += String.format("\n%s\t%d", surovina, this.skladSuroviny.get(surovina));

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
