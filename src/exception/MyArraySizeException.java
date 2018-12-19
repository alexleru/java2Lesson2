package exception;

public class MyArraySizeException extends RuntimeException {

    String messege;

    public MyArraySizeException(int numberOfBound){
        this.messege = "Ошибка! В массиве может быть только " + numberOfBound + " элемента";
    }

    public String getMessege() {
        return messege;
    }
}
