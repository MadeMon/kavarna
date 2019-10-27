package kavarna;

import java.util.HashMap;
import java.util.Hashtable;

class Sklad<K,L> extends Hashtable<K,L>{
    // Odebrani urciteho mnozstvi produktu
    public void odeber(String nazev, int mnozstvi) {
        Produkt produkt = this.get(nazev);
        if (produkt != null) {
            produkt.zmenMnozstvi(-(mnozstvi));
            System.out.printf("\n produktu %s zbyva %d", nazev, produkt.getMnozstvi());
        } else
            System.out.println("Produkt nebyla nalezena...");
    }

    // Doplneni mnozstvi jiz ulozeneho produktu
    public void pridej(String nazev, int mnozstvi) {
        Produkt produkt = this.produkty.get(nazev);
        if (produkt != null) {
            produkt.zmenMnozstvi(+(mnozstvi));
            System.out.printf("\n produktu %s zbyva %d", nazev, produkt.getMnozstvi());
        } else
            System.out.println("Produkt nebyla nalezena...");
    }

    // Pridani noveho produktu
    public void pridej(Produkt produkt, int mnozstvi) {
        produkt.zmenMnozstvi(mnozstvi);
        this.produkty.put(produkt.getNazev(), produkt);
    }

    // Vypis mapy produkty
    public String toString() {
        String seznam = "\nPRODUKT\tCENA\tMNOZSTVI";
        for (String produkt : produkty.keySet()) {
            seznam += produkty.get(produkt).toString();
        }
        return seznam;
    }
}
