package ex36;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class App {
    private static ArrayList<Double> dList = new ArrayList<>();

    public static String run() {
        try (Scanner scan = new Scanner(System.in)) {
            getStats(scan);
        }
        return "";
    }

    /**
     * Gets the inputs for stats
     * @param scan scanner
     */
    public static void getStats(Scanner scan) {
        double num = getReturn(scan, "Enter a number: ");
        if (num == -1) {
            printResults();
            return;
        }
        dList.add(num);
        // continue to capture input from user.
        getStats(scan);
    }

    /**
     * Prints the results
     */
    private static void printResults() {
        double average = 0;
        double minimum = dList.size() == 0 ? 0 : Double.MAX_VALUE;
        double maximum = 0;
        double stdDev = 0;
        for (double num : dList) {
            average += num;
            // check for min
            if (num < minimum)
                minimum = num;
            // check for max
            if (num > maximum)
                maximum = num;
        }
        if (average != 0)
            average /= dList.size();

        // get standard deviation
        for (double num : dList) {
            stdDev += Math.pow(num - average, 2);
        }
        if (dList.size() != 0)
            stdDev = (double) Math.round(100 * Math.sqrt(stdDev / dList.size())) / 100;
        // print results
        System.out.print("Numbers: ");
        dList.forEach(num -> System.out.print(num + ", "));

        System.out.println("\nThe average is: " + average);
        System.out.println("The minimum is: " + minimum);
        System.out.println("The maximum is: " + maximum);
        System.out.println("The standard deviation is " + stdDev);
    }

    /**
     * Recursive method to get a valid input from a user
     * @param scan scanner
     * @return value user inputted, returns -1 if "done" is inputted
     */
    private static double getReturn(Scanner scan, String prompt) {
        System.out.print(prompt);
        String input = scan.nextLine();
        if (input.trim().toLowerCase().equals("done"))
            return -1;
        if (!isInt(input)) {
            System.out.println("Sorry. That's not a valid input.");
            return getReturn(scan, prompt);
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
