/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Jonathan Strickland
 */
package ex30;

public class App {
    private static final int tableSize = 12;
    public static String run() {
        return getTable();
    }

    public static String getTable() {
        String returnTable = "";
        // compute multiplication table
        for (int row = 1; row < tableSize + 1; row++) {
            int sum = 0;
            for (int col = 1; col < tableSize + 1; col++) {
                sum += row;
                returnTable += sum + "\t";
            }
            returnTable += "\n";
        }
        return returnTable;
    }
}
