package lab3;


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
}
