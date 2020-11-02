package lab9;

public interface Iprovider extends Item{

     String getProviderName();

    void setProviderName(String providerName);

    String getAddress();

    void setAddress(String address);

    String toString();

    String toString2();

    String justString();

    boolean writeTxt(String var1);

    boolean writeData(String var1);

    int comp1(Item var1);

    int comp2(Item var1);
}
