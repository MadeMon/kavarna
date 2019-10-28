package kavarna;

/**
 *
 * @author Matěj Kubík
 */
public class Kolac extends Produkt {
    public Kolac(String nazev, float cena) {
        super(nazev, cena);
    }

    public String vyrob(int pocet) {
        super.vyrob(pocet);
        return String.format("micham testo, pecu, vytvoreno %d %s ...", pocet, this.nazev);
    }

    public String vyrob() {
        super.vyrob(1);
        return String.format("micham testo, pecu, vytvoren 1 %s ...", this.nazev);

    }

    @Override
    public String prodej(int pocet) {
        if (super.prodej(pocet) != "")
            return super.prodej(pocet);
        return String.format("Prodavam %d %s", pocet, this.nazev);
    }

    public String prodej() {
        if (super.prodej(1) != "")
            return super.prodej(1);
        return String.format("Prodavam 1 %s", this.nazev);
    }
}
