package lab7;

public class demo7a {
    public demo7a() {
    }

    public static void main(String[] argv) {
        if (argv.length > 0) {
            cpage.setCp(argv[0]);
        }

        cpage.getOut().println("Колекция поставщиков");
        util2.monitor(new Providers(), Provider.getTerminalRepres());
    }
}
