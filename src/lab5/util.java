package lab5;

import java.io.File;
import java.io.IOException;
import java.util.Vector;

public class util {
    public util() {
    }

    public static short readShort(String text, short lb, short hb) throws NumberFormatException {
        short s = Short.parseShort(readString(text));
        if (s <= hb && s >= lb) {
            return s;
        } else {
            throw new NumberFormatException();
        }
    }

    static String leftString(String s, int l) {
        if (s.length() > l) {
            s = s.substring(0, l);
        } else {
            while(s.length() < l) {
                s = s + ' ';
            }
        }

        return s;
    }

    static String leftString(double d, int l) {
        return leftString("" + d, l);
    }

    static String leftString(int i, int l) {
        return leftString("" + i, l);
    }

    static String leftString(short s, int l) {
        return leftString("" + s, l);
    }

    static String leftString(boolean b, int l) {
        String s = null;
        if (b) {
            s = "так";
        } else {
            s = "нi";
        }

        return leftString(s, l);
    }

    static String getValue(String s, String name) {
        int i = s.indexOf(name);
        if (i >= 0 && s.charAt(i + name.length()) == '=') {
            String s2 = s.substring(i + name.length() + 1);
            i = s2.indexOf("\n") + 1;
            s2 = s2.substring(0, i - 2);
            return s2;
        } else {
            return null;
        }
    }

    public static short textMenu() {
        short op = -1;

        while(op < 0) {
            cpage.getOut().println("\n0 - вихiд;");
            cpage.getOut().println("1 - вивести список;");
            cpage.getOut().println("2 - детально елемент за номером;");
            cpage.getOut().println("3 - додати елемент з клавiатури;");
            cpage.getOut().println("4 - вилучити елемент за номером;");
            cpage.getOut().println("5 - додати елемент з текстового файлу;");
            cpage.getOut().println("6 - додати елемент з двiйкового файлу;");
            cpage.getOut().println("7 - записати елемент у текстовий файл;");
            cpage.getOut().println("8 - записати елемент у двiйковий файл;");
            cpage.getOut().println("9 - сортування 1;");
            cpage.getOut().println("10 - сортування 2;");
            cpage.getOut().println("11 - зберегти колекцiю у файлi;");
            cpage.getOut().println("12 - прочитати колекцiю з файла;");

            try {
                op = readShort("вибiр", (short)0, (short)12);
            } catch (NumberFormatException var2) {
                cpage.getOut().println("Помилка вибору\n");
                op = -1;
            }
        }

        return op;
    }

    public static String getFileName(boolean check) {
        String fname = readString("iм'я файла");
        if (check) {
            File f = new File(fname);
            if (!f.exists()) {
                cpage.getOut().println("Файл " + fname + " не iснує");
                fname = null;
            }
        }

        return fname;
    }

    public static short getNum(Vector v) {
        short s = (short)v.size();

        short n;
        try {
            n = readShort("номер елемента", (short)1, s);
        } catch (NumberFormatException var4) {
            cpage.getOut().println("Помилка у номерi");
            return -1;
        }

        return (short)(n - 1);
    }

    public static String readString(String text) {
        String ans = null;
        cpage.getOut().print("Введiть " + text + ">");
        cpage.getOut().flush();

        try {
            ans = cpage.getIn().readLine();
        } catch (IOException var3) {
        }

        return ans.trim();
    }

    public static boolean readBoolean(String text) throws NumberFormatException {
        String s = readString(text + " (1-так/0-нi)");
        if (s.equals("0")) {
            return false;
        } else if (s.equals("1")) {
            return true;
        } else {
            throw new NumberFormatException();
        }
    }
}
