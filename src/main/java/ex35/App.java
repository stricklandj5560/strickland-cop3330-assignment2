/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Jonathan Strickland
 */
package ex35;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class App {
    private static ArrayList<String> input = new ArrayList<>();
    public static String run() {
        try (Scanner scan = new Scanner(System.in)) {
            addEntry(scan);
            // Pick random winner
            return "The winner is... " + input.get(new Random().nextInt(input.size())) + ".";
        }
    }

    /**
     * Adds entries to input array
     * @param scan scanner
     */
    private static void addEntry(Scanner scan) {
        System.out.print("Enter a name: ");
        String name = scan.nextLine();
        // check for exit case
        if (name.trim().toLowerCase().isEmpty())
            return;
        input.add(name);
        addEntry(scan);
    }
}

