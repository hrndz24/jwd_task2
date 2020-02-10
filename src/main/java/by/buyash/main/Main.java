package by.buyash.main;

import by.buyash.constant.Constant;
import by.buyash.entity.Matrix;
import by.buyash.thread.MatrixThread;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        System.out.println(Arrays.deepToString(Matrix.INSTANCE.getMatrix()));
        int size = Matrix.INSTANCE.getSize();
        MatrixThread[][] matrixThreads = new MatrixThread[size][size];
        //MatrixThread thread = new MatrixThread(2, 2, 2);
        //System.out.println(thread.getName());

        //thread.start();

        int uniqueNumber =1;
        for (int i = 0; i < Constant.Y_CONSTANT.getValue(); i++) {
            for (int j = 0; j < Matrix.INSTANCE.getSize(); j++) {
                matrixThreads[i][j] = new MatrixThread(j, j, uniqueNumber++);
                matrixThreads[i][j].start();
            }
            for(int j = 0;j<size;j++){
                try {
                    matrixThreads[i][j].join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("From main:"+Arrays.deepToString(Matrix.INSTANCE.getMatrix()));
        }
    }
}
