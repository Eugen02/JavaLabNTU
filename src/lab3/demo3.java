package lab3;
public class demo3 {
    public demo3() {
    }
    public static void main(String[] argv) {
        if (argv.length > 0) {        // перевід тексту до UTF-8
            cpage.setCp(argv[0]);
        }
        // створення об'єкту p1 з параметрами
        PrepackagedGoods p1 = new PrepackagedGoods(1,"firstPREPAC",10,100.0,100,3,10000.0);
        // встановлення змінної для використання методу ProductRepress
        ProductRepres ar = Product.getTerminalRepres();
        // створення об'єкту p2 з параметрами
        Product p2 = new PrepackagedGoods(2,"secondPREPAC",3,123.123,123,15,123123.12);
        // ведення значень з консолі
        PrepackagedGoods p3 = new PrepackagedGoods();
        if (!ar.kbInput(p3)) {
            p3 = new PrepackagedGoods();
        }
        // створення об'єкту h1 з параметрами
        WeightGood h1 = new WeightGood(3,"firstWEIGHT",654,453.45,0.3,400.0);
        // створення об'єкту h2 з параметрами
        Product h2 = new WeightGood(4,"secondWEIGHT", 432, 123,20.0,100);
        // ведення значень з консолі
        WeightGood h3 = new WeightGood();
        if (!ar.kbInput(h3)) {
            h3 = new WeightGood();
        }
        // створення об'єкту b1 з параметрами
        PieceGood b1 = new PieceGood(5,"firstPiece", 613,93.3,11,90);
        // створення об'єкту b2 з параметрами
        Product b2 = new PieceGood(6,"secondPiece", 161,80,3,70);
        // ведення значень з консолі
        PieceGood b3 = new PieceGood();
        if (!ar.kbInput(b3)) {
            b3 = new PieceGood();
        }
        // друкування футляром
        ar.printCard(p1);
        ar.printCard(p2);
        ar.printCard(p3);
        ar.printCard(h1);
        ar.printCard(h2);
        ar.printCard(h3);
        ar.printCard(b1);
        ar.printCard(b2);
        ar.printCard(b3);
        // друкування строкою
        cpage.getOut().println();
        ar.printLine(p1);
        ar.printLine(p2);
        ar.printLine(p3);
        ar.printLine(h1);
        ar.printLine(h2);
        ar.printLine(h3);
        ar.printLine(b1);
        ar.printLine(b2);
        ar.printLine(b3);
        // друкування строкою
        cpage.getOut().println();
        cpage.getOut().println(p1.justString());
        cpage.getOut().println(p2.justString());
        cpage.getOut().println(p3.justString());
        cpage.getOut().println(h1.justString());
        cpage.getOut().println(h2.justString());
        cpage.getOut().println(h3.justString());
        cpage.getOut().println(b1.justString());
        cpage.getOut().println(b2.justString());
        cpage.getOut().println(b3.justString());
    }
}
