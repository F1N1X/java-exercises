package com.amigoscode._6_functionalinterfaces._2_functionalinterfaces;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Exercise: Consumer<T> and BiConsumer<T, U>
 *
 * Consumer represents an operation that accepts a single input and returns no
 * result (void). It is used for side effects such as printing or modifying state.
 * Key methods:
 *   - void accept(T t)
 *   - andThen(Consumer after) chains another consumer after this one
 *
 * BiConsumer is similar but takes two arguments.
 */
public class ConsumerExercise {

    public static void main(String[] args) {

        // TODO: 1 - Create a Consumer<String> called 'greeter' that prints
        //  "Hello, <name>!" for a given name.
        //  Example: accept("Alice") prints "Hello, Alice!"
        Consumer<String> greeter = s -> System.out.printf("Hello, %s!\n", s);
        greeter.accept("Franc");


        // TODO: 2 - Create a Consumer<String> called 'shouter' that prints
        //  the string in uppercase.
        //  Example: accept("hello") prints "HELLO"
        Consumer<String> shouter = s -> System.out.println(s.toUpperCase());
        shouter.accept("Hello");


        // TODO: 3 - Chain 'greeter' and 'shouter' using andThen() to create
        //  a new Consumer called 'greetThenShout'. When you call
        //  greetThenShout.accept("Alice"), it should first print the greeting,
        //  then print "ALICE".
        Consumer<String> greeterWithHello = s -> System.out.println("Hello " + s);
        Consumer<String> upper = s -> System.out.println(s.toUpperCase());

        greeterWithHello.andThen(upper).accept("Susi");


        // TODO: 4 - Create a BiConsumer<String, Integer> called 'printNameAge'
        //  that prints "<name> is <age> years old."
        //  Call it with ("Bob", 25).
        BiConsumer<String, Integer> printNameAge = (s, i) -> System.out.printf("%s is %s years old.\n", s, i);
        printNameAge.accept("Bob", 25);

        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "Diana");

        // TODO: 5 - Use 'greeter' with the forEach method on the names list
        //  to greet each person.
        names.forEach(greeter);


        // TODO: 6 - Call the processAll method below, passing 'shouter'
        //  and the names list.
        processAll(shouter, names);


        Map<String, Integer> scores = new HashMap<>();

        // TODO: 7 - Create a BiConsumer<String, Integer> called 'addToMap'
        //  that puts a key-value pair into the 'scores' map.
        //  Use it to add: ("Alice", 95), ("Bob", 87), ("Charlie", 92).
        //  Print the scores map afterward.
        Consumer<String> addToMap = s -> scores.put(s, ((int)(Math.random() * 100) + 1));
        names.forEach(addToMap);

        System.out.println(scores);
    }

    /**
     * Applies the given consumer to each element in the list.
     *
     * @param consumer the consumer to apply
     * @param items    the list of items
     * @param <T>      the type of items
     */
    static <T> void processAll(Consumer<T> consumer, List<T> items) {
        for (T item : items) {
            consumer.accept(item);
        }
    }
}
