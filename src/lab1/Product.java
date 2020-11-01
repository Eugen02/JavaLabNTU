package lab1;

public class Product {
    private int id;
    private String name;
    private int amount;
    private double price;
    public Product(){ }

    public Product(int id, String name, int amount, double price) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.price = price;
    }

    public Product(int id, String name, int amount) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        price = 0;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id="+ id+
                ", name='" + name + '\'' +
                ", amount=" + amount +
                ", price=" + price +
                '}';
    }

    public static ProductRepres getTerminalRepres()
    {
        return ProductRepres.getInstance();
    }


}
