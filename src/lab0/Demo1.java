package lab0;


public class Demo1 {
    public static void main (String argv[])
    {
        Product1 a1 = new Product1();
        a1.setId(1);
        a1.setName("Умка");
        a1.setAmount(19);
        a1.setPrice(39.99);
        System.out.println(a1.getId()+" "+a1.getName()+" "+
                a1.getAmount()+" "+a1.getPrice());
        Product1 a2 = new Product1(2,"Рабiндранат",20,170.0);
        Product1 a3 = new Product1(3,"Василiса",2003,47.0);
        Product1 a4 = new Product1(4,"Крiстофер",2003,0.4);
        Product1.printCard(a1);
        Product1.printCard(a2);
        Product1.printCard(a3);
        Product1.printCard(a4);
    }
}
