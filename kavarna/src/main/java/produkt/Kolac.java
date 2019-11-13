// package kavarna;
package produkt;

/**
 *
 * @author Matěj Kubík
 */
public class Kolac extends Produkt {
    private int vyrobeno;

    public Kolac(String nazev, float cena, String[] suroviny, int[] mnozstvi) {
        super(nazev, cena, suroviny, mnozstvi);
    }

    public String vyrob(int pocet) {
        vyrobeno += pocet;
        return String.format("micham testo, pecu, vytvoreno %d %s ...", pocet, this.nazev);
    }

    public String vyrob() {
        vyrobeno++;
        return String.format("micham testo, pecu, vytvoren 1 %s ...", this.nazev);
    }

}
