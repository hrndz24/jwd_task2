package by.buyash.thread;

import by.buyash.entity.Matrix;

import java.util.Random;

public class MatrixThread extends Thread {

    private Matrix matrix = Matrix.INSTANCE;

    private int diagonalIndex;
    private int number;
    private int rowAndColumnElementsSum;

    public MatrixThread(int diagonalIndex, int number) {
        super(String.valueOf(number));
        this.diagonalIndex = diagonalIndex;
        this.number = number;
    }

    @Override
    public void run() {
        System.out.println("Here we go\n");
        matrix.setNumberAt(diagonalIndex, diagonalIndex, number);

        // TODO: 14.02.2020 optimize
        Random random = new Random();
        if (random.nextBoolean()) {
            matrix.setNumberAt(diagonalIndex, generateRandomNumber(), number);
        } else {
            matrix.setNumberAt(generateRandomNumber(), diagonalIndex, number);
        }

        calculateRowAndColumnElementsSum();
        System.out.println("From " + getName() + Matrix.INSTANCE.toString());
        System.out.println("Ah shit here we go again " + rowAndColumnElementsSum + " \n");
    }

    public int getRowAndColumnElementsSum() {
        return rowAndColumnElementsSum;
    }

    private int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(matrix.getSize());
    }

    private void calculateRowAndColumnElementsSum() {
        int matrixSize = matrix.getSize();
        for (int i = 0; i < matrixSize; i++) {
            rowAndColumnElementsSum += matrix.getNumberAt(i, diagonalIndex);
            rowAndColumnElementsSum += matrix.getNumberAt(diagonalIndex, i);
        }
        rowAndColumnElementsSum -= matrix.getNumberAt(diagonalIndex, diagonalIndex);
    }
}
