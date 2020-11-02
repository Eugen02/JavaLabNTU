package lab9;

public class Products extends Items {
    public Products() {
    }

    public Product elementAt(short n) {
        return (Product)super.elementAt(n);
    }

    public boolean load(String fname) {
        Products a = null;

        try {
            a = (Products)util.load(fname);
        } catch (ClassNotFoundException var4) {
            cpage.getOut().println("У файлi " + fname + " не мiститься клас Products");
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
        return Product.readTxt(fn);
    }

    public Item readData(String fn) {
        return Product.readData(fn);
    }
}
