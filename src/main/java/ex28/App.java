/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Jonathan Strickland
 */
package ex28;

import java.util.Scanner;

public class App {
    public static String run() {
        try (Scanner scan = new Scanner(System.in)) {
            int sum = 0;
            // prompt the user to enter a number 5 times.
            for (int i = 0; i < 5; i++) {
                System.out.print("Enter a number: ");
                sum += scan.nextInt();
            }
            return "The total is " + String.valueOf(sum);
        }
    }
}
