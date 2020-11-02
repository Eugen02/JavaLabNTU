package lab3;


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

    public String justString() {
        return "Штучный товар" + super.toString2();
    }
}
