package lab1;

public class Demo {
    public static void main (String argv[])
    {
        Product a1 = new Product();
        ProductRepres ar = Product.getTerminalRepres();
        a1.setId(1);
        a1.setName("Умка");
        a1.setAmount(19);
        a1.setPrice(39.99);
        System.out.println(a1.getId()+" "+a1.getName()+" "+
                a1.getAmount()+" "+a1.getPrice());
        Product a2 = new Product(2,"Рабiндранат",20,170.0);
        System.out.println(a2);
        Product a3 = new Product(3,"Василiса",2003,47.0);
        Product a4 = new Product(4,"Крiстофер",2003,0.4);
        ar.printCard(a3);
        ar.printCard(a4);
        Product a5 = new Product();
        if (!ProductRepres.kbInput(a5)) a5 = new Product();
        ar.printLine(a1);
        ar.printLine(a2);
        ar.printLine(a3);
        ar.printLine(a4);
        ar.printLine(a5);
    }
}
