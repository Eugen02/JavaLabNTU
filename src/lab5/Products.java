package lab5;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Vector;

public class Products extends Vector implements Serializable {
    public Products() {
    }

    public Product elementAt(short n) {
        return (Product)super.elementAt(n);
    }

    public boolean save(String fname) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fname));
            oos.writeObject(this);
            oos.close();
            return true;
        } catch (IOException var3) {
            return false;
        }
    }

    public static Products load(String fname) {
        Products a = null;
        ObjectInputStream oos = null;

        try {
            oos = new ObjectInputStream(new FileInputStream(fname));
            a = (Products)oos.readObject();
            oos.close();
            return a;
        } catch (IOException var4) {
            cpage.getOut().println("Помилка в/в у файлі " + fname);
            return null;
        } catch (ClassNotFoundException var5) {
            cpage.getOut().println("У файлі " + fname + " не міститься клас Products");
            return null;
        }
    }

    public void sort(int mode) {
        boolean swap = true;
        int l = this.size() - 1;
        int cmp = 0;

        while(swap) {
            swap = false;

            for(int i = 0; i < l; ++i) {
                Product o1 = (Product)this.elementAt(i);
                Product o2 = (Product)this.elementAt(i + 1);
                if (mode == 1) {
                    cmp = o1.getName().compareTo(o2.getName());
                } else if (mode == 2) {
                    if (o1.getAmount() < o2.getAmount()) {
                        cmp = -1;
                    } else if (o1.getAmount() > o2.getAmount()) {
                        cmp = 1;
                    } else {
                        cmp = 0;
                    }
                }

                if (cmp > 0) {
                    this.setElementAt(o2, i);
                    this.setElementAt(o1, i + 1);
                    swap = true;
                }
            }
        }

    }
}
