/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Jonathan Strickland
 */
package ex29;

import java.util.Scanner;

public class App {
    public static String run() {
        try (Scanner scan = new Scanner(System.in)) {
            return "It will take " + 72 / getReturn(scan) +
                    " years to double your initial investment.";
        }
    }

    /**
     * Recursive method to get a valid input from a user
     * @param scan scanner
     * @return value user inputted
     */
    public static double getReturn(Scanner scan) {
        System.out.print("What is the rate of return? ");
        String input = scan.nextLine();
        if (!isInt(input)) {
            System.out.println("Sorry. That's not a valid input.");
            return getReturn(scan);
        }
        if (Double.valueOf(input) == 0) {
            System.out.println("Sorry. Zero is not a valid input.");
            return getReturn(scan);
        }
        return Double.valueOf(input);
    }

    /**
     * Rerturns true if a passed char is an int.
     * @param s
     * @return
     */
    private static boolean isInt(String s) {
        s = s.trim();
        try {
            Integer.valueOf(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
