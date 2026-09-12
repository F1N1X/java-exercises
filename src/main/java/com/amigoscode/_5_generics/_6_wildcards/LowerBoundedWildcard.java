package com.amigoscode._5_generics._6_wildcards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Exercise: Lower Bounded Wildcards (? super T)
 *
 * A lower bounded wildcard <? super Integer> accepts Integer and all its
 * supertypes (Number, Object). This is useful when you want to WRITE to
 * a generic structure.
 *
 * PECS principle: Producer Extends, Consumer Super.
 * When a list CONSUMES values (you write to it), use "super".
 *
 * Complete the TODOs below.
 */
public class LowerBoundedWildcard {

    // TODO: 1 - Create a static method: void addNumbers(List<? super Integer> list)
    //  It should add the integers 1, 2, and 3 to the list.
    //  This works because any list that holds Integer or a supertype of Integer
    //  can safely accept Integer values.
    public static void addNumbers(List<? super Integer> list) {
        list.add(1);
        list.add(2);
        list.add(3);
    }


    // TODO: 2 - Create a static method:
    //  <T> void moveElements(List<? extends T> source, List<? super T> destination)
    //  It should read each element from source and add it to destination.
    //  This is the PECS principle in action:
    //    source uses "extends" because it PRODUCES elements (we read from it)
    //    destination uses "super" because it CONSUMES elements (we write to it)
    static <T> void moveElements(
            List<? extends T> source,
            List<? super T> destination
    ) {
        for (T element : source) {
            destination.add(element);
        }
    }


    public static void main(String[] args) {

        List<Integer> integerList = new ArrayList<>();
        addNumbers(integerList);
        System.out.println("Integer list: " + integerList);

        List<Number> numberList = new ArrayList<>();
        addNumbers(numberList);
        System.out.println("Number list: " + numberList);

        List<Object> objectList = new ArrayList<>();
        addNumbers(objectList);
        System.out.println("Object list: " + objectList);


        // TODO: 4 - Demonstrate List<? super Integer>

        List<? super Integer> list = new ArrayList<Number>();

        list.add(10);
        list.add(20);
        list.add(30);

        System.out.println("List<? super Integer>: " + list);

        // list.add(3.14);
        // Does not compile because the declared type is List<? super Integer>.
        // Java only guarantees that Integer values can safely be added.
        // Even though the actual object is an ArrayList<Number>,
        // the compiler only looks at the declared wildcard type.


        // TODO: 5 - Move Integer elements into a Number list

        List<Integer> source = Arrays.asList(1, 2, 3, 4, 5);
        List<Number> destination = new ArrayList<>();

        moveElements(source, destination);

        System.out.println("Destination: " + destination);


        // TODO: 6 - PECS explanation
        //
        // PECS = Producer Extends, Consumer Super
        //
        // ? extends T is used when a collection PRODUCES values.
        // We can safely read values from it as type T.
        //
        // ? super T is used when a collection CONSUMES values.
        // We can safely add values of type T to it.
        //
        // In moveElements():
        // source uses ? extends T because we read elements from it.
        // destination uses ? super T because we write elements into it.


        // TODO: 5 - Use moveElements() to move elements from a List<Integer> source
        //  to a List<Number> destination. Print the destination list to verify.


        // TODO: 6 - Add a comment below explaining the PECS principle
        //  (Producer Extends, Consumer Super) as it applies to this exercise.
        //  Why is "super" appropriate when the list is a CONSUMER (we write to it)?
        //  How does this complement the "extends" wildcard?

        // extends looks downward in the inheritance hierarchy.
        //super looks upward in the inheritance hierarchy.

    }
}
