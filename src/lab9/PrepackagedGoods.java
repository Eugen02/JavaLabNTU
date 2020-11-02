package lab9;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class PrepackagedGoods extends Product {

    private int amountInOnePackage;
    private int amountPackageInOnePart;
    private double packagePrice;
    public PrepackagedGoods() {
    }

    public PrepackagedGoods(int id, String name, int amount, double price, int amountInOnePackage, int amountPackageInOnePart, double packagePrice) {
        super(id, name, amount, price);
        this.amountInOnePackage = amountInOnePackage;
        this.amountPackageInOnePart = amountPackageInOnePart;
        this.packagePrice = packagePrice;
    }

    public int getAmountInOnePackage() {
        return amountInOnePackage;
    }

    public void setAmountInOnePackage(int amountInOnePackage) {
        this.amountInOnePackage = amountInOnePackage;
    }

    public int getAmountPackageInOnePart() {
        return amountPackageInOnePart;
    }

    public void setAmountPackageInOnePart(int amountPackageInOnePart) {
        this.amountPackageInOnePart = amountPackageInOnePart;
    }

    public double getPackagePrice() {
        return packagePrice;
    }

    public void setPackagePrice(double packagePrice) {
        this.packagePrice = packagePrice;
    }

    public String toString() {
        return super.toString() + " " + this.amountInOnePackage + " " + this.amountPackageInOnePart + " " + this.packagePrice;
    }

    @Override
    public int comp1(Item var1) {
        return 0;
    }

    @Override
    public int comp2(Item var1) {
        return 0;
    }

    public String justString() {
        return "Расфасованый товар  " + super.toString2();
    }

    @Override
    public boolean isFree() {
        return false;
    }

    @Override
    public void setFree(boolean var1) {

    }

    @Override
    public void setFree(String var1) {

    }


    public void writeTxt_(PrintWriter file) {
        file.println("type=PrepackagedGoods");
        file.println("amountInOnePackage=" + this.amountInOnePackage);
        file.println("amountPackageInOnePart=" + this.amountPackageInOnePart);
        file.println("packagePrice=" + this.packagePrice);
    }

    public static PrepackagedGoods readTxt_(String s) {
        PrepackagedGoods a = new PrepackagedGoods();
        String s3;
        if ((s3 = util.getValue(s, "amountInOnePackage")) != null) {
            a.setAmountInOnePackage(Integer.parseInt(s3));
        }
        if ((s3 = util.getValue(s, "amountPackageInOnePart")) != null) {
            a.setAmountPackageInOnePart(Integer.parseInt(s3));
        }
        if ((s3 = util.getValue(s, "packagePrice")) != null) {
            a.setPackagePrice(Double.parseDouble(s3));
        }
        return a;
    }

    public void writeData_(DataOutputStream file) throws IOException {
        file.writeUTF("PrepackagedGoods");
        file.writeInt(this.amountInOnePackage);
        file.writeInt(this.amountPackageInOnePart);
        file.writeDouble(this.packagePrice);
    }

    public static PrepackagedGoods readData_(DataInputStream file) throws IOException {
        PrepackagedGoods a = new PrepackagedGoods();
        a.amountInOnePackage = file.readInt();
        a.amountPackageInOnePart = file.readInt();
        a.packagePrice = file.readDouble();
        return a;
    }





}
