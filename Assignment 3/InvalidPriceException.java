public class InvalidPriceException extends Exception {

    public InvalidPriceException() {
        super("Invalid Price!");
    }

    public InvalidPriceException(String message) {
        super(message);
    }
}