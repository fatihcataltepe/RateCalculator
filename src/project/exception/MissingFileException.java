package project.exception;

public class MissingFileException extends Exception {

    public MissingFileException(String path) {
        super("There is not a file in the given path: " + path);
    }
}
