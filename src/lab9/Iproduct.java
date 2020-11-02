package lab9;


public interface Iproduct extends Item {

    public int getId();

    public void setId(int id);

    public String getName();

    public void setName(String name);

    public int getAmount();

    public void setAmount(int amount);

    public double getPrice();

    public void setPrice(double price);

    String toString();

    String toString2();

    boolean writeTxt(String var1);

    boolean writeData(String var1);

    int comp1(Item var1);

    int comp2(Item var1);

    String justString();
}
