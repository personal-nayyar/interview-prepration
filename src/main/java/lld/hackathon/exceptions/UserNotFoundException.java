package lld.hackathon.exceptions;

public class UserNotFoundException extends Exception {
    String message;

    public UserNotFoundException(String message) {
        super(message);
    }
}
