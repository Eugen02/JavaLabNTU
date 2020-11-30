package lab1;

public class Product {
    private int id;             //  код товару
    private String name;        //	назва товару
    private int amount;         //	кількість
    private double price;       //	продажна вартість одного товару
    public Product(){ }         //	конструктор без параметру

    public Product(int id, String name, int amount, double price) {         	//	конструктор з параметрами
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.price = price;
    }

    public Product(int id, String name, int amount) {                           //	конструктор з неповними параметрами
        this.id = id;
        this.name = name;
        this.amount = amount;
        price = 0;
    }

        // get-set методи
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
    public String toString() {                      // перегрузка методу toString
        return "Product1{" +
                "id="+ id+
                ", name='" + name + '\'' +
                ", amount=" + amount +
                ", price=" + price +
                '}';
    }
    // "втсановлення зв'язку" з ProductRepres.java
    public static ProductRepres getTerminalRepres()
    {
        return ProductRepres.getInstance();
    }
}
