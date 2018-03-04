package project.model;

import project.exception.InvalidInputFileException;

public class Lender implements Comparable<Lender> {
    String name;
    double rate;
    double amount;

    public Lender(String line) throws InvalidInputFileException {
        try {
            String[] split = line.split(",");
            this.name = split[0];
            this.rate = Double.parseDouble(split[1]);
            this.amount = Double.parseDouble(split[2]);
        }
        catch (Exception e) {
            throw new InvalidInputFileException(e.getMessage());
        }

    }

    @Override
    public int compareTo(Lender o) {
        return Double.compare(rate, o.rate);
    }

    public String getName() {
        return name;
    }

    public double getRate() {
        return rate;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Lender{");
        sb.append("name='").append(name).append('\'');
        sb.append(", rate=").append(rate);
        sb.append(", amount=").append(amount);
        sb.append('}');
        return sb.toString();
    }
}
