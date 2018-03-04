package project.exception;

public class InvalidLoanValueException extends Exception {

    public InvalidLoanValueException(int value) {
        super("Loan value must be between 1000-15000(inclusive) and increments of 100. Given loan value is " + value);
    }
}
