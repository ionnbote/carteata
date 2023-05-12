package Labworks.poo.lab5;

public class MainMatrix {
    public static void main(String[] args) {
        Matrix<Integer> intMatrix = new Matrix<>();
        Matrix<Double> doubleMatrix = new Matrix<>();
        Integer[][] intArr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Double[][] doubleArr = {{1.0, 2.2, 3.2}, {4.2, 5.3, 6.1}, {7.1, 8.3, 9.0}};
        doubleMatrix.setMatrix(doubleArr);
        intMatrix.setMatrix(intArr);
        doubleMatrix.print();

        System.out.println();
        doubleMatrix.multiply(doubleArr);
        doubleMatrix.print();

        System.out.println();
        System.out.println(doubleMatrix.getCols() + " " + doubleMatrix.getRows());
    }
}
