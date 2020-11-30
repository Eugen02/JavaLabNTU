package lab3;
public class PrepackagedGoods extends Product { //Об'єкт 4: Розфасований товар
    private int amountInOnePackage;            // кількість одиниць в упаковці
    private int amountPackageInOnePart;        // мінімальна кількість упаковок в оптовій партії
    private double packagePrice;               // оптова ціна упаковки
    public PrepackagedGoods() {                // конструктор без параметрів
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
    // перегрузка toString
    public String toString() {
        return super.toString() + " " + this.amountInOnePackage + " " + this.amountPackageInOnePart + " " + this.packagePrice;
    }
    // перегрузка toString
    public String justString() {
        return "Расфасованый товар  " + super.toString2();
    }
}
