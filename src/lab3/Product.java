package lab3;


public abstract class Product {
    private int id;             //  код товару
    private String name;        //	назва товару
    private int amount;         //	кількість
    private double price;       //	продажна вартість одного товару

    Product() { //	конструктор з параметрами
        this.id = 1;
        this.name = "";
        this.amount= 0;
        this.price = 0.0;
    }

    Product(int id, String name, int amount, double price) {    //	конструктор з неповними параметрами
        this();
        this.id = id;
        this.name = name;
        this.amount= amount;
        this.price = price;
    }

    Product(int id, String name, int amount) {
        this(id, name, amount, 0.0);
    }    //	конструктор з неповними параметрами

    Product(int id, String name) {
        this(id, name, 0, 0.0);
    }    //	конструктор з неповними параметрами

    // get-set методи
    public int getId() {    return id; }

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

    public String toString() { // перегрузка методу toString
        return this.id + " " + this.name + " " + this.amount + " " + this.price;
    }

    public String toString2() { // перегрузка методу toString
        return util.leftString(this.id, 5) + " " + util.leftString(this.getName(), 12) + " " + this.getAmount();
    }

    public abstract String justString(); // перегрузка методу toString

    public static ProductRepres getTerminalRepres() {
        return ProductRepres.getInstance();
    } // "втсановлення зв'язку" з ProductRepres.java
}
