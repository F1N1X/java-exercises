package com.amigoscode._4_datastructures._7_maps;

// Exercise: HashMap Operations
// Learn how to use HashMap - a key-value pair data structure for fast lookups.

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapExercises {

    public static void main(String[] args) {

        // TODO: 1 - Create a HashMap<String, Integer> called 'studentGrades'
        //           This will store student names as keys and their grades as values
        HashMap<String, Integer> studentGrades = new HashMap<>();


        // TODO: 2 - Put 5 entries into the map:
        //           "Alice" -> 92, "Bob" -> 85, "Charlie" -> 78, "Diana" -> 95, "Eve" -> 88
        studentGrades.put("Alice", 92);
        studentGrades.put("Bob", 85);
        studentGrades.put("Charlie", 78);
        studentGrades.put("Diana", 95);
        studentGrades.put("Eve", 95);



        // TODO: 3 - Get the grade for "Charlie" using get() and print it
        System.out.println(studentGrades.get("Charly"));


        // TODO: 4 - Check if the key "Bob" exists using containsKey()
        //           Print the result
        System.out.println("Contains Key Bob: " + studentGrades.containsKey("Bob"));


        // TODO: 5 - Check if the value 95 exists using containsValue()
        //           Print the result
        System.out.println("Exist 95 in Map " + studentGrades.containsValue(95));


        // TODO: 6 - Remove the entry for "Eve" using remove()
        //           Print the map after removal
        System.out.println(studentGrades.remove("Eve"));
        System.out.println(studentGrades);


        // TODO: 7 - Iterate over the entrySet() using a for-each loop
        //           Print each entry in the format: "Student: <name>, Grade: <grade>"
        System.out.println("Entry Set");
        for (var entry : studentGrades.entrySet())
            System.out.println(entry);


        // TODO: 8 - Iterate over just the keys using keySet() and print them
        //           Then iterate over just the values using values() and print them
        System.out.println("Key Set");
        for (String key : studentGrades.keySet())
            System.out.println(key);

    }
}
