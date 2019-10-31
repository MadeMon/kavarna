// package kavarna;
package produkt;

/**
 *
 * @author Matěj Kubík
 */
public class Kolac extends Produkt {
    public Kolac(String nazev, float cena, String[] suroviny, int[] mnozstvi) {
        super(nazev, cena, suroviny, mnozstvi);
    }

    public String vyrob(int pocet) {
        super.vyrob(pocet);
        return String.format("micham testo, pecu, vytvoreno %d %s ...", pocet, this.nazev);
    }

    public String vyrob() {
        super.vyrob(1);
        return String.format("micham testo, pecu, vytvoren 1 %s ...", this.nazev);
    }

    public String prodej() {
        if (super.prodej(1) != "")
            return super.prodej(1);
        return String.format("Prodavam 1 %s", this.nazev);
    }
}
