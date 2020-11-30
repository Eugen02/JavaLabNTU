package lab4;


import java.io.PrintWriter;

public class ProductRepres {
    // класс допоміжних методів до Poduct.java
    static ProductRepres instance = null;
    private static PrintWriter pr = null;

    // використання формутування выводу до UTF-8
    private ProductRepres() {
        pr = cpage.getOut();
    }

    public static ProductRepres getInstance() {
        if (instance == null) {
            instance = new ProductRepres();
        }

        return instance;
    }

    // метод для встановлення значень змінних
    public boolean kbInput(Product a) {
        a.setId(Integer.parseInt(util.readString("Id")));
        a.setName(util.readString("iм'я"));
        a.setAmount(Integer.parseInt(util.readString("Количество")));
        a.setPrice(Double.parseDouble(util.readString("Цена")));
        try {
            if (a instanceof PrepackagedGoods) {
                this.kbInputPrepackagedGoods((PrepackagedGoods)a);
            }

            if (a instanceof WeightGood) {
                this.kbInputWeightGood((WeightGood)a);
            }

            if (a instanceof PieceGood) {
                this.kbInputPieceGood((PieceGood)a);
            }
        } catch (NumberFormatException var3) {
            pr.println("Помилка даних \n");
            return false;
        }

        pr.println("OK!\n");
        return true;
    }

    // метод для встановлення значень змінних для об'єкта PrepackagedGoods
    private void kbInputPrepackagedGoods(PrepackagedGoods a) throws NumberFormatException {
        a.setAmountInOnePackage(Integer.parseInt(util.readString("количество единиц в упоковке")));
        a.setAmountPackageInOnePart(Integer.parseInt(util.readString("минимальное количество упаковок в оптовой партии")));
        a.setPackagePrice(Integer.parseInt(util.readString("оптовая цена упаковки")));
    }

    // метод для встановлення значень змінних для об'єкта WeightGood
    private void kbInputWeightGood(WeightGood a) {
        a.setMinWeightOpt(Double.parseDouble(util.readString("минимальное вес оптовой партии")));
        a.setPriceOpt(Double.parseDouble(util.readString("оптовая цена единицы")));
    }

    // метод для встановлення значень змінних для об'єкта PieceGood
    private void kbInputPieceGood(PieceGood a) {
        a.setMinAmount(Integer.parseInt(util.readString("минимальное количество в оптовой партии")));
        a.setPriceOpt(Integer.parseInt(util.readString("оптовая цена единицы")));
    }

    // метод друку об'єкта "футляром"
    public void printCard(Product a) {
        pr.print("\nId              >" + a.getId());
        pr.print("\nIм'я            >" + a.getName());
        pr.print("\nКоличество      >" + a.getAmount());
        pr.print("\nЦена            >" + a.getPrice());

        if (a instanceof PrepackagedGoods) {
            this.printCardPrepackagedGoods((PrepackagedGoods)a);
        }

        if (a instanceof WeightGood) {
            this.printCardWeightGood((WeightGood)a);
        }

        if (a instanceof PieceGood) {
            this.printCardPieceGood((PieceGood)a);
        }

        pr.println();
    }

    // метод друку об'єкта "футляром", об'єкта PrepackagedGoods
    private void printCardPrepackagedGoods(PrepackagedGoods a) {
        pr.print("\nколичество единиц в упаковке                                 >" + a.getAmountInOnePackage());
        pr.print("\nминимальное количество упаковок в оптовой партии             >" + a.getAmountPackageInOnePart());
        pr.print("\nоптовая цена упаковки                                        >" + a.getPackagePrice());

    }

    // метод друку об'єкта "футляром", об'єкта WeightGood
    private void printCardWeightGood(WeightGood a) {
        pr.print("\nминимальное вес оптовой партии                               >" + a.getMinWeightOpt());
        pr.print("\nоптовая цена единицы                                         >" + a.getPriceOpt());

    }

    // метод друку об'єкта "футляром", об'єкта PieceGood
    private void printCardPieceGood(PieceGood a) {
        pr.print("\nминимальное количество в оптовой партии                      >" + a.getMinAmount());
        pr.print("\nоптовая цена единицы                                         >" + a.getPriceOpt());

    }

    // метод друку об'єкта строкою
    public void printLine(Product a) {
        pr.print(a.toString2() + " " + util.leftString(a.getPrice(), 4));
        if (a instanceof PrepackagedGoods) {
            this.printLinePredator((PrepackagedGoods)a);
        } else if (a instanceof WeightGood) {
            this.printLineHerbivore((WeightGood)a);
        } else if (a instanceof PieceGood) {
            this.printLineBird((PieceGood)a);
        } else {
            pr.println();
        }

    }

    // метод друку строкою, об'єкта PrepackagedGoods
    private void printLinePredator(PrepackagedGoods a) {
        pr.println(" " + util.leftString(a.getAmountInOnePackage(), 3) + " " + util.leftString(a.getAmountPackageInOnePart(), 5) + " " + util.leftString(a.getPackagePrice(), 4));
    }

    // метод друку строкою, об'єкта WeightGood
    private void printLineHerbivore(WeightGood a) {
        pr.println(" " + util.leftString(a.getMinWeightOpt(), 4) + " " + util.leftString(a.getPriceOpt(), 3));
    }

    // метод друку строкою, об'єкта PieceGood
    private void printLineBird(PieceGood a) {
        pr.println(" " + util.leftString(a.getMinAmount(), 3) + " " + util.leftString(a.getPriceOpt(), 3));
    }
}
