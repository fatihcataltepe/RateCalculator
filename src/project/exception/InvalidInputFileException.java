package project.exception;

public class InvalidInputFileException extends Exception {
    public InvalidInputFileException(String originalMessage) {
        super("Input file contains unexpected formatted data. " + originalMessage);
    }
}
