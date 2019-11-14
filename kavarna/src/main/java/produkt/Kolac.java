// package kavarna;
package produkt;

import java.util.HashMap;

/**
 *
 * @author Matěj Kubík
 */
public class Kolac extends Produkt {
    private int vyrobeno;

    public Kolac(String nazev, float cena, String[] suroviny, int[] mnozstvi) {
        super(nazev, cena, suroviny, mnozstvi);
    }

    public HashMap<String, Integer> ingredience(int pocet) {
        this.vyrobeno += pocet;
        return super.ingredience(pocet);
    }

    public HashMap<String, Integer> ingredience() {
        this.vyrobeno++;
        return super.ingredience();
    }

    public boolean odeber() {
        if (this.vyrobeno < 1)
            return false;
        this.vyrobeno--;
        return true;
    }

    public boolean odeber(int kolik) {
        if (this.vyrobeno < kolik)
            return false;
        this.vyrobeno -= kolik;
        return true;
    }

}
