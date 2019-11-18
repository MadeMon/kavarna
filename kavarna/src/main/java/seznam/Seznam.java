package seznam;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

abstract class Seznam<H> {
    protected HashMap<String, H> s;
    protected String name;

    public Seznam(String name) {
        this.name = name;
        this.s = new HashMap<>();
    }

    public boolean odeber(String nazev) {
        this.s.remove(nazev);
        return true;
    }

    public void save() {
        HashMap<String, H> map = new HashMap<>(this.s);
        System.out.println("\nserialization length: " + this.s.size());
        try {
            FileOutputStream fos = new FileOutputStream(this.name + ".ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(map);
            oos.close();
            fos.close();
            return;
        } catch (IOException ioe) {
            ioe.printStackTrace();
            return;
        }
    }

    public void load() {
        try {
            FileInputStream fis = new FileInputStream(this.name + ".ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            this.s = (HashMap) ois.readObject();
            ois.close();
            fis.close();
            return;
        } catch (IOException ioe) {
            ioe.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("ClassNotFound");
            return;
        }

    }

}