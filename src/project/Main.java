package project;

import project.exception.InvalidArgumentException;
import project.exception.InvalidLoanValueException;
import project.exception.MissingFileException;

import java.io.File;

public class Main {

    public static void main(String[] args) throws Exception {
        //check arguments
        if (args.length != 2) throw new InvalidArgumentException();

        String arg1 = args[0];
        File file = new File(arg1);
        if (!file.exists()) throw new MissingFileException(arg1);
        System.out.println("File is created");

        //throws exception if the second parameter is not an integer
        String arg2 = args[1];
        int loanValue = Integer.parseInt(arg2);
        if(!checkLoanValue(loanValue)) throw new InvalidLoanValueException(loanValue);
        System.out.println("Loan value is created");


    }

    /**
     * Checks if the given loan is between 1000-15000 (inclusive)
     * And increments of 100
     *
     * @param loan value
     * @return if the loan is valid
     */
    private static boolean checkLoanValue(int loan){
        if(loan < 1000 || loan > 15000) return false;
        if(loan % 100 != 0) return false;
        return true;
    }
}
