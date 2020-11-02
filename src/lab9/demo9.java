package lab9;


public class demo9 {
    public demo9() {
    }

    public static void main(String[] argv) throws ProductNotFreeException {
        String[] menu = new String[]{"1 - Робота iз списком product", "2 - Робота iз списком provider", "3 - Робота iз supply"};
        if (argv.length > 0) {
            cpage.setCp(argv[0]);
        }

        Providers c = new Providers();
        ProviderRepres cr = Provider.getTerminalRepres();
        Products a = new Products();
        ProductRepres ar = Product.getTerminalRepres();
        Supplys e = new Supplys();
        short op = 1;

        while(op > 0) {
            switch(op = util.textMenu(menu)) {
                case 1:
                    util2.monitor(a, ar);
                    break;
                case 2:
                    util2.monitor(c, cr);
                    break;
                case 3:
                    util2.monitorE(e, a, c);
            }
        }

        cpage.getOut().println("Роботу закiінчено");
    }
}
