package lab9;

import java.io.*;

public class Provider implements Serializable, Iprovider {
    private String providerName;
    private String address;

    public Provider() { }

    public Provider(String providerName, String address) {
        this.providerName = providerName;
        this.address = address;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String toString() {
        return this.providerName + " " + this.address;
    }

    public String toString2() {
        return util.leftString(this.providerName, 20) + " " + util.leftString(this.address, 40);
    }

    public boolean writeTxt(String filename) {
        PrintWriter file = null;

        try {
            file = new PrintWriter(new OutputStreamWriter(new FileOutputStream(filename), cpage.getCp()));
        } catch (Exception var4) {
            System.out.println("I/O error");
            return false;
        }

        file.println("providerName=" + this.providerName);
        file.println("address=" + this.address);
        file.close();
        return true;
    }

    public static Provider readTxt(String filename) {
        String s = util.readTextFile(filename);
        Provider c = new Provider();

        try {
            String s3;
            if ((s3 = util.getValue(s, "providerName")) != null) {
                c.setProviderName(s3);
            }

            if ((s3 = util.getValue(s, "address")) != null) {
                c.setAddress(s3);
            }

            return c;
        } catch (NumberFormatException var5) {
            System.out.println("Data format Exception");
            return null;
        }
    }

    public boolean writeData(String filename) {
        DataOutputStream file = null;

        try {
            file = new DataOutputStream(new FileOutputStream(filename));
            file.writeUTF(this.providerName);
            file.writeUTF(this.address);
            file.close();
            return true;
        } catch (Exception var4) {
            System.out.println("I/O error");
            return false;
        }
    }

    public static Provider readData(String filename) {
        DataInputStream file = null;
        String type = null;
        Object c = null;

        try {
            file = new DataInputStream(new FileInputStream(filename));
            ((Provider)c).providerName = file.readUTF();
            ((Provider)c).address = file.readUTF();
            file.close();
            return (Provider)c;
        } catch (Exception var5) {
            System.out.println("I/O error");
            return null;
        }
    }

    public static ProviderRepres getTerminalRepres() {
        return ProviderRepres.getInstance();
    }

    public int comp1(Item a) {
        return this.providerName.compareTo(((Provider)a).providerName);
    }

    public int comp2(Item a) {
        return this.address.compareTo(((Provider)a).address);
    }

    public String justString() {
        return this.toString2();
    }

    @Override
    public boolean isFree() {
        return false;
    }

    @Override
    public void setFree(boolean var1) {

    }

    @Override
    public void setFree(String var1) {

    }
}
