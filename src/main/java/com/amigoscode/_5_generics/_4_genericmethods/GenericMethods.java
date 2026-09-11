package com.amigoscode._5_generics._4_genericmethods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Exercise: Generic Methods
 *
 * This exercise focuses on writing static generic methods.
 * Generic methods declare their own type parameters independently
 * of any generic class. The type parameter appears before the return type.
 *
 * Complete the TODOs below.
 */
public class GenericMethods {

    // TODO: 1 - Create a static generic method: <T> void printArray(T[] array)
    //  It should print each element of the array on the same line separated
    //  by spaces, then print a newline at the end.
    public static <T> void printArray(T[] array) {
        System.out.println(Arrays.toString(array));
    }


    // TODO: 2 - Create a static generic method: <T> T getFirst(List<T> list)
    //  It should return the first element of the list.
    //  If the list is empty, return null.

    public static <T> T getFirst(List<T> list) {
        if (list.isEmpty()) return null;
        return list.getFirst();
    }


    // TODO: 3 - Create a static generic method: <T> T getLast(List<T> list)
    //  It should return the last element of the list.
    //  If the list is empty, return null.

    public static <T> T getLast(List <T> list) {
        if (list.isEmpty()) return null;
        return list.getLast();
    }


    // TODO: 4 - Create a static generic method: <T> List<T> filterNulls(List<T> list)
    //  It should return a new list containing only the non-null elements
    //  from the original list. Do not modify the original list.
    public static <T> List<T> filterNulls(List<T> list) {
        return list.stream()
                .filter(Objects::nonNull)
                .toList();
    }


    // TODO: 5 - Create a static generic method: <T> boolean contains(T[] array, T target)
    //  It should return true if the target is found in the array.
    //  Use the equals() method for comparison (handle null target).

    public static <T> boolean contains(T[] array, T target) {
        return Arrays.stream(array)
                .filter(e -> e.equals(target))
                .anyMatch(e -> e.equals(target));
    }




    public static void main(String[] args) {

        // TODO: 6 - Call all five methods above:
        //  (a) printArray with a String[] and an Integer[]
        //  (b) getFirst and getLast with a List<String> of names
        //  (c) filterNulls with a list that contains some null values
        //  (d) contains to search for an element in an array

        String[] names = {"Ambia", "Mambia" , "Sambia", "Rambia"};
        printArray(names);

        Integer[] ages = {11, 24, 33, 12, 33};
        printArray(ages);

        List<String> list = new ArrayList<>();
        System.out.println(getFirst(list));
        list.add("hello");
        list.add("bell");
        System.out.println(getFirst(list));


        List<String> names2 = new ArrayList<>();
        names2.add(null);
        names2.add("Hallo");
        names2.add(null);
        names2.add("Beta");
        names2.add(null);
        System.out.println(filterNulls(names2));

        System.out.println(contains(names, "Tosi"));
    }
}
