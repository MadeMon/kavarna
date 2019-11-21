package seznam;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;

abstract class Seznam<H> implements Serializable {
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

    public H get(String nazev) {
        return this.s.get(nazev);
    }

    public void save() {
        try {
            FileOutputStream fos = new FileOutputStream("save/" + this.name + ".ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(this.s);
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
            FileInputStream fis = new FileInputStream("save/" + this.name + ".ser");
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