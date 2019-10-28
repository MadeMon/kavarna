package kavarna;

/**
 *
 * @author Matěj Kubík
 */
public class Kava extends Produkt {
    // "mnozstvi" je pocet kav na ktere jsou namleta kavova zrna

    public Kava(String nazev, float cena) {
        super(nazev, cena);
    }

    @Override
    public String vyrob(int pocet) {
        super.vyrob(pocet);
        return String.format("Melu kavova zrna na vyrobu %d %s...", pocet, this.nazev);
    }

    public String vyrob() {
        super.vyrob(1);
        return String.format("Melu kavova zrna na vyrobu 1 %s...", this.nazev);

    }

    // PRODAVANI
    @Override
    public String prodej(int pocet) {
        String problem = super.prodej(pocet);
        if (problem != "")
            return problem;
        return String.format("Prodavam %d salku %s...", pocet, this.nazev);
    }

    // PRODAVANI
    public String prodej() {
        String problem = super.prodej(1);
        if (problem != "")
            return problem;
        return String.format("Prodavam 1 salek %s...", this.nazev);
    }
}
