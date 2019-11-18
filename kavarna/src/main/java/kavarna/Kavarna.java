package kavarna;

// import java.util.HashMap;
import produkt.*;
import seznam.*;

/**
 * @author Matěj Kubík
 */
public class Kavarna {

    private Pokladna pokladna = new Pokladna(500);
    private Nabidka<Kava> nKava = new Nabidka<Kava>("nKava");// nabidka kavy
    private Nabidka<Kolac> nKolace = new Nabidka<Kolac>("nKolace");// nabidka kolacu
    private Sklad sklad = new Sklad("sklad"); // sklad se Surovinami

    public void pridejSurovinu(String nazev, int kolik) {
        sklad.pridej(nazev, kolik);
    }

    public void pridejSurovinu(String nazev) {
        sklad.pridej(nazev, 0);
    }

    public void pridejSurovinu(String[] nazvy, int[] kolik) {
        for (int i = 0; i < nazvy.length; i++)
            sklad.pridej(nazvy[i], kolik[i]);
    }

    public void odeberSurovinu(String nazev, int mnozstvi) {
        sklad.odeber(nazev, mnozstvi);
    }

    public void odeberSurovinu(String nazev) {
        sklad.odeber(nazev);
    }

    public String vypisSklad() {
        return this.sklad.toString();
    }

    public void pridejProdukt(String zarazeni, String nazev, float cena, String[] ingredience, int[] mnozstvi) {
        if (zarazeni == "kava")
            this.nKava.pridej(new Kava(nazev, cena, ingredience, mnozstvi));
        else if (zarazeni == "kolac")
            this.nKolace.pridej(new Kolac(nazev, cena, ingredience, mnozstvi));
    }

    public void odeberProdukt(String nazev) {
        this.nKava.odeber(nazev);
        this.nKolace.odeber(nazev);

    }

    public String vypisNabidku(String nabidka) {
        if (nabidka == "kava")
            return "\n\nKAVA\n\n" + this.nKava.toString();
        else if (nabidka == "kolace")
            return "\n\nKOLACE\n\n" + this.nKolace.toString();
        return "Spatne zadany nazev nabidky...";
    }

    public String vypisNabidku() {
        return this.vypisNabidku("kava") + this.vypisNabidku("kolace");
    }

    public void save() {
        sklad.save();
        nKava.save();
        nKolace.save();
        /**
         * TODO dopsat ostatni HashMapy
         */
    }

    public void load() {
        sklad.load();
        nKava.load();
        nKolace.load();
        /**
         * TODO dopsat ostatni HashMapy
         */
    }

    /**
     * !____________ Odtud je kod neupraveny____________
     */

    // private static final long serialVersionUID = 1L;

    // @Override
    // public Integer get(Object k) {
    // return containsKey(k) ? super.get(k) : 0;
    // }

    // };

    // public String serialize(String soubor) {
    // if (soubor == "nKava.txt")
    // return serialize(soubor, this.nKava);
    // else if (soubor == "skladSur.txt")
    // return serialize(soubor, this.skladSur);
    // return "jina chyba";
    // }

    // public void save() {
    // HashMap<String, Integer> map = new HashMap<String, Integer>(this.skladSur);
    // try {
    // FileOutputStream fos = new FileOutputStream("skladSur.ser");
    // ObjectOutputStream oos = new ObjectOutputStream(fos);
    // oos.writeObject(map);
    // oos.close();
    // fos.close();
    // System.out.printf("Serialized HashMap data is saved in hashmap.ser");
    // } catch (

    // IOException ioe) {
    // ioe.printStackTrace();
    // }
    // }

    // private String load() {

    // private void (map){

    // }
    // soubor += ".ser";
    // HashMap map;
    // if (soubor == "nKava.ser") {
    // map = this.nKava;
    // } else if (soubor == "skladSur.ser") {
    // return "";
    // }
    // return "Nejaka chyba";

    // try {
    // FileInputStream fis = new FileInputStream(soubor);
    // ObjectInputStream ois = new ObjectInputStream(fis);
    // map = (HashMap) ois.readObject();
    // ois.close();
    // fis.close();
    // System.out.println("deser" + map.get("mouka"));
    // return;
    // } catch (IOException ioe) {
    // ioe.printStackTrace();
    // return false;
    // } catch (ClassNotFoundException c) {
    // return false;
    // }

