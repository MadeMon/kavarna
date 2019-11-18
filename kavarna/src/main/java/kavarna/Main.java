package kavarna;

class Main {
    public static void main(String[] args) {
        Kavarna k = new Kavarna();
        k.load();
        /**
         * *Pridano pomoci k.load();
         */
        // String[] suroviny = { "mleko", "mouka", "cukr", "maslo", "olej", "cukr",
        // "mak", "espresso" };
        // int[] mnozstvi = { 5000, 6000, 3000, 4000, 1000, 2000, 500, 1000 };
        // k.pridejSurovinu(suroviny, mnozstvi);
        // k.pridejSurovinu("kokos");
        // k.pridejSurovinu("cokolada", 300);
        // System.out.println(k.vypisSklad());
        // k.odeberSurovinu("mleko", 134);
        // k.odeberSurovinu("kokos");

        // System.out.println(k.vypisSklad());
        // k.pridejSurovinu("mouka", 1111);
        // k.odeberSurovinu("maslo");
        // System.out.println(k.vypisSklad());
        // System.out.println(k.vypisSklad());
        // k.pridejProdukt("kava", "espresso", 30.50f, new String[] { "espresso" }, new
        // int[] { 30 });
        // k.pridejProdukt("kava", "late", 50, new String[] { "espresso", "mleko" }, new
        // int[] { 30, 20 });
        // k.pridejProdukt("kolac", "makovak", 45, new String[] { "mouka", "olej",
        // "cukr", "mak" },
        // new int[] { 50, 10, 15, 20 });

        System.out.println(k.vypisSklad());
        System.out.println(k.vypisNabidku());
        // k.save();

    }
}
