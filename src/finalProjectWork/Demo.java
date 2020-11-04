package finalProjectWork;

public class Demo {
    public static void main(String[] args) {

        Matrix matrix = new Matrix(10);
        matrix.print();

        matrix.getColumnRow(7,4);

        matrix.setColumnRow(7,4,12345);

        matrix.print();

        matrix.notEmptyElement();
    }
}
