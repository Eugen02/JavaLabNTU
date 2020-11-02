package lab5;

public class demo5 {
    public demo5() {
    }

    public static void main(String[] argv) {
        if (argv.length > 0) {
            cpage.setCp(argv[0]);
        }

        Products a = new Products();
        ProductsRepres.monitor(a);
        cpage.getOut().println("Роботу закiнчено");
    }
}
