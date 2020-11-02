package lab9;


import java.util.Vector;

public class util2 {
    public util2() {
    }

    public static short textMenu() {
        String[] menu = new String[]{"1 - вивести список;", "2 - детально елемент за номером;", "3 - додати елемент з клавiатури;", "4 - вилучити елемент за номером;", "5 - додати елемент з текстового файлу;", "6 - додати елемент з двiйкового файлу;", "7 - записати елемент у текстовий файл;", "8 - записати елемент у двiйковий файл;", "9 - сортування 1;", "10 - сортування 2;", "11 - зберегти колекцiю у файлi;", "12 - прочитати колекцiю з файла;"};
        return util.textMenu(menu);
    }

    public static void monitorE(Supplys e, Products a, Providers с) {
        String[] menu = new String[]{"1 - вивести список;", "2 - детально про тварину за номером експозицiї;", "3 - детально при приміщення за номером експозицiї;", "4 - створити нову експозицiю;", "5 - вилучити експозицiю за номером;", "6 - додати елемент з файла;", "7 - записати елемент у файл;", "8 - прочитати колекцiю з файла;", "9 - зберегти колекцiю у файлi;"};
        Repres tmpr = null;
        String s = null;
        Item tmpi1 = null;

        Supply tmpe = new Supply();
        Object var10 = null;

        while(true) {
            short op;
            label75:
            while((op = util.textMenu(menu)) > 0) {
                short num;
                Provider tmpi;
                switch(op) {
                    case 0:
                        boolean var15 = true;
                        break;
                    case 1:
                        int i = 0;

                        while(true) {
                            if (i >= e.size()) {
                                continue label75;
                            }

                            cpage.getOut().println(util.leftString(i + 1, 3) + " " + ((Supply)e.elementAt(i)).toString2());
                            ++i;
                        }
                    case 2:
                        if ((num = util.getNum(e)) >= 0) {
                            tmpe = e.elementAt(num);
                            Repres tmpr1 = Product.getTerminalRepres();
                            tmpi1 = tmpe.getAnimal();
                            tmpr1.printCard(tmpi1);
                        }
                        break;
                    case 3:
                        if ((num = util.getNum(e)) >= 0) {
                            tmpe = e.elementAt(num);
                            tmpr = Provider.getTerminalRepres();
                            tmpi1 = tmpe.getCage();
                            tmpr.printCard(tmpi1);
                        }
                        break;
                    case 4:
                        num = 1;
                        --num;
                        tmpi1 = a.elementAt(num);

                        try {
                            tmpe.setProduct((Product) tmpi1);
                        } catch (ProductNotFreeException var14) {
                            continue ;
                        }

                        num = util.readShort("номер примiщення", (short)1, (short)с.size());
                        --num;
                        tmpi1 = с.elementAt(num);

                        try {
                            tmpe.setProvider((Provider) tmpi1);
                        } catch (ProviderNotFreeException var13) {
                            continue;
                        }

                        s = util.readString("дату");

                        try {
                            tmpe.setProviderName(util.leftString(s, 10));
                        } catch (NumberFormatException var12) {
                            break;
                        }

                        tmpe.getAnimal().setFree(false);
                        tmpe.getCage().setFree(false);
                        e.add(tmpe);
                        cpage.getOut().println("OK!");
                        break;
                    case 5:
                        if ((num = util.getNum(e)) >= 0) {
                            tmpe = e.elementAt(num);
                            tmpe.getAnimal().setFree(true);
                            tmpe.getCage().setFree(true);
                            e.removeElementAt(num);
                            cpage.getOut().println("OK!");
                        }
                        break;
                    case 6:
                        if ((s = util.getFileName(true)) != null) {
                            tmpe = Supply.load(s);
                            e.add(tmpe);
                            cpage.getOut().println("OK!");
                        }
                        break;
                    case 7:
                        if ((num = util.getNum(e)) >= 0) {
                            tmpe = e.elementAt(num);
                            if ((s = util.getFileName(false)) != null && util.save(s, tmpe)) {
                                cpage.getOut().println("OK!");
                            }
                        }
                        break;
                    case 8:
                        if ((s = util.getFileName(true)) != null && e.load(s)) {
                            cpage.getOut().println("OK!");
                        }
                        break;
                    case 9:
                        if ((s = util.getFileName(false)) != null) {
                            util.save(s, e);
                            cpage.getOut().println("OK!");
                        }
                }
            }

            cpage.getOut().println("Роботу закiнчено");
            return;
        }
    }

