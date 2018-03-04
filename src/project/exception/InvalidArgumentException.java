package project.exception;

public class InvalidArgumentException extends Exception {
    public InvalidArgumentException() {
        super("There must be 2 arguments to call the application");
    }
}
