package lab1;
// класс допоміжних методів до Poduct.java
public class ProductRepres {
    // використання патерну singleton
    private static ProductRepres instance=null;
    private ProductRepres() { }

    public static ProductRepres getInstance()
    {
        if (instance==null) instance=new ProductRepres();
        return instance;
    }
    // метод для встановлення значень змінних
    public static boolean kbInput(Product a)
    {
        a.setId(Integer.parseInt(Util.readString("ID")));
        a.setName(Util.readString("iм'я"));
        a.setAmount(Integer.parseInt(Util.readString("Кількість")));
        a.setPrice(Double.parseDouble(Util.readString("Цiна")));
        System.out.println("OK!\n");
        return true;  // повернення ознаки нормального введення
    }
             // метод друку об'єкта "футляром"
    public static void printCard(Product a)
    {
        System.out.print("\nID        >"+a.getId());
        System.out.print("\nIм'я      >"+a.getName());
        System.out.print("\nКількість >"+a.getAmount());
        System.out.print("\nЦіна      >"+a.getPrice());

        System.out.println();
    }
    // метод друку об'єкта строкою
    public static void printLine(Product a)
    {
        System.out.println(Util.leftString(a.getId(),6) +
                " "+Util.leftString(a.getName(),12) +
                " "+Util.leftString(a.getAmount(),8) +
                " "+Util.leftString(a.getPrice(),6));
    }
}

