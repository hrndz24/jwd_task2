package by.buyash.main;

import by.buyash.constant.IntegerConstant;
import by.buyash.constant.StringConstant;
import by.buyash.entity.Matrix;
import by.buyash.exception.MatrixWriterException;
import by.buyash.thread.MatrixThread;
import by.buyash.writer.FileMatrixWriter;

public class Main {

    public static void main(String[] args) {

        int size = Matrix.INSTANCE.getSize();
        int threadGroupQuantity = IntegerConstant.THREAD_GROUP_QUANTITY.getValue();
        MatrixThread[][] matrixThreads = new MatrixThread[threadGroupQuantity][size];
        FileMatrixWriter fileMatrixWriter = new FileMatrixWriter(StringConstant.OUTPUT_FILE_PATH.getValue());

        int threadNumberName = 1;
        for (int i = 0; i < threadGroupQuantity; i++) {

            for (int j = 0; j < size; j++) {
                matrixThreads[i][j] = new MatrixThread(j, threadNumberName++);
                matrixThreads[i][j].start();
            }

            for (int j = 0; j < size; j++) {
                try {
                    matrixThreads[i][j].join();
                } catch (InterruptedException e) {
                    // TODO: 14.02.2020 handle
                    e.printStackTrace();
                }
            }

            try {
                fileMatrixWriter.writeToFile(matrixThreads[i]);
            } catch (MatrixWriterException e) {
                // TODO: 14.02.2020 handle this stuff
                e.printStackTrace();
            }

        }
    }
}
