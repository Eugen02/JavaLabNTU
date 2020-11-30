package lab3;
public class PieceGood extends Product { // Об`єкт 2: Штучний товар
    private int minAmount;               // мінімальна кількість в оптовій партії
    private double priceOpt;             //оптова ціна одиниці
    public PieceGood() {                 // конструктор без параметрів
    }
    public PieceGood(int id, String name, int amount, double price, int minAmount, double priceOpt) {     // конструктор з параметрами
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
    // перегрузка toString
    public String toString() {
        return super.toString() + " " + this.minAmount + " " + this.priceOpt;
    }
    // перегрузка toString
    public String justString() {
        return "Штучный товар" + super.toString2();
    }
}
