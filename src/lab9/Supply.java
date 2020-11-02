package lab9;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

public class Supply implements Iproduct, Iprovider, Serializable {
    Product this_Product = null;
    Provider this_Provider = null;
    private String time = "";
    private int amountALL = 0;
    public Supply() {
    }

    public Product getAnimal() {
        return this.this_Product;
    }

    public void setProduct(Product a) throws ProductNotFreeException {
        if (a.isFree()) {
            throw new ProductNotFreeException(a);
        } else {
            this.this_Product = a;
        }
    }

    public Provider getCage() {
        return this.this_Provider;
    }

    public void setProvider(Provider c) throws ProviderNotFreeException {
        if (c.isFree()) {
            throw new ProviderNotFreeException(c);
        } else {
            this.this_Provider = c;
        }
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getAmountALL() {
        return amountALL;
    }

    public void setAmountALL(int amountALL) {
        this.amountALL = amountALL;
    }

    public String getProducttype() {
        if (this.this_Product instanceof PrepackagedGoods) {
            return "Расфасованый товар ";
        } else if (this.this_Product instanceof PieceGood) {
            return "Штучный товар";
        } else {
            return this.this_Product instanceof WeightGood ? "Весовой товар" : null;
        }
    }


    @Override
    public int getId() {
        return 0;
    }

    public void setId(int id) {
        this.this_Product.setId(id);
    }

    public int getid() {
        return this.this_Product.getId();
    }

    public void setName(String name) {
        this.this_Product.setName(name);
    }

    public String getName() {
        return this.this_Product.getName();
    }

    public void setAmount(int amount) {
        this.this_Product.setAmount(amount);
    }

    public int getAmount() {
        return this.this_Product.getAmount();
    }

    public void setPrice(int price) {
        this.this_Product.setPrice(price);
    }

    public double getPrice() {
        return this.this_Product.getPrice();
    }

    @Override
    public void setPrice(double price) {

    }


    public String getProviderName() {
        return this.this_Provider.getProviderName();
    }

    public void setProviderName(String providerName) {
        this.this_Provider.setProviderName(providerName);
    }

    @Override
    public String getAddress() {
        return null;
    }

    @Override
    public void setAddress(String address) {

    }

    public String getAdress() {
        return this.this_Provider.getAddress();
    }

    public void setAdress(String adress) {
        this.this_Provider.setAddress(adress);
    }

    public boolean isFree() {
        return false;
    }

    public void setFree(boolean free) {
    }

    public void setFree(String free) {
    }
    @Override
    public String toString2() {
        return util.leftString(this.this_Provider.getProviderName(), 20) + " " + this.getProducttype() + " " + util.leftString(this.this_Product.getId(), 4) + " " + util.leftString(this.this_Product.getName(), 12);
    }

    @Override
    public String toString() {
        return "Supply{" +
                "this_Product=" + this_Product +
                ", this_Provider=" + this_Provider +
                ", time='" + time + '\'' +
                ", amountALL=" + amountALL +
                '}';
    }

    public String justString() {
        return this.toString2();
    }

    public boolean writeTxt(String filename) {
        return false;
    }

    public boolean writeData(String filename) {
        ObjectOutputStream file = null;

        try {
            file = new ObjectOutputStream(new FileOutputStream(filename));
            file.writeObject(this);
            file.close();
            return true;
        } catch (IOException var4) {
            cpage.getOut().println("I/O error");
            return false;
        }
    }

    public static Supply readData(String fname) {
        Supply e = null;

        try {
            e = (Supply)util.load(fname);
            return e;
        } catch (ClassNotFoundException var3) {
            cpage.getOut().println("У файлi " + fname + " не мiститься клас Exhibit");
            return null;
        }
    }

    public int comp1(Item a) {
        return this.this_Product.comp1(((Supply)a).getAnimal());
    }

    public int comp2(Item a) {
        return this.this_Provider.comp1(((Supply)a).getCage());
    }

    public static Supply load(String fname) {
        Supply e = null;

        try {
            e = (Supply)util.load(fname);
        } catch (ClassNotFoundException var3) {
            cpage.getOut().println("У файлi " + fname + " не мiститься клас Exhibits");
            e = null;
        }

        return e;
    }
}