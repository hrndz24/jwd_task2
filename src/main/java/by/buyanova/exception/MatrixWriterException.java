package by.buyanova.exception;

public class MatrixWriterException extends Exception {

    public MatrixWriterException() {
    }

    public MatrixWriterException(String message) {
        super(message);
    }

    public MatrixWriterException(String message, Throwable cause) {
        super(message, cause);
    }

    public MatrixWriterException(Throwable cause) {
        super(cause);
    }

    public MatrixWriterException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
