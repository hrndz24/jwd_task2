package by.buyanova.exception;

public class MatrixIndexOutOfBoundsException extends Exception {
    public MatrixIndexOutOfBoundsException() {
    }

    public MatrixIndexOutOfBoundsException(String message) {
        super(message);
    }

    public MatrixIndexOutOfBoundsException(String message, Throwable cause) {
        super(message, cause);
    }

    public MatrixIndexOutOfBoundsException(Throwable cause) {
        super(cause);
    }

    public MatrixIndexOutOfBoundsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
