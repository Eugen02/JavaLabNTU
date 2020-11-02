package lab7;
import java.io.PrintWriter;

public class ProductRepres implements Repres {
    static ProductRepres instance = null;
    private static PrintWriter pr = null;

    private ProductRepres() {
        pr = cpage.getOut();
    }

    public static ProductRepres getInstance() {
        if (instance == null) {
            instance = new ProductRepres();
        }

        return instance;
    }
    @Override
    public boolean kbInput(Item ai) {
        Product a = (Product)ai;
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

    private void kbInputPrepackagedGoods(PrepackagedGoods a) throws NumberFormatException {
        a.setAmountInOnePackage(Integer.parseInt(util.readString("количество единиц в упоковке")));
        a.setAmountPackageInOnePart(Integer.parseInt(util.readString("минимальное количество упаковок в оптовой партии")));
        a.setPackagePrice(Integer.parseInt(util.readString("оптовая цена упаковки")));
    }

    private void kbInputWeightGood(WeightGood a) {
        a.setMinWeightOpt(Double.parseDouble(util.readString("минимальное вес оптовой партии")));
        a.setPriceOpt(Double.parseDouble(util.readString("оптовая цена единицы")));
    }

    private void kbInputPieceGood(PieceGood a) {
        a.setMinAmount(Integer.parseInt(util.readString("минимальное количество в оптовой партии")));
        a.setPriceOpt(Integer.parseInt(util.readString("оптовая цена единицы")));
    }

    public void printCard(Item ai) {
        Product a = (Product)ai;
        pr.print("\nId              >" + a.getId());
        pr.print("\nIм'я             >" + a.getName());
        pr.print("\nКоличество         >" + a.getAmount());
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

    private void printCardPrepackagedGoods(PrepackagedGoods a) {
        pr.print("\nколичество единиц в упаковке                                 >" + a.getAmountInOnePackage());
        pr.print("\nминимальное количество упаковок в оптовой партии             >" + a.getAmountPackageInOnePart());
        pr.print("\nоптовая цена упаковки                                        >" + a.getPackagePrice());

    }

    private void printCardWeightGood(WeightGood a) {
        pr.print("\nминимальное вес оптовой партии                               >" + a.getMinWeightOpt());
        pr.print("\nоптовая цена единицы                                         >" + a.getPriceOpt());

    }

    private void printCardPieceGood(PieceGood a) {
        pr.print("\nминимальное количество в оптовой партии                      >" + a.getMinAmount());
        pr.print("\nоптовая цена единицы                                         >" + a.getPriceOpt());

    }

    public void printLine(Item ai) {
        Product a = (Product)ai;
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

    private void printLinePredator(PrepackagedGoods a) {
        pr.println(" " + util.leftString(a.getAmountInOnePackage(), 3) + " " + util.leftString(a.getAmountPackageInOnePart(), 5) + " " + util.leftString(a.getPackagePrice(), 4));
    }

    private void printLineHerbivore(WeightGood a) {
        pr.println(" " + util.leftString(a.getMinWeightOpt(), 4) + " " + util.leftString(a.getPriceOpt(), 3));
    }

    private void printLineBird(PieceGood a) {
        pr.println(" " + util.leftString(a.getMinAmount(), 3) + " " + util.leftString(a.getPriceOpt(), 3));
    }

    public Item getInst() {
        String[] menu = new String[]{"1 - Расфасованный товар;", "2 - Весовой товар;", "3 - Штучный товар;"};
        int op = util.textMenu(menu);
        switch(op) {
            case 1:
                return new PrepackagedGoods();
            case 2:
                return new WeightGood();
            case 3:
                return new PieceGood();
            default:
                return null;
        }
    }
}
