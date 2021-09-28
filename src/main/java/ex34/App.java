/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Jonathan Strickland
 */
package ex34;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    private static ArrayList employees = new ArrayList<String>();
    public static String run() {
        employees.add("John Smith");
        employees.add("Jackie Jackson");
        employees.add("Chris Jones");
        employees.add("Amanda Cullen");
        employees.add("Jermey Goodwin");
        printEmployees();
        System.out.print("\nEnter an employee to remove: ");
        try (Scanner scan = new Scanner(System.in)) {
            removeEmployee(scan.nextLine());
        }
        return "";
    }

    private static void removeEmployee(String employee) {
        int initLen = employees.size();
        // remove employee
        employees.removeIf(name -> ((String) name)
                .toLowerCase().equals(employee.trim().toLowerCase()));
        if (initLen == employees.size()) {
            System.out.println("Employee \"" + employee + "\" doesn't exist!");
        } else {
            printEmployees();
        }
    }

    /**
     * Prints employees to the console.
     */
    private static void printEmployees() {
        System.out.println("There are " + employees.size() + " employees: ");
        employees.forEach(em -> System.out.println(em));
    }


}
