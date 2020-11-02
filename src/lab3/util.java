package lab3;


import java.io.IOException;

public class util {
    public util() {
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

    public static short readShort(String text, short hb, short lb) throws NumberFormatException {
        short s = Short.parseShort(readString(text));
        if (s <= lb && s >= hb) {
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

    static String leftString(short i, int l) {
        return leftString("" + i, l);
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
}
