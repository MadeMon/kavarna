package produkt;

// package kavarna;
import java.util.HashMap;

/**
 *
 * @author Matěj Kubík
 */
public abstract class Produkt implements IProdukt {
    protected String nazev;
    protected float cena;
    protected HashMap<String, Integer> ingredience = new HashMap<String, Integer>();

    public Produkt(String nazev, float cena, String[] ingredience, int[] mnozstvi) {
        this.nazev = nazev;
        this.cena = cena;
        // prida jednotlive suroviny a jejich mnozstvi do HashMapy ingredience
        for (int i = 0; i < ingredience.length; i++)
            this.ingredience.put(ingredience[i], mnozstvi[i]);
    }

    public HashMap<String, Integer> ingredience() {
        return this.ingredience;
    }

    public HashMap<String, Integer> ingredience(int pocet) {
        HashMap<String, Integer> output = new HashMap<String, Integer>();
        for (String surovina : this.ingredience.keySet())
            output.put(surovina, this.ingredience.get(surovina) * pocet);
        return output;
    }

    public float getCena() {
        return this.cena;
    };

    public String getNazev() {
        return this.nazev;
    };

    public boolean setCena(float cena) {
        this.cena = cena;
        return true;
    };

    public boolean setNazev(String nazev) {
        this.nazev = nazev;
        return true;
    };

    public String toString() {
        return String.format("\n%s\t%s", this.nazev, this.cena);
    }
}