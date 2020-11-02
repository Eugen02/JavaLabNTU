package lab9;


public class Supplys extends Items {
    public Supplys() {
    }

    public Supply elementAt(short n) {
        return (Supply)super.elementAt(n);
    }

    public Item readTxt(String a) {
        return null;
    }

    public Item readData(String a) {
        return null;
    }

    public boolean load(String fname) {
        Supplys a = null;

        try {
            a = (Supplys)util.load(fname);
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
}
