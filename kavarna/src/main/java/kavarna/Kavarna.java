package kavarna;

import java.util.HashMap;

import produkt.*;

/**
 *
 * @author Matěj Kubík
 */
public class Kavarna {

    private HashMap<String, Produkt> skladProdukt = new HashMap<String, Produkt>();
    private HashMap<String, Integer> skladIngredience = new HashMap<String, Integer>();
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

    public void vyrob(String nazev, int kolik) {
        Produkt produkt = skladProdukt.get(nazev);
        if (produkt == null)
            System.out.println("Nebyl nalezen produkt");
        produkt.vyrob(kolik);
    }

    public String prodej(String nazev, int kolik) {
        Produkt produkt = skladProdukt.get(nazev);
        if (produkt == null)
            return String.format("Nebyl nalezen produkt %s!", nazev);
/**
 * TODO aby se pri prodeji kava vyrobila a odecetly se ingredience ze skladu
 * TODO svytvorit classy pro sklad ingredienci a ingredience v Produktu
 */
        if (produkt.getClass().getName() == "Kava") {
            for(String surovina:produkt.getIngredience())
            skladIngredience.put(surovina,skladIngredience.get(surovina)-produkt.getIngredience())
        }
        String vysledek = produkt.prodej(kolik);
        if (vysledek == "nedostatek") {
            return String.format("Nedostatek %s na skladProdukte, zbyva %d...", nazev, produkt.getPocet());
        } else if (produkt.prodej(kolik) == "") {
            pokladna.pridej(produkt.getCena() * kolik);
            return String.format("Tady mate %d %s", kolik, nazev);
        } else
            return "Nastala neznama chyba...";

    }

    public String vypisNabidku() {
        String output = "\n\nNAZEV\tCENA\tMNOZSTVI";
        for (Produkt produkt : skladProdukt.values()) {
            output += String.format("\n%s\t%f\t%d", produkt.getNazev(), produkt.getCena(), produkt.getPocet());
        }
        return output;
    }

    public String zustatekPokladny() {
        return this.pokladna.toString();
    }

    // pridavani nove ingredience i doplnovani ingredience
    public void pridejIngredienci(String nazev, int kolik) {
        skladIngredience.put(nazev, skladIngredience.get(nazev) + kolik);
    }

    public void pridejIngredienci(String nazev) {
        skladIngredience.put(nazev, skladIngredience.get(nazev));
    }

    public void pridejIngredienci(String[] nazvy, int[] kolik) {
        for (int i = 0; i < nazvy.length; i++)
            skladIngredience.put(nazvy[i], skladIngredience.get(nazvy[i]) + kolik[i]);
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
