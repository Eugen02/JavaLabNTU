package lab9;

import java.io.PrintWriter;

public class ProviderRepres implements Repres {
    static ProviderRepres instance = null;
    private static PrintWriter pr = null;

    private ProviderRepres() {
        pr = cpage.getOut();
    }

    public static ProviderRepres getInstance() {
        if (instance == null) {
            instance = new ProviderRepres();
        }

        return instance;
    }

    public boolean kbInput(Item ai) {
        Provider a = (Provider)ai;
        a.setProviderName(util.readString("название поставщика"));

        try {
            a.setAddress(util.readString("адрес"));
        } catch (NumberFormatException var4) {
            pr.println("Помилка даних \n");
            return false;
        }

        pr.println("OK!\n");
        return true;
    }

    public void printCard(Item ai) {
        Provider a = (Provider)ai;
        pr.print("\nназвание поставщика        >" + a.getProviderName());
        pr.print("\nадрес                      >" +  a.getAddress());
        pr.println();
    }

    public void printLine(Item ai) {
        Provider a = (Provider)ai;
        pr.println(" " + util.leftString(a.getProviderName(), 20) + " " + util.leftString(a.getAddress(), 40));
    }

    public Item getInst() {
        return new Provider();
    }
}