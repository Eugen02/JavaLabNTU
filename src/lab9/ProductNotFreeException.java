package lab9;

public class ProductNotFreeException extends Exception {
    public ProductNotFreeException(Iproduct a) {
        cpage.getOut().println("Product1 йде: " + a.getId() + " " + a.getName());
    }
}
