/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kavarna;

/**
 *
 * @author mademon
 */
abstract class Produkt implements IProdukt {
    protected String nazev;
    protected float cena;
    protected int mnozstvi;

    public Produkt(String nazev, float cena) {
        this.nazev = nazev;
        this.cena = cena;
        this.mnozstvi = 0;
    }

    
    @Override
    public String prodej(int pocet) {
        if (this.mnozstvi < pocet)
        return String.format("Nedostatek %s na skladě!", this.nazev);
        this.mnozstvi -= pocet;
        return "";
    }

    @Override
    public String vyrob(int pocet) {
        this.mnozstvi += pocet;
        return "";
    }


    
    public boolean zmenMnozstvi(int mnozstvi) {
        this.mnozstvi += mnozstvi;
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
    public int getMnozstvi(){
        return this.mnozstvi;
    }
    public boolean setMnozstvi(int mnozstvi){
        this.mnozstvi = mnozstvi;
        return true;
    }

    public String toString() {
        return String.format("\n%s\t%f\t%d", this.nazev, this.cena, this.mnozstvi);
    }
}