    public static void sort(Vector v, int m) {
        boolean swap = true;
        int l = v.size() - 1;
        int cmp = 0;

        while(swap) {
            swap = false;

            for(int i = 0; i < l; ++i) {
                Item o1 = (Item)v.elementAt(i);
                Item o2 = (Item)v.elementAt(i + 1);
                if (m == 1) {
                    cmp = o1.comp1(o2);
                } else if (m == 2) {
                    cmp = o1.comp2(o2);
                }

                if (cmp > 0) {
                    v.setElementAt(o2, i);
                    v.setElementAt(o1, i + 1);
                    swap = true;
                }
            }
        }

    }

    public static void list(Vector a) {

        for(short n = 0; n < a.size(); ++n) {
            Item tmp = (Item)a.elementAt(n);
            cpage.getOut().print(util.leftString(n + 1, 3) + " ");
            if (tmp.isFree()) {
                cpage.getOut().print("* ");
            } else {
                cpage.getOut().print("  ");
            }

            cpage.getOut().println(tmp.justString());
        }

    }

    public static void deleteItem(Vector a) {
        short num;
        if ((num = util.getNum(a)) >= 0) {
            a.removeElementAt(num);
            cpage.getOut().println("OK!");
        }

    }

    public static void addFromText(Items a) {
        Item tmp;
        String s;
        if ((s = util.getFileName(true)) != null && (tmp = a.readTxt(s)) != null) {
            a.add(tmp);
            cpage.getOut().println("OK!");
        }

    }

    public static void addFromData(Items a) {
        Item tmp;
        String s;
        if ((s = util.getFileName(true)) != null && (tmp = a.readData(s)) != null) {
            a.add(tmp);
            cpage.getOut().println("OK!");
        }

    }

    public static void saveToText(Vector a) {
        short num;
        String s;
        if ((num = util.getNum(a)) >= 0 && (s = util.getFileName(false)) != null && ((Item)a.elementAt(num)).writeTxt(s)) {
            cpage.getOut().println("OK!");
        }

    }

    public static void saveToData(Vector a) {
        short num;
        String s;
        if ((num = util.getNum(a)) >= 0 && (s = util.getFileName(false)) != null && ((Item)a.elementAt(num)).writeData(s)) {
            cpage.getOut().println("OK!");
        }

    }

    public static void monitor(Items a, Repres ar) {
        short op;
        while((op = textMenu()) > 0) {
            switch(op) {
                case 0:
                    boolean var6 = true;
                    break;
                case 1:
                    list(a);
                    break;
                case 2:
                    short num;
                    if ((num = util.getNum(a)) >= 0) {
                        ar.printCard((Item)a.elementAt(num));
                    }
                    break;
                case 3:
                    Item tmp;
                    if ((tmp = ar.getInst()) != null && ar.kbInput(tmp)) {
                        a.add(tmp);
                    }
                    break;
                case 4:
                    deleteItem(a);
                    break;
                case 5:
                    addFromText(a);
                    break;
                case 6:
                    addFromData(a);
                    break;
                case 7:
                    saveToText(a);
                    break;
                case 8:
                    saveToData(a);
                    break;
                case 9:
                    sort(a, 1);
                    list(a);
                    break;
                case 10:
                    sort(a, 2);
                    list(a);
                    break;
                case 11:
                    if (a.save(util.getFileName(false))) {
                        cpage.getOut().println("OK!");
                    }
                    break;
                case 12:
                    String s;
                    if ((s = util.getFileName(true)) != null && a.load(s)) {
                        cpage.getOut().println("OK!");
                    }
            }
        }

        cpage.getOut().println("Роботу закiнчено");
    }
}
