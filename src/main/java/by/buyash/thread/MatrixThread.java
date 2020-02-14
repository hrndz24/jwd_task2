package by.buyash.thread;

import by.buyash.entity.Matrix;

import java.util.Random;

public class MatrixThread extends Thread {

    private Matrix matrix = Matrix.INSTANCE;
    private int row;
    private int column;
    private int number;
    private int rowAndColumnElementsSum;

    public MatrixThread(int diagonalIndex, int number) {
        super(String.valueOf(number));
        this.row = diagonalIndex;
        this.column = diagonalIndex;
        this.number = number;
    }

    @Override
    public void run() {
        System.out.println("Here we go\n");
        matrix.setNumberAt(row, column, number);
        // TODO: 14.02.2020 optimize
        Random random = new Random();
        int column = this.column, row = this.row;
        int i = random.nextInt(2);
        if (i == 0) {
            column = random.nextInt(matrix.getSize());
        } else {
            row = random.nextInt(matrix.getSize());
        }
        matrix.setNumberAt(row, column, number);
        calculateRowAndColumnElementsSum();
        System.out.println("From " + getName() + Matrix.INSTANCE.toString());
        System.out.println("Ah shit here we go again " + rowAndColumnElementsSum + " \n");
    }

    public int getRowAndColumnElementsSum() {
        return rowAndColumnElementsSum;
    }

    private void calculateRowAndColumnElementsSum() {
        int matrixSize = matrix.getSize();
        for (int i = 0; i < matrixSize; i++) {
            rowAndColumnElementsSum += matrix.getNumberAt(i, column);
            rowAndColumnElementsSum += matrix.getNumberAt(row, i);
        }
        rowAndColumnElementsSum -= matrix.getNumberAt(row, row);
    }
}
