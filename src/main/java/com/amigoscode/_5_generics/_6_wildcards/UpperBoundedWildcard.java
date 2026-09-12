package com.amigoscode._5_generics._6_wildcards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Exercise: Upper Bounded Wildcards (? extends T)
 *
 * An upper bounded wildcard <? extends Number> accepts Number and all its
 * subclasses. This is useful when you want to READ from a generic structure
 * but do not need to WRITE to it.
 *
 * PECS principle: Producer Extends, Consumer Super.
 * When a list PRODUCES values (you read from it), use "extends".
 *
 * Complete the TODOs below.
 */
public class UpperBoundedWildcard {

    // TODO: 1 - Create a static method: double sumOfList(List<? extends Number> list)
    //  It should iterate through the list and sum all elements using doubleValue().
    //  Return the total sum.

    static double sumOfList(List<? extends Number> list) {
        return list.stream()
                .mapToDouble(Number::doubleValue)
                .sum();
    }


    // TODO: 2 - Create a static method:
    //  void copyToNumberList(List<? extends Number> source, List<Number> destination)
    //  It should copy all elements from source into destination.
    //  This works because anything that extends Number IS-A Number.


    static void copyToNumberList(
            List<? extends Number> source,
            List<Number> destination
    ) {
        destination.addAll(source);
    }



    public static void main(String[] args) {

        // TODO: 3 - Create three lists and call sumOfList() with each:
        //  (a) List<Integer> with values 1, 2, 3, 4, 5
        //  (b) List<Double> with values 1.5, 2.5, 3.5
        //  (c) List<Long> with values 100L, 200L, 300L
        //  Print the sum for each.


        // TODO: 4 - Demonstrate that you CANNOT add to List<? extends Number>.
        //  Uncomment the code below, observe the compile error, then comment
        //  it back out. Add a comment explaining why.
        //
        // List<? extends Number> numbers = new ArrayList<Integer>();
        // numbers.add(1);       // Why doesn't this compile?
        // numbers.add(1.0);     // Why doesn't this compile?
        // Hint: The compiler doesn't know the actual type. The list could be
        // List<Integer>, List<Double>, or any other Number subclass.


        // TODO: 5 - Use copyToNumberList() to copy a List<Integer> into a
        //  List<Number>. Print the destination list to verify it worked.


        // TODO: 6 - Add a comment below explaining the PECS principle
        //  (Producer Extends, Consumer Super) as it applies to this exercise.
        //  Why is "extends" appropriate when the list is a PRODUCER (we read from it)?

        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        List<Double> doubles = Arrays.asList(1.5, 2.5, 3.5);
        List<Long> longs = Arrays.asList(100L, 200L, 300L);

        System.out.println("Integer sum: " + sumOfList(integers));
        System.out.println("Double sum: " + sumOfList(doubles));
        System.out.println("Long sum: " + sumOfList(longs));


        // TODO: 4

        List<? extends Number> numbers = new ArrayList<Integer>();

        // numbers.add(1);
        // numbers.add(1.0);

        // Does not compile because the exact type behind
        // ? extends Number is unknown.
        // It could be List<Integer>, List<Double>, List<Long>, etc.
        // Therefore Java cannot know which Number subtype is safe to add.


        // TODO: 5

        List<Integer> source = Arrays.asList(10, 20, 30);
        List<Number> destination = new ArrayList<>();

        copyToNumberList(source, destination);

        System.out.println("Destination: " + destination);


        // TODO: 6
        //
        // PECS = Producer Extends, Consumer Super
        //
        // "extends" is used here because source PRODUCES values.
        // We read Number values from source.
        //
        // List<? extends Number> means the list can contain
        // Number or any subclass of Number, such as Integer,
        // Double, or Long.
        //
        // Since every element is guaranteed to be a Number,
        // we can safely read elements from the list as Number.

    }
}
