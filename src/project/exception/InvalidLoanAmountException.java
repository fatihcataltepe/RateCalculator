package project.exception;

public class InvalidLoanAmountException extends Exception {

    public InvalidLoanAmountException(int value) {
        super("Loan value must be between 1000-15000(inclusive) and increments of 100. Given loan value is " + value);
    }
}
