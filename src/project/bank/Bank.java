package project.bank;

import project.model.Lender;
import project.model.Loan;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.PriorityQueue;

public class Bank {
    int totalLoan = 0;
    PriorityQueue<Lender> lenders;

    public Bank(File file) throws Exception {
        lenders = new PriorityQueue<Lender>();
        BufferedReader reader = new BufferedReader(new FileReader(file));

        //first line is headers, skip
        String line = reader.readLine();

        line = reader.readLine();
        while (line != null) {
            Lender lender = new Lender(line);
            lenders.add(lender);
            totalLoan += lender.getAmount();
            line = reader.readLine();
        }
    }

    public boolean canProvideLoan(int loanValue) {
        return totalLoan >= loanValue;
    }

    /**
     * creates a loan object and updates its info
     * according to lenders and loan amount
     *
     * @param loanValue
     * @return Loan object contains the amount to recieve and amount to pay
     */
    public Loan getLoan(int loanValue){
        Loan loan = new Loan();

        while(loanValue>0 && !lenders.isEmpty()){
            Lender curr = lenders.remove();
            double amountFromCurr = Math.min(loanValue, curr.getAmount());
            loan.add(amountFromCurr, curr.getRate());
            loanValue -= amountFromCurr;
        }

        return loan;
    }
}
