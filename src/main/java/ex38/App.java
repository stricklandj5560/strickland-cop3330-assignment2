/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Jonathan Strickland
 */
package ex38;

import java.util.Scanner;

public class App {
    public static String run() {
        String finalStr = "The even numbers are: ";
        try (Scanner scan = new Scanner(System.in)) {
            System.out.print("Enter a list of numbers, separated by spaces: ");
            // get even nums
            String[] evenNums = filterEvenNumbers(scan.nextLine().split(" "));

            for (int i = 0; i < evenNums.length; i++) {
                if (i == evenNums.length - 1)
                    finalStr += evenNums[i] + ".";
                else
                    finalStr += evenNums[i] + " ";
            }
        }
        return finalStr;
    }

    /**
     * Filters even numbers from a passed array
     * @param array array of numbers
     * @return even numbers.
     */
    private static String[] filterEvenNumbers(String[] array) {
        String n = "";
        for (String num : array) {
            if (Integer.valueOf(num) % 2 == 0)
                n += num + " ";
        }
        return n.split(" ");
    }
}
