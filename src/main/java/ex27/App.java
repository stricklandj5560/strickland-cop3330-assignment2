/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Jonathan Strickland
 */
package ex27;

import java.util.Scanner;

public class App {

    private static final String alphabet = "abcdefghijklmnopqrstuvwxyz";

    public static String run() {
        try (Scanner scan = new Scanner(System.in)) {
            String fn, ln, id, zip;
            System.out.print("Enter the first name: ");
            fn = scan.nextLine();
            System.out.print("Enter last name: ");
            ln = scan.nextLine();
            System.out.print("Enter the ZIP code: ");
            zip = scan.nextLine();
            System.out.print("Enter the emplyee ID: ");
            id = scan.nextLine();
            return validateInput(fn, ln, id, zip);
        }
    }

    /**
     * Validates input
     * @param fn first name
     * @param ln last name
     * @param id employee id
     * @param zip zip code
     * @return validation string
     */
    private static String validateInput(String fn, String ln, String id, String zip) {
        String output = "";
        if (!isIDValid(id))
            output += "Employee ID must be in the format of AA-1234\n";
        if (!isNameValid(fn))
            output += "Employee first name must 2 characters long.\n";
        if (!isNameValid(ln))
            output += "Employee last name must 2 characters long.\n";
        if (!isZipValid(zip))
            output += "The zipcode must be a 5 digit number.\n";

        return output.isEmpty() ? "There were no errors found." : output;
    }

    /**
     * Validates ID
     * @param id id
     * @return true if ID input is valid.
     */
    private static boolean isIDValid (String id) {
        if (!id.contains("-"))
            return false;
        String[] idSplit = id.split("-");
        String[] letters = idSplit[0].split("");
        String[] numbers = idSplit[1].split("");
        // check lengths.
        if (letters.length != 2)
            return false;
        if (numbers.length != 4)
            return false;
        // check to see if first half of string are letters
        for (String s : letters) {
            if (!alphabet.contains(s.toLowerCase()))
                return false;
        }
        // check if second half of string are numbers
        for (String number : numbers) {
            if (!isInt(number))
                return false;
        }
        return true;
    }

    /**
     * Validates zip code
     * @param zip zip code
     * @return true if zip code is valid.
     */
    private static boolean isZipValid(String zip) {
        return (isInt(zip) && zip.length() == 5);
    }

    /**
     * Validates a name
     * @param name name of employee
     * @return true if name is valid
     */
    private static boolean isNameValid(String name) {
        return name.trim().length() >= 2;
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
}
