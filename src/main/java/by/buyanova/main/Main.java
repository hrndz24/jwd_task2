package by.buyanova.main;

import by.buyanova.constant.IntegerConstant;
import by.buyanova.constant.StringConstant;
import by.buyanova.entity.Matrix;
import by.buyanova.exception.MatrixWriterException;
import by.buyanova.thread.MatrixThread;
import by.buyanova.writer.FileMatrixWriter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static Logger logger = LogManager.getLogger();

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
