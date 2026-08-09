package com.amigoscode._4_datastructures._5_linkedlists;

// Exercise: LinkedList vs ArrayList Performance Comparison
// Understand when to use LinkedList vs ArrayList by measuring operation times.

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListVsArrayList {
    
    private static void fillList(List<Integer> list) {
        for (int i = 0; i < 10_000; i++) {
            list.add(i);
        }
    }



    private static void addFirstTest(List<Integer> list) {
        long start = System.nanoTime();
        for (int i = 0; i <= 1000; i++) {
            list.add(0, i);
        }
        long end = System.nanoTime();
        long duration = end - start;

        double durationMillis = duration / 1_000_000.0;
        System.out.println("Time of List: " + durationMillis + "ms");
    }


    private static void addLastTest(List<Integer> list) {
        long start = System.nanoTime();
        for (int i = 0; i <= 1000; i++) {
            list.add(i);
        }
        long end = System.nanoTime();
        long duration = end - start;

        double durationMillis = duration / 1_000_000.0;
        System.out.println("Time of List: " + durationMillis + "ms");
    }

    private static void getMiddleElement(List<Integer> list) {
        long start = System.nanoTime();
        for (int i = 0; i <= 1000; i++) {
            list.get(list.size() / 2);
        }
        long end = System.nanoTime();
        long duration = end - start;

        double durationMillis = duration / 1_000_000.0;
        System.out.println("Time of List: " + durationMillis + "ms");
    }
    

    public static void main(String[] args) {

        // TODO: 1 - Create both an ArrayList<Integer> and a LinkedList<Integer>
        //           Fill each with 10000 elements (0 to 9999) using a for loop
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();

        fillList(arrayList);
        fillList(linkedList);


        // TODO: 2 - Measure time to add an element at the beginning (index 0) for both lists
        //           Use System.nanoTime() before and after the operation
        //           Perform the add(0, value) operation 1000 times for each list
        //           Print the time taken for each in milliseconds
        //           (divide nanoseconds by 1_000_000 to get milliseconds)
        System.out.println("---------");
        System.out.println("ArrayList First");
        addFirstTest(arrayList);
        System.out.println("LinkedList First");
        addFirstTest(linkedList);



        // TODO: 3 - Measure time to add an element at the end for both lists
        //           Perform the add(value) operation 1000 times for each list
        //           Print the time taken for each
        System.out.println("---------");
        System.out.println("ArrayList Last");
        addLastTest(arrayList);
        System.out.println("LinkedList Last");
        addLastTest(linkedList);


        // TODO: 4 - Measure time to get an element at the middle index for both lists
        //           Perform get(list.size() / 2) operation 1000 times for each list
        //           Print the time taken for each
        System.out.println("---------");
        System.out.println("ArrayList Middle");
        getMiddleElement(arrayList);
        System.out.println("LinkedList Middle");
        getMiddleElement(linkedList);


        // TODO: 5 - Print a summary explaining the differences
        //           Use System.out.println() to explain:
        //           - Why LinkedList is faster for insertions at the beginning
        //           - Why ArrayList is faster for random access (get by index)
        //           - When you would choose one over the other
        System.out.println("Summary Linked-List & Array-List");
        System.out.println("Why LinkedList is faster for insertions at the beginning: ArrayList must shift all elements & linkedList only change the head-node");
        System.out.println("Why ArrayList is faster for random access (get by index): Array-List direct access via Index / LinkedList walk-trough and find element no index");
        System.out.println("When you would choose one over the other: Fast Insert End/Front: LinkedList | Fast reading Element: ArrayList");
    }
}
