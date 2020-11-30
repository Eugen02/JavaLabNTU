package lab4;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class PieceGood extends Product {// Об`єкт 2: Штучний товар
    private int minAmount;              // мінімальна кількість в оптовій партії
    private double priceOpt;            //оптова ціна одиниці
    public PieceGood() {                // конструктор без параметрів
    }

    public PieceGood(int id, String name, int amount, double price, int minAmount, double priceOpt) {// конструктор з параметрами
        super(id, name, amount, price);
        this.minAmount = minAmount;
        this.priceOpt = priceOpt;
    }
    // тетоди get-set
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
    } // перегрузка toString

    public String justString() {
        return "Штучный товар" + super.toString2();
    } // перегрузка toString

    public void writeTxt_(PrintWriter file) { // клас який записує дані до текстового файла
        file.println("type=PieceGood");
        file.println("minAmount=" + this.minAmount);
        file.println("priceOpt=" + this.priceOpt);
    }

    public static PieceGood readTxt_(String s) { // клас який зчитує дані з текстового файла
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

    public void writeData_(DataOutputStream file) throws IOException {  // клас який записує дані до bin-файлу
        file.writeUTF("PieceGood");
        file.writeInt(this.minAmount);
        file.writeDouble(this.priceOpt);
    }

    public static PieceGood readData_(DataInputStream file) throws IOException { // клас який зчитує дані з bin-файлу
        PieceGood a = new PieceGood();
        a.minAmount = file.readInt();
        a.priceOpt = file.readDouble();
        return a;
    }




}
