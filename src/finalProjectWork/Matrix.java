package finalProjectWork;

import java.util.*;


public class Matrix {
    private Map<Integer,Integer[]> arrays = new HashMap<>();
    private int size;
    public Matrix(){ }

    public Matrix(int size) {
        this.size = size;
        Integer[] array;
        int tempSize = size-1;
        for (int i = 0; i< size; i++){
            array = new Integer[size];
            for (int j = 0; j<size; j++){
                if (j<tempSize+1){
                    continue;}
                array[j] = 0;
            }
            tempSize--;
            arrays.put(i,array);
        }
    }

    public Map<Integer, Integer[]> getArrays() {
        return arrays;
    }

    public int getSize() {
        return size;
    }

    public void print(){
        StringBuilder sb = new StringBuilder();
        Integer[] template;
       for (int i = 0; i<size; i++){
           template = arrays.get(i);
           for (int j= 0; j<size; j++){
               sb.append(template[j]+ "\t");
               if (template[j]!=null){
                   sb.append("\t");
               }
           }
           sb.append(System.lineSeparator());
       }
        System.out.println(sb.toString());
    }

    public void getColumnRow(int column, int row){
        Integer[] array = arrays.get(column);
        if (array[row] == null){
            System.out.println("null");
        }
        else System.out.println("Значение в этой ячейке = " +array[row]);
    }

    public void setColumnRow(int column, int row, int value){
        Integer[] array = arrays.get(column);
        if (array[row] == null){
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
        Integer[] array;
        for (int i = 0; i<size; i++){
            array = arrays.get(i);
            for (int j = 0; j < size; j++){
                if (array[j] == null){
                    continue;
                }
                if (array[j] != 0){
                    notEmpty++;
                }
            }
        }
        System.out.println("Not empty elements = " + notEmpty);
    }

    public void notEmptyElementColumn(int column){
        int template = 0;
        Integer[] array;
        for (int i = 0; i<size; i++){
            array = arrays.get(i);
            for (int j = 0; j < size; j++){
                if (array[j] == null){
                    continue;
                }
                if (array[j] != 0 && j==column){
                    template++;
                }
            }
        }
        System.out.println("Not empty elements in column = " + template);
    }
    public void notEmptyElementRow(int row) {
        int template = 0;
        Integer[] array = arrays.get(row);
        for (int i = 0; i < size; i++) {
            if (array[i] == null) {
                continue;
            }
            if (array[i] != 0) {
                template++;
            }
        }
        System.out.println("Not empty elements in row = " + template);
    }

    public void emptyElement(){
            int Empty = 0;
            Integer[] array;
            for (int i = 0; i<size; i++){
                array = arrays.get(i);
                for (int j = 0; j < size; j++){
                    if (array[j] == null){
                        Empty++;
                        continue;
                    }
                    if (array[j] == 0){
                        Empty++;
                    }
                }
            }
        System.out.println("Empty elements (null too) = " + Empty);
    }

    public void emptyElementRow(int row) {
        int template = 0;
        Integer[] array = arrays.get(row);
        for (int i = 0; i < size; i++) {
            if (array[i] == null) {
                continue;
            }
            if (array[i] == 0) {
                template++;
            }
        }
        System.out.println("Empty elements in row = " + template);
    }


    public void emptyElementColumn(int column){
        int template = 0;
        Integer[] array;
        for (int i = 0; i<size; i++){
            array = arrays.get(i);
            for (int j = 0; j < size; j++){
                if (array[j] == null){
                    continue;
                }
                if (array[j] == 0 && j==column){
                    template++;
                }
            }
        }
        System.out.println("Empty elements in column = " + template);
    }


    public Iterator<Object> iterator() {
        return new IteratorMatrix();
    }

    private class IteratorMatrix implements Iterator<Object> {
       int size = getSize();
       int cursor1;
       int cursor2;
       int lastRet = -1;
        Map<Integer,Integer[]> arrays = getArrays();
        Integer[] array;

        @Override
        public boolean hasNext()
        {
            return cursor1 !=size;
        }

        @Override
        public Object next()
        {
            if(!hasNext()){throw new NoSuchElementException();}
            if (cursor2 == size){
                cursor1++;
                cursor2 = 0;
            }
            int i = cursor2;
            cursor2 = i + 1;
            lastRet = i;
            array = arrays.get(cursor1);
            if (lastRet == 4 && cursor1 == 4){
                cursor1 = size;
                return  array[lastRet];
            }
            return   array[lastRet];
        }
    }

    @Override
    public String toString() {
        Iterator<Object> objectIterator = iterator();
        int template = 0;
        if (! objectIterator.hasNext())
            return "[]";

        StringBuilder sb = new StringBuilder();
        sb.append(System.lineSeparator()).append('[');
        for (;;) {
            Object e = objectIterator.next();
            sb.append(e == this ? "(this Collection)" : e);
            if (! objectIterator.hasNext())
                return sb.append(']').toString();
            if (template == size-1){
                sb.append("]").append(System.lineSeparator());
                template = 0;
                sb.append("[");
            }else {
            template++;
            sb.append(", ");}}
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
