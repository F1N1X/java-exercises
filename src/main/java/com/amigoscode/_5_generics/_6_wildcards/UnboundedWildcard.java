package com.amigoscode._5_generics._6_wildcards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Exercise: Unbounded Wildcards (?)
 *
 * The unbounded wildcard <?> represents an unknown type.
 * A List<?> can refer to a list of any type, but you cannot add elements
 * to it (except null) because the compiler does not know the actual type.
 *
 * Complete the TODOs below.
 */
public class UnboundedWildcard {

    // TODO: 1 - Create a static method: void printList(List<?> list)
    //  It should iterate through the list and print each element.
    //  Note: elements come out as Object since the type is unknown.
    public void printList(List<?> list) {
        list.forEach(System.out::println);
    }


    // TODO: 2 - Create a static method: int getSize(List<?> list)
    //  It should return the size of any list, regardless of its type.
    public static int getSize(List<?> list) {
        return list.size();
    }


    public static void main(String[] args) {

        // TODO: 3 - Create three lists:
        //  (a) List<String> with values "Hello", "World"
        //  (b) List<Integer> with values 1, 2, 3
        //  (c) List<Double> with values 1.1, 2.2, 3.3
        //  Call printList() and getSize() with each of them.
        List<String> list = List.of("Hello","World");
        List<Integer> numbers = List.of(1,2,3);
        List<Double> doubles = List.of(1.0, 2.0, 3.3);


        // TODO: 4 - Demonstrate that you CANNOT add elements to a List<?>.
        //  Uncomment the code below, observe the compile error, then comment
        //  it back out. Add a comment explaining why adding is not allowed.
        //
        //List<?> unknownList = Arrays.asList("a", "b", "c");
        //unknownList.add("d");       // Why does this not compile?
        // unknownList.add(1);         // Why does this not compile either?
        // List<?> means a list of an unknown element type.
        // Since the compiler does not know the exact type,
        // we cannot safely add a String, Integer, or any other value.
        // We can only safely read elements as Object.

        // TODO: 5 - Demonstrate what you CAN do with List<?>:
        //  (a) Get the size
        //  (b) Check if it is empty
        //  (c) Read elements as Object
        //  (d) Remove elements (by index or using clear())
        //  Write code showing at least two of these operations on a List<?>.
        List<?> list2 = new ArrayList<String>(
                Arrays.asList("a", "b", "c")
        );

        // List-Collections support these operations

    }
}
