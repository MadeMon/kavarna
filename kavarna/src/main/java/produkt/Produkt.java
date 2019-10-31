package produkt;

import java.lang.reflect.Array;
// package kavarna;
import java.util.HashMap;

/**
 *
 * @author Matěj Kubík
 */
public abstract class Produkt implements IProdukt {
    protected String nazev;
    protected float cena;
    protected int pocet;

    protected HashMap<String, Integer> ingredience = new HashMap<String, Integer>();

    public Produkt(String nazev, float cena, String[] suroviny, int[] mnozstvi) {
        this.nazev = nazev;
        this.cena = cena;
        this.pocet = 0;
        // prida jednotlive suroviny a jejich mnozstvi do HashMapy ingredience
        for (int i = 0; i < suroviny.length; i++)
            ingredience.put(suroviny[i], mnozstvi[i]);
    }

    public String prodej(int kolik) {
        if (this.pocet < kolik)
            return "nedostatek";
        this.pocet -= kolik;
        return "";
    }

    @Override
    public String vyrob(int kolik) {
        this.pocet += kolik;
        return "";
    }

    public boolean zmenPocet(int pocet) {
        this.pocet += pocet;
        return true;
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

    public int getPocet() {
        return this.pocet;
    }

    public boolean setPocet(int pocet) {
        this.pocet = pocet;
        return true;
    }

    public String toString() {
        return String.format("\n%s\t%s\t%d", this.nazev, this.cena, this.pocet);
    }
}