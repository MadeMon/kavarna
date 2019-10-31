// package kavarna;
package produkt;

/**
 *
 * @author Matěj Kubík
 */
public class Kava extends Produkt {
    public Kava(String nazev, float cena, String[] suroviny, int[] mnozstvi) {
        super(nazev, cena, suroviny, mnozstvi);
    }

    // PRODAVANI
    public String prodej() {
        String problem = super.prodej(1);
        if (problem != "")
            return problem;
        return String.format("Prodavam 1 salek %s...", this.nazev);
    }
}
