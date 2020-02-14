package by.buyash.main;

import by.buyash.constant.IntegerConstant;
import by.buyash.constant.StringConstant;
import by.buyash.entity.Matrix;
import by.buyash.exception.MatrixWriterException;
import by.buyash.thread.MatrixThread;
import by.buyash.writer.FileMatrixWriter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static Logger logger = LogManager.getLogger();
    public static void main(String[] args) {

        int size = Matrix.INSTANCE.getSize();
        int threadGroupQuantity = IntegerConstant.THREAD_GROUP_QUANTITY.getValue()+1;
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
                    logger.warn(e);
                }
            }

            try {
                fileMatrixWriter.writeToFile(matrixThreads[i]);
            } catch (MatrixWriterException e) {
                logger.warn(e);
            }

        }
    }
}
