package kavarna;

import java.util.HashMap;

class Main {
    public static void main(String[] args) {
        Kavarna k = new Kavarna();
        k.pridejProdukt("espresso", 25.2f, "kava");
        k.pridejProdukt("Makovak", 40.2f, "kolac");
        k.pridejProdukt("Mrkvak", 35.6f, "kolac");
        k.pridejProdukt("Latte", 40f, "kava");
        k.vyrob("espresso", 4);
        k.vyrob("Makovak", 3);
        k.vyrob("Mrkvak", 6);
        k.vyrob("Latte", 9);
        System.out.print(k.vypisNabidku());
        k.prodej("Makovak", 5);
        k.prodej("Latte", 2);
        System.out.print(k.vypisNabidku());
        System.out.println(k.zustatekPokladny());
        // Produkt espresso = new Kava("espresso", 50);
        // Produkt makovak = new Kolac("Makovak",30);
        // System.out.println(makovak);

        // sklad.pridej(espresso, 3);
        // sklad.pridej("espresso",4);
        // sklad.pridej(makovak,10);
        // System.out.print(sklad);

        // prodej("Makovak",2);
    }
}