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

    public Produkt(String nazev, float cena, String[] suroviny, int[] mnozstvi) {
        this.nazev = nazev;
        this.cena = cena;
        // prida jednotlive suroviny a jejich mnozstvi do HashMapy ingredience
        for (int i = 0; i < suroviny.length; i++)
            ingredience.put(suroviny[i], mnozstvi[i]);
    }

    public HashMap<String, Integer> ingredience() {
        return this.ingredience;
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