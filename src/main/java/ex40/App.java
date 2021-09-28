/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Jonathan Strickland
 */
package ex40;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App {
    private static ArrayList<Map<String, String>> employeeDB = new ArrayList<>();

    public static String run() {
        addEntry("John", "Johnson", "Manager", "2016-12-31");
        addEntry("Tou", "Xiong", "Software Engineer", "2016-10-05");
        addEntry("Michaela", "Michaelson", "District Manager", "2015-12-2019");
        addEntry("Jake", "Jacobson", "Programmer","");
        addEntry("Jacquelyn","Jackson", "DBA", "");
        addEntry("Sally", "Webber", "Web Developer", "2015-12-18");
        try (Scanner scan = new Scanner(System.in)) {
            System.out.print("Enter a search string: ");
            printRecords(scan.nextLine());
        }
        return "";
    }

    /**
     * Adds a user to the DB
     * @param fn first name
     * @param ln last name
     * @param position position
     * @param sd separation date
     */
    private static void addEntry(String fn, String ln, String position, String sd) {
        Map<String, String> tempMap = new HashMap<>();
        tempMap.put("ln", ln);
        tempMap.put("fn", fn);
        tempMap.put("pos", position);
        tempMap.put("sd", sd);
        employeeDB.add(tempMap);
    }

    /**
     * Print records with name filter
     */
    private static void printRecords(String searchName) {
        searchName = searchName.toLowerCase();
        System.out.println("\nResults:\n");
        System.out.println("Name\t\t| Position\t\t| Separation Date");
        System.out.println("----------------|----------------|----------------");
        for (Map<String, String> e : employeeDB) {
            if (e.get("fn").toLowerCase().contains(searchName) || e.get("ln").toLowerCase().contains(searchName))
                System.out.println(e.get("fn") + " " + e.get("ln") + "\t\t| " + e.get("pos") + "\t\t\t| " + e.get("sd"));
        }
        employeeDB.forEach(e -> {

        });
    }
}
