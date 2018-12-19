package lesson1;

import exception.*;

public class Main {

// 3. В методе main() вызвать полученный метод, обработать возможные исключения
// MySizeArrayException и MyArrayDataException, и вывести результат расчета.
    public static void main(String[] args) throws MyArraySizeException, MyArrayDataException {
        String[][] arrays = new String[4][4];
        try {
            task1(arrays);
        }catch (MyArraySizeException ex){
            System.out.println(ex.getMessege());//не отработает, т.к. мы перехватили раньше в методе!
        }
        try {
            task2(arrays);
        }catch (MyArrayDataException ex){
            System.out.println(ex.getMessage());//не отработает, т.к. мы перехватили раньше в методе!
        }
    }

// 1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4,
// при подаче массива другого размера необходимо бросить исключение MyArraySizeException.
    private static void task1(String[][] arrays) {
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 5; j++){
                try {
                    if (arrays.length <= i) throw new MyArraySizeException(arrays.length);
                    if (arrays[i].length <= j) throw new MyArraySizeException(arrays.length);
                    if (i == 1 && j == 1){
                        arrays[i][j] = "string";
                    }
                    else {
                        arrays[i][j] = (i + "" + j + "");
                    }
                } catch (MyArraySizeException e) {
                    System.err.println(e.getMessege());
                }
            }
        }
    }

// 2. Далее метод должен пройтись по всем элементам массива, преобразовать в int,
// и просуммировать. Если в каком-то элементе массива преобразование не удалось
// (например, в ячейке лежит символ или текст вместо числа), должно быть брошено
// исключение MyArrayDataException, с детализацией в какой именно ячейке лежат неверные данные.
    private static void task2(String[][] arrays){
        int sum = 0;
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 4; j++){
                try {
                    if((arrays[i][j]).matches("^[^0-9]*"))
                        throw new MyArrayDataException(i, j);
                    sum += Integer.parseInt(arrays[i][j]);
                } catch (MyArrayDataException e) {
                    System.err.println(e.getMessage());
                }
            }
        }

        System.out.println("Итого: " + sum);
    }
}
