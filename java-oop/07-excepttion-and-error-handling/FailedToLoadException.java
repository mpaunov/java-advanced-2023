public class FailedToLoadException extends RuntimeException {

    public FailedToLoadException(String message) {
        super(message);
    }

    public FailedToLoadException(String message, Exception cause) {
        super(message, cause);
    }

}
