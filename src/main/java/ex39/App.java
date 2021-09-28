/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Jonathan Strickland
 */
package ex39;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class App {

    private static ArrayList<Map<String, String>> employeeDB = new ArrayList<>();

    public static String run() {
        addEntry("John", "Johnson", "Manager", "2016-12-31");
        addEntry("Tou", "Xiong", "Software Engineer", "2016-10-05");
        addEntry("Michaela", "Michaelson", "District Manager", "2015-12-2019");
        addEntry("Jake", "Jacobson", "Programmer","");
        addEntry("Jacquelyn","Jackson", "DBA", "");
        addEntry("Sally", "Webber", "Web Developer", "2015-12-18");
        printRecords();
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
     * Print
     */
    private static void printRecords() {
        System.out.println("Name\t\t| Position\t\t| Separation Date");
        System.out.println("----------------|----------------|----------------");
        sortRecords().forEach(e -> {
            System.out.println(e.get("fn") + " " + e.get("ln") + "\t\t| " + e.get("pos") + "\t\t\t| " + e.get("sd"));
        });
    }

    /**
     * Sorts records by last name
     */
    private static ArrayList<Map<String, String>> sortRecords() {
        ArrayList<Map<String, String>> returnMap = new ArrayList<>();
        Map<String, Integer> lnToIndex = new HashMap<>();
        ArrayList<String> tempList = new ArrayList<>();
        // map last name to index
        employeeDB.forEach(e -> {
            lnToIndex.put(e.get("ln"), employeeDB.indexOf(e));
            // let's also add the last name to a temp list
            tempList.add(e.get("ln"));
        });
        // get the sorted map
        tempList.stream().sorted().forEach(s -> returnMap.add(employeeDB.get(lnToIndex.get(s))));
        return returnMap;
    }
}
