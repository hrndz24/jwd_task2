package by.buyash.writer;

import by.buyash.entity.Matrix;
import by.buyash.exception.MatrixWriterException;
import by.buyash.thread.MatrixThread;
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
        // TODO: 14.02.2020 check input params
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath, true))) {
            Matrix matrix = Matrix.INSTANCE;
            bufferedWriter.write(matrix.toString());
            for (MatrixThread thread : matrixThreads) {
                bufferedWriter.write("Thread "+thread.getName() + ": " + thread.getRowAndColumnElementsSum() + "\n");
            }
        } catch (IOException e) {
            logger.warn(e);
            throw new MatrixWriterException(e);
        }
    }
}
