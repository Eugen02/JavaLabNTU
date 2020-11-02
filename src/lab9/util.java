package lab9;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.Vector;

public class util {
    public util() {
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

    public static boolean strToBool(String s) {
        if (!s.equals("0") && !s.equals("ні") && !s.equals("нi") && !s.equals("no") && !s.equals("false")) {
            if (!s.equals("1") && !s.equals("так") && !s.equals("yes") && !s.equals("true")) {
                throw new NumberFormatException();
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public static Date strToDate(String s) {
        if (s.length() == 10 && s.charAt(4) == '-' && s.charAt(7) == '-') {
            int y = Integer.parseInt(s.substring(0, 4));
            int m = Integer.parseInt(s.substring(5, 7));
            int d = Integer.parseInt(s.substring(8));
            Date c = new Date(y, m, d);
            return c;
        } else {
            throw new NumberFormatException();
        }
    }

    public static boolean save(String fname, Object obj) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fname));
            oos.writeObject(obj);
            oos.close();
            return true;
        } catch (IOException var3) {
            cpage.getOut().println("Помилка в/в у файлi " + fname);
            return false;
        }
    }

    public static Object load(String fname) throws ClassNotFoundException {
        Object obj = null;
        ObjectInputStream oos = null;

        try {
            oos = new ObjectInputStream(new FileInputStream(fname));
            obj = oos.readObject();
            oos.close();
            return obj;
        } catch (IOException var4) {
            cpage.getOut().println("Помилка в/в у файлi " + fname);
            return null;
        }
    }

    public static void changeVect(Vector a, Vector b) {
        a.removeAllElements();

        for(int i = 0; i < b.size(); ++i) {
            a.add(b.elementAt(i));
        }

    }

    public static String DataToStr(Date d) {
        String s = leftString((int)d.getYear(), 4);
        String t1 = "" + d.getMonth();
        if (t1.length() < 2) {
            t1 = "0" + t1;
        }

        String t2 = "" + d.getDate();
        if (t2.length() < 2) {
            t2 = "0" + t2;
        }

        return s + "-" + t1 + "-" + t2;
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

    public static String readTextFile(String filename) {
        BufferedReader file = null;
        char[] v = new char[(int)(new File(filename)).length()];
        String s = null;

        try {
            file = new BufferedReader(new InputStreamReader(new FileInputStream(filename), cpage.getCp()));
            int rc = file.read(v);
            file.close();
            s = new String(v, 0, rc);
            return s;
        } catch (Exception var7) {
            cpage.getOut().println("I/O error");
            return null;
        }
    }

    public static short textMenu(String[] menu) {
        short op = -1;
        int n = menu.length;

        while(op < 0) {
            cpage.getOut().println("\n0 - вихiд;");

            for(int i = 0; i < n; ++i) {
                cpage.getOut().println(menu[i]);
            }

            try {
                op = readShort("вибiр", (short)0, (short)n);
            } catch (NumberFormatException var4) {
                cpage.getOut().println("Помилка вибору\n");
                op = -1;
            }
        }

        return op;
    }
}
