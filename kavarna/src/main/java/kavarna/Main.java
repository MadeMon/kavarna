package kavarna;

import java.util.HashMap;

class Main {
    public static void main(String[] args) {
        // Produkt espresso = new Kava("espresso", 50);
        // Produkt makovak = new Kolac("Makovak",30);
        // System.out.println(makovak);
        
        // sklad.pridej(espresso, 3);
        // sklad.pridej("espresso",4);
        // sklad.pridej(makovak,10);
        // System.out.print(sklad);
        
        // prodej("Makovak",2);
        HashMap<String,Integer> map = new HashMap<>();
        map.put("kolo",4);
        map.put("brusle",3);
        map.put("kolo",3);
        System.out.println(map);
        System.out.print(map.get("kokos"));
    }
}