package seznam;

import java.util.HashMap;

public class Sklad extends Seznam<Integer> {
    public Sklad(String name) {
        super(name);
        this.s = new HashMap<>() {
            private static final long serialVersionUID = 1L;

            @Override
            public Integer get(Object k) {
                return containsKey(k) ? super.get(k) : 0;
            }
        };
    }

    public void pridej(String nazev, Integer hodnota) {
        this.s.put(nazev, this.s.get(nazev) + hodnota);
        // this.s.put(nazev, hodnota);
    }

    public boolean odeber(String nazev, int mnozstvi) {
        if (mnozstvi > this.s.get(nazev))
            return false;
        this.s.put(nazev, this.s.get(nazev) - mnozstvi);
        return true;
    }

    public boolean odeber(String nazev) {
        this.s.remove(nazev);
        return true;
    }

    public String odeber(HashMap<String, Integer> ingred) {
        String output = "";
        HashMap<String, Integer> backup = new HashMap<String, Integer>(this.s);// zaloha skladu se surovinami
        for (String surovina : ingred.keySet()) {
            if (ingred.get(surovina) > this.s.get(surovina)) {
                this.s = backup; // problem se surovinou -> sklad se vrati do stavu pred prodejem
                return ("Nedostatek / neexistuje " + surovina);
            } else if (ingred.get(surovina) == s.get(surovina))
                output += String.format("Pozor, došla surovina %s!", surovina);
            this.s.put(surovina, this.s.get(surovina) - ingred.get(surovina));
        }
        return output;
    }

    @Override
    public String toString() {
        String output = "\n\nSKLAD\tNAZEV\tMNOZSTVI";
        for (String nazev : this.s.keySet())
            output += String.format("\n%s\t%d", nazev, this.s.get(nazev));
        return output;
    }

    // public void save() {
    // HashMap<String, Integer> map = new HashMap<>(this.s);
    // System.out.println("ser: " + map.get("mouka"));
    // try {
    // FileOutputStream fos = new FileOutputStream(this.name + ".ser");
    // ObjectOutputStream oos = new ObjectOutputStream(fos);
    // oos.writeObject(map);
    // oos.close();
    // fos.close();
    // System.out.printf("Serialized HashMap");
    // return;
    // } catch (IOException ioe) {
    // ioe.printStackTrace();
    // return;
    // }
    // }

}
