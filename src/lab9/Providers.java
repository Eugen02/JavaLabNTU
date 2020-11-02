package lab9;

public class Providers extends Items {
    public Providers() {
    }

    public Provider elementAt(short n) {
        return (Provider)super.elementAt(n);
    }

    public boolean load(String fname) {
        Providers a = null;

        try {
            a = (Providers)util.load(fname);
        } catch (ClassNotFoundException var4) {
            cpage.getOut().println("У файлi " + fname + " не мiститься клас Cages");
            a = null;
        }

        if (a != null) {
            util.changeVect(this, a);
            return true;
        } else {
            return false;
        }
    }

    public Item readTxt(String fn) {
        return Provider.readTxt(fn);
    }

    public Item readData(String fn) {
        return Provider.readData(fn);
    }
}
