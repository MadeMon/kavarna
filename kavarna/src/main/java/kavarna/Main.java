package kavarna;

class Main {
    static Kavarna k = new Kavarna();

    static void add() {
        System.out.println("\n__VKLADANI__");
        k.pridejSurovinu(new String[] { "mleko", "mouka", "cukr", "maslo", "olej", "cukr", "mak", "espresso" },
                new int[] { 5000, 6000, 3000, 4000, 1000, 2000, 500, 1000 });
        k.pridejSurovinu("kokos");
        k.pridejSurovinu("cokolada", 300);
        k.pridejSurovinu("mouka", 1111);
        k.pridejProdukt("kava", "espresso", 30.50f, new String[] { "espresso" }, new int[] { 30 });
        k.pridejProdukt("kava", "late", 50, new String[] { "espresso", "mleko" }, new int[] { 30, 20 });
        k.pridejProdukt("kolac", "makovak", 45, new String[] { "mouka", "olej", "cukr", "mak" },
                new int[] { 50, 10, 15, 20 });
    }

    public static void main(String[] args) {
        // k.load();
        add();

        // SKLAD
        System.out.println(k.vypisSklad());
        System.out.println("\n_Odebrane mleko - 134, kokos");
        // --Odebirani ze skladu
        k.odeberSurovinu("mleko", 134);
        k.odeberSurovinu("kokos");
        System.out.println(k.vypisSklad());

        // NABIDKA
        System.out.println(k.vypisNabidku());
        // --Odebirani
        System.out.println("\n_Odebirame z nabidky late");
        k.odeberProdukt("late");
        System.out.println(k.vypisNabidku());
        // --Vyroba
        System.out.println("\n_Vyrabim 2 makovaky");
        k.vyrob("makovak", 2);
        System.out.println(k.vypisSklad());
        // PRODEJ
        System.out.println(k.vypisPokladnu());
        System.out.println("\n__PRODEJ__\n_Prodavame 2 espressa a 1 makovak");
        k.prodej("espresso", 2);
        k.prodej("makovak", 1);
        System.out.println(k.vypisPokladnu());
        System.out.println(k.vypisSklad());
        // k.save();

    }
}
