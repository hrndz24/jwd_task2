package by.buyanova.writer;

import by.buyanova.entity.Matrix;
import by.buyanova.exception.MatrixWriterException;
import by.buyanova.thread.MatrixThread;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileMatrixWriter {

    private String filePath;
    private static Logger logger = LogManager.getLogger();

    public FileMatrixWriter(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public void writeToFile(MatrixThread[] matrixThreads) throws MatrixWriterException {

        verifyMatrixThreads(matrixThreads);

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath, true))) {
            Matrix matrix = Matrix.INSTANCE;
            bufferedWriter.write(matrix.toString());
            for (MatrixThread thread : matrixThreads) {
                bufferedWriter.write("Thread " + thread.getName() + ": " + thread.getRowAndColumnElementsSum() + "\n");
            }
        } catch (IOException e) {
            logger.warn(e);
            throw new MatrixWriterException(e);
        }
    }

    private void verifyMatrixThreads(MatrixThread[] matrixThreads) throws MatrixWriterException {
        if (matrixThreads == null) {
            throw new MatrixWriterException("Null matrix threads array");
        }

        for (MatrixThread matrixThread : matrixThreads) {
            if (matrixThread == null) {
                throw new MatrixWriterException("Null matrix thread in array");
            }
        }
    }
}
