package finalProjectWork;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class Matrix {
    int size;
    private Map<Integer,int[]> arrays = new HashMap<>();
    public Matrix(){ }

    public Matrix(int size) {
        this.size = size;
        int[] array;
        int tempSize = size-1;
        for (int i = 0; i< size; i++){
            array = new int[size];
            for (int j = 0; j<size; j++){
                if (j<tempSize+1){continue;}
                array[j] = (int) (Math.random() * 300);
            }
            tempSize--;
            arrays.put(i,array);
        }
    }

    public void setArray(){

    }


    public void print(){
       for (int i = 0; i<size; i++){
           System.out.println(Arrays.toString(arrays.get(i)));
       }
    }

    public void getColumnRow(int column, int row){
        int[] array = arrays.get(column);
        if (array[row] == 0){
            System.out.println("null");
        }
        else System.out.println(array[row]);
    }

    public void setColumnRow(int column, int row, int value){
        int[] array = arrays.get(column);
        if (array[row] == 0){
            try {
                throw new MatrixException();
            } catch (MatrixException e) {
                e.printStackTrace();
            }
        } else{
            array[row] = value;
            arrays.put(column,array);

        }
    }

    public void matrixSize(){
        System.out.println(size + " x " + size);
    }

    public void notEmptyElement(){
        int notEmpty = 0;
        int[] array;
        for (int i = 0; i<size; i++){
            array = arrays.get(i);
            for (int j = 0; j < size; j++){
                if (array[j] != 0){
                    notEmpty++;
                }
            }
        }
        System.out.println("Not empty elements = " + notEmpty);
    }

    public void notEmptyElementColumn(int column){
        int template = 0;
        int[] array;
        for (int i = 0; i<size; i++){
            array = arrays.get(i);
            for (int j = 0; j < size; j++){
                if (array[j] != 0 && j==column){
                    template++;
                }
            }
        }
        System.out.println("Not empty elements in column = " + template);
    }
    public void notEmptyElementRow(int row){
        int template = 0;
        int[] array = arrays.get(row);
        for (int i = 0;i<size;i++){
            if (array[i]!=0){
                template++;
            }
        }
        System.out.println("Not empty elements in row = " + template);
    }



}
//
//    int[] array;
//    int size;
//
//    public Matrix(){ }
//
//    public Matrix(int size) {
//        this.size = size;
//        array = new int[size*size];
//    }
//
//    public void setArray(){
//        for (int i = 0; i<size;i++){
//            for (int j = 0; j<size; j++){
//
//            }
//        }
//    }
//
//
//    public void print(){
//        Arrays.stream(array)
//               .forEach(out::println);
//    }
//
//}
