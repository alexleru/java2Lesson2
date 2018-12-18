package lesson1;


public class Main {

    public static void main(String[] args) throws MyArraySizeException {
        String[][] arrays = new String[4][4];
        try {

            task1(arrays);
        }catch (MyArraySizeException ex){
            System.out.println("У вас проблема. " + ex.getMessage());
        }

        task2(arrays);
    }

    private static void task2(String[][] arrays){
        int sum = 0;
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 4; j++){
                try {
                    sum += Integer.parseInt(arrays[i][j]);
                } catch (MyArraySizeException e) {
                    //e.printStackTrace();
                    System.out.println("У вас проблема. " + e.getMessage());
                }
            }
        }

        System.out.println("" + sum);
    }

    private static void task1(String[][] arrays) {
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 5; j++){
                try {
                    arrays[i][j] = (i + "" + j + "");
                    throw new MyArraySizeException();
                } catch (MyArraySizeException e) {
                    //e.printStackTrace();
                    System.out.println("" + e.getMessage());
                }
            }
        }
    }
}
