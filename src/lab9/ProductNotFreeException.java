package lab9;

public class ProductNotFreeException extends Exception {
    public ProductNotFreeException(Iproduct a) {
        cpage.getOut().println("Product йде: " + a.getId() + " " + a.getName());
    }
}
