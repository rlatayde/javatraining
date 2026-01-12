package m4_activity5;

//Custom Exceptions

@SuppressWarnings("serial")
public class InvalidAccountFormatException extends RuntimeException {
    public InvalidAccountFormatException(String message) {
        super(message);
    }
}