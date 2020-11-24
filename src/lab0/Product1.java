package lab0;


public class Product1 {
    private int id;
    private String name;
    private int amount;
    private double price;
    public Product1(){ }

    public Product1(int id, String name, int amount, double price) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.price = price;
    }

    public Product1(int id, String name, int amount) {
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
        return "Product1{" +
                "id="+ id+
                ", name='" + name + '\'' +
                ", amount=" + amount +
                ", price=" + price +
                '}';
    }

    public static void printCard(Product1 a)
    {
        System.out.print("\nID        >"+a.getId());
        System.out.print("\nIм'я      >"+a.getName());
        System.out.print("\nКількість >"+a.getAmount());
        System.out.print("\nЦіна      >"+a.getPrice());

        System.out.println();
    }

}
