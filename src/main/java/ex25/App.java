/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Jonathan Strickland
 */

package ex25;

import java.util.Locale;
import java.util.Scanner;

public class App {
    private static final String alphabet = "abcdefghijklmnopqrstuvwxyz";

    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            System.out.print("Enter a password: ");
            String password = scan.nextLine().trim();
            String strength = "";
            switch (passwordValidator(password)) {
                case 0:
                    strength = "very weak";
                    break;
                case 1:
                    strength = "weak";
                    break;
                case 2:
                    strength = "strong";
                    break;
                case 3:
                    strength = "very strong";
                    break;
                default:
                    break;
            }
            System.out.println("The password " + password + " is a " + strength + " password.");
        }
    }

    /**
     * @param password password input
     * @return 0 if password is very weak, 1 if password is weak,
     * 2 if a password is strong, 3 if a password is very strong.
     */
    private static int passwordValidator(String password) {
        int length = password.length();
        int integerCount = 0;
        int charCount = 0;
        int specialCharCount = 0;
        // get number of integers in password
        for (String s : password.split("")) {
            if (isInt(s)) {
                integerCount++;
            } else if (isSpecialChar(s)) {
                specialCharCount++;
            } else {
                charCount++;
            }
        }
        // very weak / weak
        if (password.length() < 8) {
            // very weak
            if (integerCount == password.length())
                return 0;
            // weak
            if (charCount == password.length())
                return 1;
        }

        // very strong
        if (integerCount >= 1 && specialCharCount >= 1 && charCount >= 1)
            return 3;
        // strong
        if (integerCount >= 1)
            return 2;
        // bad case
        return -1;
    }

    /**
     * Rerturns true if a passed char is an int.
     * @param s
     * @return
     */
    private static boolean isInt(String s) {
        try {
            Integer.valueOf(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private static boolean isSpecialChar(String s) {
        return !alphabet.contains(s.toLowerCase());
    }
}
