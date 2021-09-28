/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Jonathan Strickland
 */
package ex31;

import java.util.Scanner;

public class App {
    public static String run() {
        String output = "";
        try (Scanner scan = new Scanner(System.in)) {
            double age = 0;
            double restingPulse = 0;
            // get valid age / resting pulse
            age = getReturn(scan, "Enter age: ");
            restingPulse = getReturn(scan, "Enter resting pulse: ");
            // format string
            output += "Resting Pulse: " + restingPulse + "\t\t" + "Age: " + age;
            output += "\n\nIntensity\t| Rate\n";
            output += "------------|--------\n";
            // increment percentages by 5 from 55-95
            for (int i = 55; i < 96; i += 5) {
                output += i + "%\t\t\t| " + getTargetRate(i, restingPulse, age) + " bpm";
                output += "\n";
            }
        }
        return output;
    }

    /**
     * Recursive method to get a valid input from a user
     * @param scan scanner
     * @return value user inputted
     */
    public static double getReturn(Scanner scan, String prompt) {
        System.out.print(prompt);
        String input = scan.nextLine();
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

    /**
     * Calculates target rate
     * @param percent intensity
     * @param restingHR resting heart rate
     * @param age age
     * @return target heart rate
     */
    public static int getTargetRate(double percent, double restingHR, double age) {
        double output = 220 - age;
        output -= restingHR;
        output *= (double) (percent / 100);
        output += restingHR;
        return (int) Math.round(output);
    }
}
