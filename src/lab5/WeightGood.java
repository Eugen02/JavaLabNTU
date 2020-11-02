package lab5;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class WeightGood extends Product {

    private double minWeightOpt;
    private double priceOpt;

    public WeightGood() {
    }

    public WeightGood(int id, String name, int amount, double price, double minWeightOpt, double priceOpt) {
        super(id, name, amount, price);
        this.minWeightOpt = minWeightOpt;
        this.priceOpt = priceOpt;
    }

    public double getMinWeightOpt() {
        return minWeightOpt;
    }

    public void setMinWeightOpt(double minWeightOpt) {
        this.minWeightOpt = minWeightOpt;
    }

    public double getPriceOpt() {
        return priceOpt;
    }

    public void setPriceOpt(double priceOpt) {
        this.priceOpt = priceOpt;
    }

    public String toString() {
        return super.toString() + " " + this.minWeightOpt + " " + this.priceOpt;
    }

    public String justString() {
        return "Весовой товар " + super.toString2();
    }


    public void writeTxt_(PrintWriter file) {
        file.println("type=WeightGood");
        file.println("minWeightOpt=" + this.minWeightOpt);
        file.println("priceOpt=" + this.priceOpt);
    }

    public static WeightGood readTxt_(String s) {
        WeightGood a = new WeightGood();
        String s3;
        if ((s3 = util.getValue(s, "minWeightOpt")) != null) {
            a.setMinWeightOpt(Double.parseDouble(s3));
        }
        if ((s3 = util.getValue(s, "priceOpt")) != null) {
            a.setPriceOpt(Double.parseDouble(s3));
        }
        return a;
    }

    public void writeData_(DataOutputStream file) throws IOException {
        file.writeUTF("WeightGood");
        file.writeDouble(this.minWeightOpt);
        file.writeDouble(this.priceOpt);
    }

    public static WeightGood readData_(DataInputStream file) throws IOException {
        WeightGood a = new WeightGood();
        a.minWeightOpt = file.readDouble();
        a.priceOpt = file.readDouble();
        return a;
    }



}
