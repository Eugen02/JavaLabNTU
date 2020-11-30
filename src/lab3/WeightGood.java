package lab3;
public class WeightGood extends Product {   //Об'єкт 3: Ваговий товар
    private double minWeightOpt;            // мінімальне вага оптової партії
    private double priceOpt;                // оптова ціна одиниці
    public WeightGood() {                   // конструктор без параметрів
    }
    public WeightGood(int id, String name, int amount, double price, double minWeightOpt, double priceOpt) { // конструктор з параметрами
        super(id, name, amount, price);
        this.minWeightOpt = minWeightOpt;
        this.priceOpt = priceOpt;
    }
    // тетоди get-set
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
    // перегрузка toString
    public String toString() {
        return super.toString() + " " + this.minWeightOpt + " " + this.priceOpt;
    }
    // перегрузка toString
    public String justString() {
        return "Весовой товар " + super.toString2();
    }
}
