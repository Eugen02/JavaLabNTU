package lab7;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class PieceGood extends Product {
    private int minAmount;
    private double priceOpt;

    public PieceGood() {
    }

    public PieceGood(int id, String name, int amount, double price, int minAmount, double priceOpt) {
        super(id, name, amount, price);
        this.minAmount = minAmount;
        this.priceOpt = priceOpt;
    }

    public int getMinAmount() {
        return minAmount;
    }

    public void setMinAmount(int minAmount) {
        this.minAmount = minAmount;
    }

    public double getPriceOpt() {
        return priceOpt;
    }

    public void setPriceOpt(double priceOpt) {
        this.priceOpt = priceOpt;
    }

    public String toString() {
        return super.toString() + " " + this.minAmount + " " + this.priceOpt;
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
        return "Штучный товар" + super.toString2();
    }

    public void writeTxt_(PrintWriter file) {
        file.println("type=PieceGood");
        file.println("minAmount=" + this.minAmount);
        file.println("priceOpt=" + this.priceOpt);
    }

    public static PieceGood readTxt_(String s) {
        PieceGood a = new PieceGood();
        String s3;
        if ((s3 = util.getValue(s, "minAmount")) != null) {
            a.setMinAmount(Integer.parseInt(s3));
        }
        if ((s3 = util.getValue(s, "priceOpt")) != null) {
            a.setPriceOpt(Double.parseDouble(s3));
        }
        return a;
    }

    public void writeData_(DataOutputStream file) throws IOException {
        file.writeUTF("PieceGood");
        file.writeInt(this.minAmount);
        file.writeDouble(this.priceOpt);
    }

    public static PieceGood readData_(DataInputStream file) throws IOException {
        PieceGood a = new PieceGood();
        a.minAmount = file.readInt();
        a.priceOpt = file.readDouble();
        return a;
    }




}
