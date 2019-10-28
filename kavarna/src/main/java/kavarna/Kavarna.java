package kavarna;

import java.util.HashMap;

import produkt.*;

/**
 *
 * @author Matěj Kubík
 */
public class Kavarna {

    private HashMap<String, Produkt> sklad = new HashMap<String, Produkt>();
    private Pokladna pokladna = new Pokladna(500);

    public String pridejProdukt(String nazev, float cena, String druh) {
        if (sklad.get(nazev) != null)
            return String.format("%s %s jiz existuje...", druh, nazev);
        Produkt produkt;
        if (druh == "kolac")
            produkt = new Kolac(nazev, cena);
        else if (druh == "kava")
            produkt = new Kava(nazev, cena);
        else
            return "Byl spatne zadan druh produktu...";
        sklad.put(nazev, produkt);
        return produkt.toString();

    }

    public void vyrob(String nazev, int kolik) {
        Produkt produkt = sklad.get(nazev);
        if (produkt == null)
            System.out.println("Nebyl nalezen produkt");
        produkt.vyrob(kolik);
    }

    public String prodej(String nazev, int kolik) {
        Produkt produkt = sklad.get(nazev);
        if (produkt == null)
            return String.format("Nebyl nalezen produkt %s!", nazev);
        String vysledek = produkt.prodej(kolik);
        if (vysledek == "nedostatek") {
            return String.format("Nedostatek %s na sklade, zbyva %d...", nazev, produkt.getMnozstvi());
        } else if (produkt.prodej(kolik) == "") {
            pokladna.pridej(produkt.getCena() * kolik);
            return String.format("Tady mate %d %s", kolik, nazev);
        } else
            return "Nastala neznama chyba...";

    }

    public String vypisNabidku() {
        String output = "\n\nNAZEV\tCENA\tMNOZSTVI";
        for (Produkt produkt : sklad.values()) {
            output += String.format("\n%s\t%f\t%d", produkt.getNazev(), produkt.getCena(), produkt.getMnozstvi());
        }
        return output;
    }

    public String zustatekPokladny() {
        return this.pokladna.toString();
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
