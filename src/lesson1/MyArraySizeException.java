package lesson1;

class MyArraySizeException extends RuntimeException {

    //private final Error error;

    public MyArraySizeException(){
        //this.error = error;
    }

    @Override
    public String getMessage() {
        return ("Есть проблема, массив не должны быть больше " + super.getMessage());
    }
}
