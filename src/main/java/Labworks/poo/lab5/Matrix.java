package Labworks.poo.lab5;

public class Matrix<T extends Number> {
    private int rows;
    private int cols;
    private T[][] m;

    public void print() {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                System.out.print(m[i][j] + " ");
            }
        }
    }

    public T[][] multiply(T[][] n) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                if (m[0][0].getClass() == Integer.class) {
                    Integer n1 = (Integer) m[i][j];
                    Integer n2 = (Integer) n[i][j];
                    Integer r = n1 * n2;
                    m[i][j] = (T) r;
                }
                if (m[0][0].getClass() == Long.class) {
                    Long n1 = (Long) m[i][j];
                    Long n2 = (Long) n[i][j];
                    Long r = n1 * n2;
                    m[i][j] = (T) r;
                }
                if (m[0][0].getClass() == Double.class) {
                    Double n1 = (Double) m[i][j];
                    Double n2 = (Double) n[i][j];
                    Double r = n1 * n2;
                    m[i][j] = (T) r;
                }
            }
        }

        return m;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public T[][] getM() {
        return m;
    }

    public void setMatrix(T[][] m) {
        this.rows = m.length;
        this.cols = m[0].length;
        this.m = m;
    }
}
