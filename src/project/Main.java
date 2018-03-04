package project;

import project.bank.Bank;
import project.exception.InvalidArgumentException;
import project.exception.InvalidLoanAmountException;
import project.exception.MissingFileException;
import project.model.Loan;

import java.io.File;

public class Main {

    public static void main(String[] args) throws Exception {
        //check arguments, throw exception if anything is unexpected
        if (args.length != 2) throw new InvalidArgumentException();

        String arg1 = args[0];
        File file = new File(arg1);
        if (!file.exists()) throw new MissingFileException(arg1);

        String arg2 = args[1];
        int loanAmount = Integer.parseInt(arg2);
        if (!checkLoanAmount(loanAmount)) throw new InvalidLoanAmountException(loanAmount);

        //create bank from file
        Bank bank = new Bank(file);

        if (bank.canProvideLoan(loanAmount)) {
            Loan loan = bank.getLoan(loanAmount);
            System.out.println(loan.getSummary());
        } else {
            System.out.println("It is not possible to provide a quote at this time due to insufficient offers");
        }
    }

    /**
     * Checks if the given loan is between 1000-15000 (inclusive)
     * And increments of 100
     *
     * @param loanAmount
     * @return if the loan is valid
     */
    private static boolean checkLoanAmount(int loanAmount) {
        if (loanAmount < 1000 || loanAmount > 15000) return false;
        if (loanAmount % 100 != 0) return false;
        return true;
    }
}
