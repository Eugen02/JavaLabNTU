package lab9;

public class ProviderNotFreeException extends Exception {
    public ProviderNotFreeException(Iprovider c) {
        cpage.getOut().println("Provider не вiльн: " + c.getProviderName());
    }
}
