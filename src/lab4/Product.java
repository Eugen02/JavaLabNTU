package lab4;


import java.io.*;

public abstract class Product {
    private int id;
    private String name;
    private int amount;
    private double price;

    Product() {
        this.id = 1;
        this.name = "";
        this.amount= 0;
        this.price = 0.0;
    }

    Product(int id, String name, int amount, double price) {
        this();
        this.id = id;
        this.name = name;
        this.amount= amount;
        this.price = price;
    }


    Product(int id, String name, int amount) {
        this(id, name, amount, 0.0);
    }

    Product(int id, String name) {
        this(id, name, 0, 0.0);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }



    public String toString() {
        return this.id + " " + this.name + " " + this.amount + " " + this.price;
    }


    public String toString2() {
        return util.leftString(this.id, 5) + " " + util.leftString(this.getName(), 12) + " " + this.getAmount();
    }


    public boolean writeTxt(String filename) {
        PrintWriter file = null;
        try {
            file = new PrintWriter(new OutputStreamWriter(new FileOutputStream(filename), cpage.getCp()));
        } catch (Exception var4) {
            cpage.getOut().println("I/O error");
            return false;
        }
        file.println("id=" + this.id);
        file.println("name=" + this.name);
        file.println("amount=" + this.amount);
        file.println("price=" + this.price);
        if (this instanceof PrepackagedGoods) {
            ((PrepackagedGoods)this).writeTxt_(file);
        }

        if (this instanceof PieceGood) {
            ((PieceGood)this).writeTxt_(file);
        }

        if (this instanceof WeightGood) {
            ((WeightGood)this).writeTxt_(file);
        }
        file.close();
        return true;
    }

    public static Product readTxt(String filename) {
        BufferedReader file = null;
        char[] v = new char[(int)(new File(filename)).length()];
        String s = null;
        String type = null;
        Product a = null;
        String s3 = null;

        try {
            file = new BufferedReader(new InputStreamReader(new FileInputStream(filename), cpage.getCp()));
            int rc = file.read(v);
            file.close();
            s = new String(v, 0, rc);
        } catch (Exception var11) {
            cpage.getOut().println("I/O error");
            return null;
        }

        try {
            if ((type = util.getValue(s, "type")) == null) {
                return null;
            } else {
                if (type.equals("PrepackagedGoods")) {
                    a = PrepackagedGoods.readTxt_(s);
                } else if (type.equals("PieceGood")) {
                    a = PieceGood.readTxt_(s);
                } else {
                    if (!type.equals("WeightGood")) {
                        return null;
                    }

                    a = WeightGood.readTxt_(s);
                }

                if ((s3 = util.getValue(s, "id")) != null) {
                    ((Product)a).setId(Integer.parseInt(s3));
                }

                if ((s3 = util.getValue(s, "name")) != null) {
                    ((Product)a).setName(s3);
                }

                if ((s3 = util.getValue(s, "amount")) != null) {
                    ((Product)a).setAmount(Integer.parseInt(s3));
                }
                if ((s3 = util.getValue(s, "price")) != null) {
                    ((Product)a).setPrice(Integer.parseInt(s3));
                }

                    return (Product)a;
                }

           } catch (NumberFormatException var10) {
            cpage.getOut().println("Data format Exception");
            return null;
        }
    }

    public boolean writeData(String filename) {
        DataOutputStream file = null;

        try {
            file = new DataOutputStream(new FileOutputStream(filename));
            if (this instanceof PrepackagedGoods) {
                ((PrepackagedGoods)this).writeData_(file);
            }

            if (this instanceof PieceGood) {
                ((PieceGood)this).writeData_(file);
            }

            if (this instanceof WeightGood) {
                ((WeightGood)this).writeData_(file);
            }

            file.writeInt(this.id);
            file.writeUTF(this.name);
            file.writeInt(this.amount);
            file.writeDouble(this.price);
            file.close();
            return true;
        } catch (Exception var4) {
            cpage.getOut().println("I/O error");
            return false;
        }
    }

    public static Product readData(String filename) {
        DataInputStream file = null;
        String type = null;
        Object a = null;

        try {
            file = new DataInputStream(new FileInputStream(filename));
            type = file.readUTF();
            if (type.equals("PrepackagedGoods")) {
                a = PrepackagedGoods.readData_(file);
            }

            if (type.equals("PieceGood")) {
                a = PieceGood.readData_(file);
            }

            if (type.equals("WeightGood")) {
                a = WeightGood.readData_(file);
            }

            if (a != null) {
                ((Product)a).id = file.readInt();
                ((Product)a).name = file.readUTF();
                ((Product)a).amount = file.readInt();
                ((Product)a).price = file.readChar();
            }

            file.close();
            return (Product)a;
        } catch (Exception var5) {
            cpage.getOut().println("I/O error");
            return null;
        }
    }

    public abstract String justString();

    public static ProductRepres getTerminalRepres() {
        return ProductRepres.getInstance();
    }
}
