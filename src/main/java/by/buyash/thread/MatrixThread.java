package by.buyash.thread;

import by.buyash.entity.Matrix;

import java.util.Arrays;
import java.util.Random;

public class MatrixThread extends Thread {

    private Matrix matrix = Matrix.INSTANCE;
    private int row;
    private int column;
    private int number;

    public MatrixThread(int row, int column, int number) {
        super(String.valueOf(number));
        this.row = row;
        this.column = column;
        this.number = number;
    }

    @Override
    public void run() {
        System.out.println("Here we go\n");
        matrix.setNumberAt(row, column, number);
        Random random = new Random();
        int i = random.nextInt(2);
        if (i == 0) {
            column = random.nextInt(matrix.getSize());
        } else {
            row = random.nextInt(matrix.getSize());
        }
        matrix.setNumberAt(row, column, number);
        System.out.println("From " + getName() + Arrays.deepToString(Matrix.INSTANCE.getMatrix()));
        System.out.println("Ah shit here we go again\n");
    }
}
