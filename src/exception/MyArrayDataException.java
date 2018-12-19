package exception;

public class MyArrayDataException extends RuntimeException {
    private final String message;

    public MyArrayDataException(int i, int j) {
        this.message = "В ячейке под номером " + i + "" + j + " находится нецифровой символ";
    }

    public String getMessage() {
        return message;
    }
}
