package m4_activity5;


// Custom Exceptions
@SuppressWarnings("serial")
public class InvalidAccountNumberException extends Exception {
    public InvalidAccountNumberException(String message) {
        super(message);
    }
}

