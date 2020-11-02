package lab9;

import java.io.Serializable;
import java.util.Vector;

public abstract class Items extends Vector implements Serializable {
    public Items() {
    }

    public boolean save(String fname) {
        return util.save(fname, this);
    }

    public abstract boolean load(String var1);

    public abstract Item readData(String var1);

    public abstract Item readTxt(String var1);
}
