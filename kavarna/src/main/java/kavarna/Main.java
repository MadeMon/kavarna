package kavarna;

class Main {
    public static void main(String[] args) {
        Kavarna k = new Kavarna();
        String[] suroviny = { "mleko", "mouka", "cukr", "maslo", "olej", "espresso" };
        int[] mnozstvi = { 5000, 6000, 3000, 4000, 1000, 1000 };
        k.pridejSurovinu(suroviny, mnozstvi);
        k.pridejSurovinu("mak");
        k.pridejSurovinu("mrkev", 500);

        String[] surovinyEspresso = { "espresso" };
        int[] mnozstviEspresso = { 30 };
        k.pridejProdukt("Espresso", 25.2f, "kava", surovinyEspresso, mnozstviEspresso);

        String[] surovinyMrkvak = { "mleko", "mrkev", "mouka", "cukr", "olej" };
        int[] mnozstviMrkvak = { 20, 20, 40, 10, 10 };
        k.pridejProdukt("Mrkvak", 40f, "kolac", surovinyMrkvak, mnozstviMrkvak);

        // k.pridejProdukt("Makovak", 40.2f, "kolac");
        // k.pridejProdukt("Mrkvak", 35.6f, "kolac");
        // k.pridejProdukt("Latte", 40f, "kava");
        // k.vyrob("Makovak", 3);
        // k.vyrob("Mrkvak", 6);
        // k.vyrob("Latte", 9);
        System.out.println(k.vypisNabidku());
        // System.out.println(k.prodej("Makovak", 5));
        // System.out.println(k.prodej("askldfjl", 5));
        // System.out.println(k.prodej("Latte", 2));
        // System.out.println(k.vypisNabidku());
        // System.out.println(k.zustatekPokladny());
        System.out.println(k.vypisSuroviny());
        System.out.println(k.prodej("Espresso", 2));
        System.out.println(k.vyrob("Mrkvak", 2));
        System.out.println(k.prodej("Mrkvak"));
        System.out.println(k.prodej("Espresso"));

        System.out.println(k.vypisSuroviny());
        System.out.println(k.zustatekPokladny());

    }
}