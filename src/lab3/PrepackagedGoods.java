package lab3;


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

    public String justString() {
        return "Расфасованый товар  " + super.toString2();
    }
}
