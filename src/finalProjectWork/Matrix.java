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
                array[j] = 1;
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
