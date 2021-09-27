/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Jonathan Strickland
 */

package ex26;

import java.util.Scanner;

public class App {
    public static String run() {
        try (Scanner scan = new Scanner(System.in)) {
            double balance = 0;
            double apr = 0;
            double monthlyPayment = 0;
            System.out.print("What is your balance? ");
            balance = scan.nextDouble();
            System.out.print("What is the APR on the card (as a percent)? ");
            apr = (double) (scan.nextDouble() / 100);
            System.out.print("WHat is the monthly payment you can make? ");
            monthlyPayment = scan.nextDouble();
            return "It will take you " + PaymentCalculator.calculateMonthsUntilPaidOff(balance, apr, monthlyPayment)
                    + " months to pay off this card.";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}

class PaymentCalculator extends App {
    /**
     * Returns the number of months until the interest can be paid off
     * @param b balance
     * @param i APR
     * @param p monthly payment
     */
    public static int calculateMonthsUntilPaidOff(double b, double i, double p) {
        double n = 0;
        // calculate daily rate.
        p = p / 365;
        // n = -(1/30) * log(1 + b/p * (1 - (1 + i)^30)) / log(1 + i)
        n = (-1/30) * (Math.log(1 + (b/p * (1 - Math.pow((1 + i), 30)))) / Math.log(1 + i));
        return (int) Math.round(n);
    }
}

