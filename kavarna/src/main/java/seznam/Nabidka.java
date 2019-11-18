package seznam;

import produkt.*;

public class Nabidka<T extends Produkt> extends Seznam<T> {

    public Nabidka(String name) {
        super(name);
    }

    public void pridej(T produkt) {
        this.s.put(produkt.getNazev(), produkt);
    }

    public void pridej(T[] produkty) {
        for (T produkt : produkty)
            this.pridej(produkt);
    }

    @Override
    public String toString() {
        String output = "NAZEV\tCENA";
        for (T produkt : this.s.values())
            output += produkt.toString();
        return output;
    }

}