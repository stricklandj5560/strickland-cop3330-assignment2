/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Jonathan Strickland
 */
package ex24;

import java.util.Scanner;

/**
 * Anagram checker
 */
public class App {
    public static String run() {
        try (Scanner scan = new Scanner(System.in)){
            String s1 = "";
            String s2 = "";
            System.out.println("Enter two strings and I'll tell if you if they are anagrams: ");
            System.out.print("Enter your first string: ");
            s1 = scan.nextLine();
            System.out.print("Enter your second string: ");
            s2 = scan.nextLine();
            return ("\"" + s1 + "\"" + " and \"" + s2 + "\" are" + (isAnagram(s1, s2) ? " " : " not " ) + "anagrams.");
        }
    }

    /**
     * Returns true if s1 and s2 are anagrams.
     * @param s1 string 1
     * @param s2 string 2
     */
    private static boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;
        // check to see if every char in s1 is in s2.
        for (String s : s1.split("")) {
            if (!s2.contains(s))
                return false;
        }
        return true;
    }
}
