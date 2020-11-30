package finalProjectWork;

import java.util.Iterator;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Matrix matrix = null;
        int setMain = -1;

        while (setMain != 0) {
            System.out.println(
                    "1. Выбрать розмерность матрицы" + System.lineSeparator() +
                            "2. Установить значение для матрицы.(строка,стобец)" + System.lineSeparator() +
                            "3. Выборка элемента по заданному номеру строки и столбца" + System.lineSeparator() +
                            "4. Получение размерности матрицы" + System.lineSeparator() +
                            "5. Получение количества мест в матрице, которые не являются заведомо пустыми" + System.lineSeparator() +
                            "6. Получение количества мест в заданном столбце, которые не являются заведомо пустыми" + System.lineSeparator() +
                            "7. Получение количества мест в заданной строке, которые не являются заведомо пустыми" + System.lineSeparator() +
                            "8. Получение общего количества пустых мест в матрице " + System.lineSeparator() +
                            "9. Получение общего количества пустых мест в заданной строке " + System.lineSeparator() +
                            "10. Получение общего количества пустых мест в заданном столбце " + System.lineSeparator() +
                            "11. Печать (print) " + System.lineSeparator() +
                            "12. Печать (iterator) " + System.lineSeparator() +
                            "13. Печать (toString) " + System.lineSeparator() +
                            "0. Выход" + System.lineSeparator());
            System.out.print("------->");
            setMain = scanner.nextInt();
            switch (setMain) {
                case 1: {
                    System.out.print("Введите размерность матрицы = ");
                    int setMatrixSize = scanner.nextInt();
                    if (checkForSet(setMatrixSize < 0)) break;
                    matrix = new Matrix(setMatrixSize);
                    System.out.println("Размерность матрицы установлена");
                    break;
                }
                case 2: {
                    matrix = checkMatrix(matrix);
                    System.out.print("Введите строку = ");
                    int setMatrixColumn = scanner.nextInt();
                    System.out.print("Введите колонку = ");
                    int setMatrixRow = scanner.nextInt();
                    if (checkForSet(setMatrixColumn < 0 || setMatrixRow < 0)) break;
                    System.out.print("Введите значение = ");
                    int setMatrixValue = scanner.nextInt();
                    try {
                        matrix.setColumnRow(setMatrixColumn, setMatrixRow, setMatrixValue);
                    } catch (MatrixException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case 3: {
                    matrix = checkMatrix(matrix);
                    System.out.print("Введите строку = ");
                    int setMatrixColumn = scanner.nextInt();
                    System.out.print("Введите колонку = ");
                    int setMatrixRow = scanner.nextInt();
                    if (checkForSet(setMatrixColumn < 0 || setMatrixRow < 0 ||
                            setMatrixColumn > matrix.getSize() - 1 || setMatrixRow > matrix.getSize() - 1)) break;
                    matrix.printColumnRow(setMatrixColumn, setMatrixRow);
                    break;
                }

                case 4: {
                    matrix = checkMatrix(matrix);
                    matrix.matrixSize();
                    break;
                }

                case 5: {
                    matrix = checkMatrix(matrix);
                    matrix.printNotEmptyElement();
                    break;
                }
                case 6: {
                    matrix = checkMatrix(matrix);
                    System.out.print("Введите колонку = ");
                    int getMatrixColumn = scanner.nextInt();
                    if (checkForSet(getMatrixColumn < 0 || getMatrixColumn > matrix.getSize()-1)) break;
                    matrix.printNotEmptyElementColumn(getMatrixColumn);
                    break;
                }
                case 7: {
                    matrix = checkMatrix(matrix);
                    System.out.print("Введите строку = ");
                    int getMatrixRow = scanner.nextInt();
                    if (checkForSet(getMatrixRow < 0 || getMatrixRow > matrix.getSize()-1)) break;
                    matrix.printNotEmptyElementRow(getMatrixRow);
                    break;
                }
                case 8: {
                    matrix = checkMatrix(matrix);
                    matrix.printEmptyElement();
                    break;
                }
                case 9: {
                    matrix = checkMatrix(matrix);
                    System.out.print("Введите строку = ");
                    int getMatrixRow = scanner.nextInt();
                    if (checkForSet(getMatrixRow < 0 || getMatrixRow > matrix.getSize()-1)) break;
                    matrix.printEmptyElementRow(getMatrixRow);
                    break;
                }
                case 10: {
                    matrix = checkMatrix(matrix);
                    System.out.print("Введите колонку = ");
                    int getMatrixColumn = scanner.nextInt();
                    if (checkForSet(getMatrixColumn < 0|| getMatrixColumn > matrix.getSize()-1)) break;
                    matrix.printEmptyElementColumn(getMatrixColumn);
                    break;
                }
                case 11: {
                    matrix = checkMatrix(matrix);
                    matrix.print();
                    break;
                }
                case 12: {
                    matrix = checkMatrix(matrix);
                    int i = 0;
                    Iterator<Object> iter = matrix.iterator();
                    while (iter.hasNext()) {
                        if (i == matrix.getSize()) {
                            System.out.print(System.lineSeparator());
                            i = 0;
                        }
                        System.out.printf("%10s", iter.next());
                        i++;
                    }
                    System.out.println();
                    break;
                }
                case 13: {
                    matrix = checkMatrix(matrix);
                    System.out.println(matrix.toString());
                    break;
                }

                default: {
                    setMain = 0;
                    System.out.println("exit");
                    break;
                }
            }

        }


    }

    private static Matrix checkMatrix(Matrix matrix) {
        if (matrix == null) {
            matrix = new Matrix(5);
            System.out.println("Установлена размернось матрицы по умолчанию (5 х 5) ");
        }
        return matrix;
    }

    private static boolean checkForSet(boolean b) {
        if (b) {
            System.out.println("Неправильный ввод! Значение не установлено ");
            return true;
        }
        return false;
    }
}
