/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kavarna;

import java.util.HashMap;

/**
 *
 * @author mademon
 */
public class Kavarna {

    public HashMap<String, Produkt> sklad = new HashMap<String, Produkt>();
    public Pokladna pokladna = new Pokladna(500);

    public String pridejProdukt(String nazev, float cena, String druh) {
        Produkt produkt;
        if (druh == "kolac")
            produkt = new Kolac(nazev, cena);
        else if (druh == "kava")
            produkt = new Kava(nazev, cena);
        else
            return "Byl spatne zadan druh produktu...";
        sklad.put(nazev, produkt);
        return produkt.toString();

    }

    public String prodej(String nazev, int kolik) {
        Produkt produkt = sklad.get(nazev);
        System.out.print("\n\nvybrany: " + produkt);
        if (produkt != null) {
            pokladna.pridej(produkt.getCena() * kolik);
            return produkt.prodej(kolik);
        }
        return "Nebyl nalezen zadany produkt!";
    }

}

/*
 * KAVA: cappucino - espresso 30ml, mleko, mlecna pena late - espresso 30 ml,
 * mlecna pena espresso - 30 ml espressa, crema dopio - 2x espresso espresso
 * machiato - espresso, mlecna pena
 * 
 * KOLACE:
 * 
 */
