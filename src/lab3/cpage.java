package lab3;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
public final class cpage {    // класс який відповіда за коректний ввивід в юнікоді
    private static PrintWriter pr = null;
    private static BufferedReader br = null;
    static {
        try {
            pr = new PrintWriter(new OutputStreamWriter(System.out, "UTF-8"), true);
            br = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));
        } catch (UnsupportedEncodingException var1) {
            System.out.println(var1);
        }
    }
    public cpage() {
    }
            // Встановлення кодингу файла
    public static void setCp(String cp) {
        if (cp != null) {
            try {
                pr = new PrintWriter(new OutputStreamWriter(System.out, cp), true);
                br = new BufferedReader(new InputStreamReader(System.in, cp));
            } catch (UnsupportedEncodingException var2) {
                System.out.println(var2);
            }
        }
    }
    public static BufferedReader getIn() {
        return br;
    }
    public static PrintWriter getOut() {
        return pr;
    }
}
