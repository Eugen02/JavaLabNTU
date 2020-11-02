package lab7;

import java.util.Vector;

public class util2 {
    public util2() {
    }

    public static short textMenu() {
        String[] menu = new String[]{"1 - вивести список;", "2 - детально елемент за номером;", "3 - додати елемент з клавiатури;", "4 - вилучити елемент за номером;", "5 - додати елемент з текстового файлу;", "6 - додати елемент з двiйкового файлу;", "7 - записати елемент у текстовий файл;", "8 - записати елемент у двiйковий файл;", "9 - сортування 1;", "10 - сортування 2;", "11 - зберегти колекцiю у файлi;", "12 - прочитати колекцiю з файла;"};
        return util.textMenu(menu);
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
            cpage.getOut().println(util.leftString(n + 1, 3) + " " + tmp.justString());
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
}
