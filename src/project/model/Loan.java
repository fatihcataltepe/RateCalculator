package project.model;

import java.text.DecimalFormat;

public class Loan {
    private static int MONTHS = 60;
    double toReceive;
    double toPay;

    public Loan() {
        this.toReceive = 0;
        this.toPay = 0;
    }

    public void add(double value, double rate) {
        toReceive += value;
        toPay += value * (1 + rate);
    }

    public double getRate() {
        if (toReceive == 0) return 0;
        else return toPay / toReceive - 1;
    }

    public double getMonthlyPayment() {
        return toPay / MONTHS;
    }

    public String getSummary() {
        final StringBuffer sb = new StringBuffer();
        sb.append("Requested amount: £").append(toReceive).append("\n");
        sb.append("Rate: ").append(new DecimalFormat("0.0").format(getRate())).append("%\n");
        sb.append("Monthly repayment: £").append(new DecimalFormat("0.00").format(getMonthlyPayment())).append("\n");
        sb.append("Total repayment: £").append(new DecimalFormat("0.00").format(toPay)).append("\n");

        return sb.toString();
    }
}
