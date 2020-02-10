package by.buyash.entity;

import by.buyash.constant.Constant;

public enum Matrix {

    INSTANCE;

    private int size = Constant.MATRIX_SIZE.getValue();
    private int[][] matrix = new int[size][size];

    public void setNumberAt(int row, int column, int number) {
        //todo
        matrix[row][column] = number;
    }

    public int getNumberAt(int row, int column) {
        return matrix[row][column];
    }

    public int getSize() {
        return size;
    }

    public int[][] getMatrix() {
        return matrix;
    }
}
