package lab5;


public class ProductsRepres {
    public ProductsRepres() {
    }

    public static void monitor(Products a) {
        ProductRepres ar = Product.getTerminalRepres();

        while(true) {
            String s;
            Products b;
            do {
                label70:
                do {
                    short op;
                    while((op = util.textMenu()) > 0) {
                        short num;
                        Product tmp;
                        switch(op) {
                            case 0:
                                boolean var9 = true;
                                break;
                            case 1:
                                list(a);
                                break;
                            case 2:
                                if ((num = util.getNum(a)) >= 0) {
                                    ar.printCard(a.elementAt(num));
                                }
                                break;
                            case 3:
                                if ((tmp = getInst()) != null && ar.kbInput(tmp)) {
                                    a.add(tmp);
                                }
                                break;
                            case 4:
                                if ((num = util.getNum(a)) >= 0) {
                                    a.removeElementAt(num);
                                    cpage.getOut().println("OK!");
                                }
                                break;
                            case 5:
                                if ((s = util.getFileName(true)) != null) {
                                    if ((tmp = Product.readTxt(s)) != null) {
                                        a.add(tmp);
                                        cpage.getOut().println("OK!");
                                    } else {
                                        cpage.getOut().println("Помилка в/в у файлi " + s);
                                    }
                                }
                                break;
                            case 6:
                                if ((s = util.getFileName(true)) != null) {
                                    if ((tmp = Product.readData(s)) != null) {
                                        a.add(tmp);
                                        cpage.getOut().println("OK!");
                                    } else {
                                        cpage.getOut().println("Помилка в/в у файлi " + s);
                                    }
                                }
                                break;
                            case 7:
                                if ((num = util.getNum(a)) >= 0 && (s = util.getFileName(false)) != null && a.elementAt(num).writeTxt(s)) {
                                    cpage.getOut().println("OK!");
                                }
                                break;
                            case 8:
                                if ((num = util.getNum(a)) >= 0 && (s = util.getFileName(false)) != null && a.elementAt(num).writeData(s)) {
                                    cpage.getOut().println("OK!");
                                }
                                break;
                            case 9:
                                a.sort(1);
                                list(a);
                                break;
                            case 10:
                                a.sort(2);
                                list(a);
                                break;
                            case 11:
                                s = util.getFileName(false);
                                if (a.save(s)) {
                                    cpage.getOut().println("OK!");
                                }
                                break;
                            case 12:
                                continue label70;
                        }
                    }

                    return;
                } while((s = util.getFileName(true)) == null);
            } while((b = Products.load(s)) == null);

            a.removeAllElements();
            int i = 0;

            for(int l = b.size(); i < l; ++i) {
                a.add(b.elementAt(i));
            }

            cpage.getOut().println("OK!");
        }
    }

    private static void list(Products a) {
        for(short n = 0; n < a.size(); ++n) {
            Product tmp = a.elementAt(n);
            cpage.getOut().println(util.leftString(n + 1, 3) + " " + tmp.justString());
        }

    }

    private static Product getInst() {
        cpage.getOut().println("\nВиберiть тип:");
        cpage.getOut().println("1 - Штучный товар;");
        cpage.getOut().println("2 - Весовой товар;");
        cpage.getOut().println("3 - Расфасованный товар;");
        cpage.getOut().println("0 - вiдмова;");

        short op;
        try {
            op = util.readShort("вибiр", (short)0, (short)3);
        } catch (NumberFormatException var2) {
            cpage.getOut().println("Помилка вибору\n");
            return null;
        }

        if (op == 1) {
            return new PieceGood();
        } else if (op == 2) {
            return new WeightGood();
        } else {
            return op == 3 ? new PrepackagedGoods() : null;
        }
    }
}
