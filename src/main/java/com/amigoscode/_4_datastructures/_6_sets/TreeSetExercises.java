package com.amigoscode._4_datastructures._6_sets;

// Exercise: TreeSet Operations
// Learn how to use TreeSet - a sorted set implementation backed by a TreeMap.

import java.util.SortedSet;
import java.util.TreeSet;

public class TreeSetExercises {

    public static void main(String[] args) {

        // TODO: 1 - Create a TreeSet of Integers called 'numbers'
        TreeSet<Integer> numbers = new TreeSet<>();


        // TODO: 2 - Add these elements: 50, 20, 40, 10, 30, 60, 15, 45
        //           Print the set and observe that elements are automatically sorted
        numbers.add(50);
        numbers.add(20);
        numbers.add(1);
        numbers.add(22);
        numbers.add(77);
        numbers.add(34);

        System.out.println(numbers);


        // TODO: 3 - Get and print the first (lowest) element using first()
        //           Get and print the last (highest) element using last()
        System.out.println("First: " + numbers.first());
        System.out.println("Last: " + numbers.last());

        // TODO: 4 - Get a subset of elements from 20 (inclusive) to 45 (exclusive) using subSet()
        //           Print the subset
        System.out.println("Get a subset of elements from 20 (inclusive) to 45 (exclusive) using subSet()");
        SortedSet<Integer> integers = numbers.subSet(20, 50);
        System.out.println(integers);

        // TODO: 5 - Get and print the headSet (elements less than 30)
        //           Get and print the tailSet (elements greater than or equal to 30)
        System.out.println("Elements less than 30");
        SortedSet<Integer> headSet = numbers.subSet(numbers.first(), 30);
        System.out.println(headSet);

        System.out.println("Elements greater than or equal to 30");
        SortedSet<Integer> tailSet = numbers.subSet(30, true, numbers.last(), true);
        System.out.println(tailSet);
        // TODO: 6 - Iterate over the TreeSet using a for-each loop
        //           Print each element and observe the natural ascending order

        for (int element : numbers)
            System.out.println(element);
    }
}
