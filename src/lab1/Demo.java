package lab1;

public class Demo {
    public static void main (String argv[])
    {

        Product a1 = new Product();// створення об'єкту а1

        // встановлення змінної для використання методу ProductRepress
        ProductRepres ar = Product.getTerminalRepres();

        // встановлення значень змінних завдяки set методам
        a1.setId(1);
        a1.setName("Умка");
        a1.setAmount(19);
        a1.setPrice(39.99);
        // друкування строкою
        System.out.println(a1.getId()+" "+a1.getName()+" "+
                a1.getAmount()+" "+a1.getPrice());
        // Встановлення змінних завдяки конструктору
        Product a2 = new Product(2,"Рабiндранат",20,170.0);
        // друкування строкою
        System.out.println(a2);
        Product a3 = new Product(3,"Василiса",2003,47.0);
        Product a4 = new Product(4,"Крiстофер",2003,0.4);
        // друкування футляром
        ar.printCard(a3);
        ar.printCard(a4);
        Product a5 = new Product();
        // ведення значень з консолі
        if (!ProductRepres.kbInput(a5)) a5 = new Product();
        ar.printLine(a1);
        ar.printLine(a2);
        ar.printLine(a3);
        ar.printLine(a4);
        ar.printLine(a5);
    }
}
