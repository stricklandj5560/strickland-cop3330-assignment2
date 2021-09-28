/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Jonathan Strickland
 */
package ex37;

import java.util.*;

public class App {
    private static List<String> specialChars = Arrays.asList(new String[]{"!","@","$","%","#","&"});
    private static List<String> letters = Arrays.asList("abcdefghijklmnopqrstuvwxyz".split(""));

    public static String run() {
        try (Scanner scan = new Scanner(System.in)) {
            System.out.print("What's the minimum length? ");
            int minLen, specCh, nums;
            minLen = scan.nextInt();
            System.out.print("What's the number of special characters? ");
            specCh = scan.nextInt();
            System.out.print("What's the number of numbers? ");
            nums = scan.nextInt();
            return "Your password is: " + genPasssword(minLen, specCh, nums);
        }
    }

    /**
     * Generates a random password
     * @param minLen length
     * @param specChar num of special characters
     * @param nums number of numbers
     * @return
     */
    private static String genPasssword(int minLen, int specChar, int nums) {
        String returnStr = "";
        if (minLen < specChar + nums)
            return "Special characters + nums is greater than length";
        String[] password = new String[minLen];
        // create random password
        // special characters
        for (int i = 0; i < specChar; i++)
            password[chooseIndex(password)] = specialChars.get(new Random().nextInt(specialChars.size()));
        // nums
        for (int i = 0; i < nums; i++)
            password[chooseIndex(password)] = String.valueOf(new Random().nextInt(10));
        // fill in with random letters
        for (int i = 0; i < password.length; i++) {
            if (password[i] == null)
                password[i] = letters.get(new Random().nextInt(letters.size()));
        }
        // build password
        for (String s : password) {
            returnStr += s;
        }
        return returnStr;
    }

    /**
     * Chooses an empty index for a char
     * @param password current password
     * @return index to put char in
     */
    private static int chooseIndex(String[] password) {
        int randIndex = new Random().nextInt(password.length);
        if (password[randIndex] != null)
            return chooseIndex(password);
        return randIndex;
    }
}
