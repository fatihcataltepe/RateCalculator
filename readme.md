# Rate Calculator

This application is designed to read lenders from a csv file and offer loans to customers

## Running

```bash
java -jar RateCalculator.jar resources/sample.csv 1000
```

- First parameter should be the path to csv file
- Second parameter should be an integer
- If anything is unexpected, an informative exception will be thrown before executing the application

## Input

### Input file

Sample.csv:

```text
Lender,Rate,Available
Bob,0.075,640
Jane,0.069,480
Fred,0.071,520
Mary,0.104,170
John,0.081,320
Dave,0.074,140
```

- First line should be headers, (and it will be ignored in the application)
- Each line should have three values separated by comma with the following types: String,Double or Integer, Double or Integer

### Input loan amount
- Must be between 1000-15000 (inclusive)
- Must be an increment of 100 (1000,1100,1200, ... 14900, 15000)
- If this is violated, an informative exception will be thrown
 
## Loan calculation

Imagine that the following code is executed in the bash:

```bash
java -jar RateCalculator.jar resources/sample.csv 1000
```

Assume that sample.csv is same as the above.

The application will sort all the lenders according to their rates, and start taking loans from them until the 1000(loan amount is reached)

In this case the following 2 lenders are selected:

```text
Jane,0.069,480
Fred,0.071,520
```

### Total repayment calculation
amount received from Jane: 480
amount to pay to Jane: 480 * (1+0.069) = 513.12

amount received from Fred: 520
amount to pay to Fred: 520 * (1+0.071) = 556.92

556.92+513.12 = 1070.04

### Rate calculation

total repayment/ requested amount - 1
1070.04/1000 - 1 = 0.07

### Monthly repayment calculation
total repayment / 60
= 1070.04 / 60 
= 17.834

## Output

### 1. Loan available

A summary will be printed to standard output in the following format:
```text
Requested amount: £1500.0
Rate: 0.7%
Monthly repayment: £41.67
Total repayment: £2500.00
```

Note that, all the the values are rounded.

### 2.Loan is not available

The following line will be printed to standard output:
```text
It is not possible to provide a quote at this time due to insufficient offers
```

## Other Notes
- If the input file contains corrupted lines an informative exception will be thrown
- There is no logging, exceptions are used instead




