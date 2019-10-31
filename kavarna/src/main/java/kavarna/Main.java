package kavarna;

import scala.Array;

class Main {
    public static void main(String[] args) {
        Kavarna k = new Kavarna();
        String[] suroviny = { "mleko", "mouka", "cukr", "maslo", "olej", "espresso" };
        int[] mnozstvi = { 5000, 6000, 3000, 4000, 1000, 1000 };
        k.pridejIngredienci(suroviny, mnozstvi);
        String[] surovinyEspresso = { "espresso" };
        int[] mnozstviEspresso = { 30 };
        k.pridejProdukt("espresso", 25.2f, "kava", surovinyEspresso, mnozstviEspresso);
        // k.pridejProdukt("Makovak", 40.2f, "kolac");
        // k.pridejProdukt("Mrkvak", 35.6f, "kolac");
        // k.pridejProdukt("Latte", 40f, "kava");

        k.vyrob("espresso", 4);
        // k.vyrob("Makovak", 3);
        // k.vyrob("Mrkvak", 6);
        // k.vyrob("Latte", 9);
        System.out.println(k.vypisNabidku());
        System.out.println(k.prodej("Makovak", 5));
        System.out.println(k.prodej("askldfjl", 5));
        System.out.println(k.prodej("Latte", 2));
        System.out.println(k.vypisNabidku());
        System.out.println(k.zustatekPokladny());

    }
}