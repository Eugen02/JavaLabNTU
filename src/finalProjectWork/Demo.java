package finalProjectWork;

import java.util.Iterator;

public class Demo {
    public static void main(String[] args) {
        int i = 0;
     Matrix matrix = new Matrix(5);
     matrix.print();
     matrix.getColumnRow(1,1);
     matrix.getColumnRow(4,4);
     matrix.setColumnRow(4,4,100);
     matrix.getColumnRow(4,4);
     matrix.matrixSize();
     matrix.print();

    matrix.notEmptyElement();
    matrix.notEmptyElementColumn(1);
    matrix.notEmptyElementRow(2);
    matrix.notEmptyElementRow(4);
    matrix.emptyElementRow(4);
    matrix.emptyElement();


        Iterator<Object> iter = matrix.iterator();
        while(iter.hasNext()){
            if (i == matrix.getSize()){
                System.out.print(System.lineSeparator());
                i=0;
            }
            System.out.printf("%8s",iter.next());
            i++;
        }

        System.out.println(matrix.toString());


    }
}
