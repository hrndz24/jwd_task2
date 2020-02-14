package by.buyanova.entity;

import by.buyanova.constant.IntegerConstant;
import by.buyanova.exception.MatrixIndexOutOfBoundsException;

import java.util.concurrent.locks.ReentrantLock;

public enum Matrix {

    INSTANCE;

    private int size;
    private int[][] matrix;
    private ReentrantLock[][] lockers;

    {
        size = IntegerConstant.MATRIX_SIZE.getValue();
        matrix = new int[size][size];

        lockers = new ReentrantLock[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                lockers[i][j] = new ReentrantLock();
            }
        }
    }

    public void setNumberAt(int row, int column, int number) throws MatrixIndexOutOfBoundsException {
        verifyIndexBounds(row);
        verifyIndexBounds(column);

        ReentrantLock lock = lockers[row][column];
        lock.lock();
        matrix[row][column] = number;
        lock.unlock();
    }

    public int getNumberAt(int row, int column) {
        return matrix[row][column];
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int[] row : matrix) {
            stringBuilder.append("[");
            for (int number : row) {
                stringBuilder.append(number).append(" ");
            }
            stringBuilder.append("]").append("\n");
        }
        return stringBuilder.toString();
    }

    private void verifyIndexBounds(int index) throws MatrixIndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new MatrixIndexOutOfBoundsException();
        }
    }
}
