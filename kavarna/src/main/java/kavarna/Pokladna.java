package kavarna;

/**
 * @author Matěj Kubík
 */
class Pokladna {
    private float zustatek;

    public Pokladna(float zustatek) {
        this.zustatek = zustatek;
    }

    public float getZustatek() {
        return this.zustatek;
    }

    public boolean pridej(float kolik) {
        this.zustatek += kolik;
        return true;
    }

    public boolean vyber(float kolik) {
        this.zustatek -= kolik;
        return true;
    }

    @Override
    public String toString() {
        return String.format("\n\nZustatek v pokladne je: %f Kc", this.zustatek);
    }
};