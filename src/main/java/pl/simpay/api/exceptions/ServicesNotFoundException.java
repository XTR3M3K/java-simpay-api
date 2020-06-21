package pl.simpay.api.exceptions;

public class ServicesNotFoundException extends RuntimeException {
    public ServicesNotFoundException() {
    }

    public ServicesNotFoundException(String message) {
        super(message);
    }
}