    // }

    // private String odectiZeSkladu(Produkt produkt, int kolik) {
    // HashMap<String, Integer> ingred = new HashMap<>();
    // for (String surovina : produkt.ingredience().keySet())
    // ingred.put(surovina, produkt.ingredience().get(surovina) * kolik);
    // return sklad.odeber(ingred);
    // }

    // public String pridejProdukt(String nazev, float cena, String druh, String[]
    // suroviny, int[] mnozstvi) {
    // if (nKava.get(nazev) != null && nKolace.get(nazev) != null)
    // return String.format("%s %s jiz existuje...", druh, nazev);
    // if (druh == "kolac") {
    // nKolace.put(nazev, new Kolac(nazev, cena, suroviny, mnozstvi));
    // return nKolace.get(nazev).toString();
    // } else if (druh == "kava") {
    // nKava.put(nazev, new Kava(nazev, cena, suroviny, mnozstvi));
    // return nKava.get(nazev).toString();
    // } else
    // return "Byl spatne zadan druh produktu...";
    // }

    // public String vyrob(String nazev, int kolik) {
    // if (nKolace.get(nazev) == null)
    // return "Nebyl nalezen kolac...";
    // Kolac kolac = nKolace.get(nazev);
    // String vysledek = odectiZeSkladu(kolac, kolik);
    // if (vysledek != "")
    // return vysledek;
    // skladSur.put(nazev, kolik);
    // return String.format("Vyrobeno %d %s.", kolik, nazev);
    // }

    // public String prodej(String nazev) {
    // return this.prodej(nazev, 1);
    // }

    // public String prodej(String nazev, int kolik) {
    // float cena1 = 0;
    // String output = "";
    // // produkt neni v nabidce
    // if (nKolace.get(nazev) == null && nKava.get(nazev) == null)
    // return String.format("Nebyl nalezen produkt %s!", nazev);
    // // produkt je KAVA
    // else if (nKava.get(nazev) != null) {
    // Kava kava = nKava.get(nazev);
    // HashMap<String, Integer> backup = new HashMap<String, Integer>(skladSur);//
    // zaloha skladu se surovinami
    // String vysledek = odectiZeSkladu(kava, kolik);
    // if (vysledek != "")
    // return vysledek;
    // cena1 = kava.getCena();
    // }
    // // produkt je KOLAC
    // else {
    // if (skladSur.get(nazev) == null)
    // return String.format("%s nenalezen na sklade.", nazev);
    // int naSklade = skladSur.get(nazev);
    // if (naSklade < kolik)
    // return "Neni vyroben dostatek kolacu...";
    // else if (naSklade == kolik)
    // output += "Byl prodan posledni kolac!!";
    // skladSur.put(nazev, naSklade - kolik);
    // cena1 = nKolace.get(nazev).getCena();
    // }
    // pokladna.pridej(cena1 * kolik);
    // return String.format("\nProdano: %d %s\nZauctovano: %f\n%s", kolik, nazev,
    // cena1 * kolik, output);
    // }

    // public String vypisNabidku() {

    // String output = "\n\nNAZEV\tCENA";
    // for (Produkt produkt : nKava.values())
    // output += String.format("\n%s\t%f", produkt.getNazev(), produkt.getCena());

    // for (Produkt produkt : nKolace.values())
    // output += String.format("\n%s\t%f", produkt.getNazev(), produkt.getCena());

    // return output;
    // }

    // public String zustatekPokladny() {
    // return this.pokladna.toString();
    // }

    // // pridavani nove ingredience i doplnovani ingredience

    // public String vypisSuroviny() {
    // String output = "";
    // for (String surovina : this.skladSur.keySet())
    // output += String.format("\n%s\t%d", surovina, this.skladSur.get(surovina));

    // return "\nNAZEV\tMNOZSTVI(g/ml)" + output;
    // }
}

/*
 * KAVA: cappucino - espresso 30ml, mleko, mlecna pena late - espresso 30 ml,
 * mlecna pena espresso - 30 ml espressa, crema dopio - 2x espresso espresso
 * machiato - espresso, mlecna pena
 * 
 * KOLACE:
 * 
 */
