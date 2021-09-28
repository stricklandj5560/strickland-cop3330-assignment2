/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Jonathan Strickland
 */
package ex32;

import java.util.Random;
import java.util.Scanner;

public class App {
    private static int target = 0;
    private static int numOfGuesses = 0;

    public static String run() {
        try (Scanner scan = new Scanner(System.in)) {
            numOfGuesses = 0;
            System.out.println("\nLet's play Guess the Number!\n");
            int difficulty = getDifficulty(scan);
            Random rand = new Random();
            switch (difficulty) {
                // 1 -> 1-10
                case 1:
                    target = rand.nextInt(10) + 1;
                    break;
                // 2 -> 1-100
                case 2:
                    target = rand.nextInt(100) + 1;
                    break;
                // 3 -> 1-1000
                case 3:
                    target = rand.nextInt(1000) + 1;
                    break;
                default:
                    return "Ruh-roh, that's not supposed to happen!";
            }
            System.out.println("PSST: " + target);
            System.out.println(String.format("You got it in %d guesses!", doGuess(scan, "I have my number. What's your guess? ")));
            System.out.print("Would you like to play again? (Y/N) ");
            if (scan.nextLine().trim().toLowerCase().equals("y"))
                return run();
            else
                return "";
        }
    }

    /**
     * Method to play guessing game
     * @param scan scanner
     * @param message message to prompt user with
     * @return number of guesses
     */
    private static int doGuess(Scanner scan, String message) {
        int guess = getGuess(scan, message);
        numOfGuesses++;
        if (guess > target)
            return doGuess(scan, "Too high. Guess again: ");
        if (guess < target)
            return doGuess(scan, "Too low. Guess again: ");
        return numOfGuesses;
    }

    /**
     * Recursive method to get a valid input from a user
     * @param scan scanner
     * @return value user inputted
     */
    private static int getDifficulty(Scanner scan) {
        System.out.print("Enter the difficulty level (1, 2, or 3): ");
        String input = scan.nextLine();
        if (!isInt(input)) {
            System.out.println("Sorry. That's not a valid input. Please enter a valid number.");
            return getDifficulty(scan);
        }
        if (Integer.valueOf(input) < 1 || Integer.valueOf(input) > 3) {
            return getDifficulty(scan);
        }
        return Integer.valueOf(input);
    }

    /**
     * Recursive method to get a valid input from a user
     * @param scan scanner
     * @return value user inputted
     */
    private static int getGuess(Scanner scan, String prompt) {
        System.out.print(prompt);
        String input = scan.nextLine();
        if (!isInt(input)) {
            System.out.println("Sorry. That's not a valid input. Please enter a valid number.");
            numOfGuesses++;
            return getGuess(scan, prompt);
        }
        return Integer.valueOf(input);
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
