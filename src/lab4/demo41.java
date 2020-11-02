package lab4;


public class demo41 {
    public demo41() {
    }

    public static void main(String[] argv) {
        if (argv.length > 0) {
            cpage.setCp(argv[0]);
        }

        PieceGood p1 = new PieceGood(1,"PieceFirst",1,1.0,5,0.5);
        Product p2 = new PieceGood(2,"PieceSecond",2,2.0,10,1);
        PrepackagedGoods h1 = new PrepackagedGoods(3,"PrepackFirst",100,40.0,1000,123,4000.0);
        Product h2 = new PrepackagedGoods(4,"PrepackSecond", 59,123.3,123,12300,12399.0);
        WeightGood b1 = new WeightGood(5,"WeightFirst",47, 43.34,10.0,37.0);
        Product b2 = new WeightGood(6,"WeightSecond",62,42.6,20.0,39.0);
        p1.writeTxt("amba.txt");
        p2.writeTxt("sirko.txt");
        h1.writeTxt("aun.txt");
        h2.writeTxt("tendy.txt");
        b1.writeTxt("lady.txt");
        b2.writeTxt("batmen.txt");
        p1.writeData("amba.bin");
        p2.writeData("sirko.bin");
        h1.writeData("aun.bin");
        h2.writeData("tendy.bin");
        b1.writeData("lady.bin");
        b2.writeData("batmen.bin");
    }
}
