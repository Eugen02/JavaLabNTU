package lab1;
import java.io.*;

public class Util {

    public static String readString(String text) {
        int rc = 0;
        byte[] ba = new byte[100];
        System.out.print("Введiть " + text + ">");
        System.out.flush();
        try {
            rc = System.in.read(ba);
        } catch (IOException e) {
        }
        return (new String(ba, 0, rc)).trim();
    }

    public static boolean readBoolean(String text)
            throws NumberFormatException {

        String s = readString(text + " (1-так/0-нi)");
        if (s.equals("0")) return false;
        else if (s.equals("1")) return true;
        else throw new NumberFormatException();
    }


    static String leftString(String s, int l) {
        if (s.length() > l) s = s.substring(0, l);
        else while (s.length() < l) s = s + ' ';
        return s;
    }
    static String leftString(double d,int l)
    {
        return leftString(""+d,l);
    }

    static String leftString(int i,int l)
    {
        return leftString(""+i,l);
    }

    static String leftString(short i,int l)
    {
        return leftString(""+i,l);
    }

}