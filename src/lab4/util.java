package lab4;
import java.io.IOException;

public class util { // клас який відповіда на коректне введення та вивід
    public util() {
    }

    // методи для зручного питання про введення даної змінної
    public static short readShort(String text, short lb, short hb) throws NumberFormatException {
        short s = Short.parseShort(readString(text));
        if (s <= hb && s >= lb) {
            return s;
        } else {
            throw new NumberFormatException();
        }
    }

    // методи редагування вивіду текста з лівого боку
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

    // методи для зручного питання про введення даної змінної
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
