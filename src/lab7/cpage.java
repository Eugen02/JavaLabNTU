package lab7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public final class cpage {
    private static PrintWriter pr = null;
    private static BufferedReader br = null;
    private static String cp = null;

    static {
        cp = "UTF-8";

        try {
            pr = new PrintWriter(new OutputStreamWriter(System.out, cp), true);
            br = new BufferedReader(new InputStreamReader(System.in, cp));
        } catch (UnsupportedEncodingException var1) {
            System.out.println(var1);
        }

    }

    public cpage() {
    }

    public static void setCp(String acp) {
        if (acp != null) {
            cp = acp;

            try {
                pr = new PrintWriter(new OutputStreamWriter(System.out, cp), true);
                br = new BufferedReader(new InputStreamReader(System.in, cp));
            } catch (UnsupportedEncodingException var2) {
                System.out.println(var2);
            }
        }

    }

    public static String getCp() {
        return cp;
    }

    public static BufferedReader getIn() {
        return br;
    }

    public static PrintWriter getOut() {
        return pr;
    }
}
