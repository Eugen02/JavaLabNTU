package lab4;


public class demo4 {
    public demo4() {
    }

    public static void main(String[] argv) {
        if (argv.length > 0) {
            cpage.setCp(argv[0]);
        }

        ProductRepres ar =  Product.getTerminalRepres();
        Product a =  Product.readTxt("amba.txt");
        ar.printLine(a);
        a =  Product.readTxt("sirko.txt");
        ar.printLine(a);
        a =  Product.readTxt("aun.txt");
        ar.printLine(a);
        a =  Product.readTxt("tendy.txt");
        ar.printLine(a);
        a =  Product.readTxt("lady.txt");
        ar.printLine(a);
        a =  Product.readTxt("batmen.txt");
        ar.printLine(a);
        System.out.println();
        a =  Product.readData("amba.bin");
        ar.printLine(a);
        a =  Product.readData("sirko.bin");
        ar.printLine(a);
        a =  Product.readData("aun.bin");
        ar.printLine(a);
        a =  Product.readData("tendy.bin");
        ar.printLine(a);
        a =  Product.readData("lady.bin");
        ar.printLine(a);
        a =  Product.readData("batmen.bin");
        ar.printLine(a);
    }
}
