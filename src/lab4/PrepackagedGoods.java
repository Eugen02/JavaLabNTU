package lab4;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class PrepackagedGoods extends Product {     //Об'єкт 4: Розфасований товар
    private int amountInOnePackage;                 // кількість одиниць в упаковці
    private int amountPackageInOnePart;             // мінімальна кількість упаковок в оптовій партії
    private double packagePrice;                    // оптова ціна упаковки
    public PrepackagedGoods() {                     // конструктор без параметрів
    }
    public PrepackagedGoods(int id, String name, int amount, double price, int amountInOnePackage, int amountPackageInOnePart, double packagePrice) { // конструктор з параметрами
        super(id, name, amount, price);
        this.amountInOnePackage = amountInOnePackage;
        this.amountPackageInOnePart = amountPackageInOnePart;
        this.packagePrice = packagePrice;
    }
    // тетоди get-set
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

    public String toString() { // перегрузка toString
        return super.toString() + " " + this.amountInOnePackage + " " + this.amountPackageInOnePart + " " + this.packagePrice;
    }

    public String justString() {
        return "Расфасованый товар  " + super.toString2();
    }    // перегрузка toString


    public void writeTxt_(PrintWriter file) { // клас який записує дані до текстового файла
        file.println("type=PrepackagedGoods");
        file.println("amountInOnePackage=" + this.amountInOnePackage);
        file.println("amountPackageInOnePart=" + this.amountPackageInOnePart);
        file.println("packagePrice=" + this.packagePrice);
    }

    public static PrepackagedGoods readTxt_(String s) { // клас який зчитує дані з текстового файла
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

    public void writeData_(DataOutputStream file) throws IOException {  // клас який записує дані до bin-файлу
        file.writeUTF("PrepackagedGoods");
        file.writeInt(this.amountInOnePackage);
        file.writeInt(this.amountPackageInOnePart);
        file.writeDouble(this.packagePrice);
    }

    public static PrepackagedGoods readData_(DataInputStream file) throws IOException { // клас який зчитує дані з bin-файлу
        PrepackagedGoods a = new PrepackagedGoods();
        a.amountInOnePackage = file.readInt();
        a.amountPackageInOnePart = file.readInt();
        a.packagePrice = file.readDouble();
        return a;
    }





}
