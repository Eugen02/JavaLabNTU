package lab7;

public class demo7 {
    public demo7() {
    }

    public static void main(String[] argv) {
        if (argv.length > 0) {
            cpage.setCp(argv[0]);
        }

        cpage.getOut().println("Колекция продуктов");
        util2.monitor(new Products(), Product.getTerminalRepres());
    }
}
