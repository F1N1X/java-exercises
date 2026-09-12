package com.amigoscode._5_generics._5_boundedtypes;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Exercise: Upper Bounded Type Parameters
 *
 * This exercise demonstrates bounded type parameters using "extends".
 * When you write <T extends Number>, T can only be Number or its subclasses
 * (Integer, Double, Long, etc.). This lets you call Number methods like
 * doubleValue() on values of type T.
 *
 * Complete the TODOs below.
 */
public class UpperBound {

    // TODO: 1 - Create a static generic method: <T extends Number> double sum(List<T> list)
    //  It should return the sum of all elements as a double.
    //  Use the doubleValue() method on each element (available because T extends Number).
    static <T extends Number> double sum(List<T> list) {
     return list.stream()
                .mapToDouble(Number::doubleValue)
                .sum();
    }


    // TODO: 2 - Create a static generic method: <T extends Number> T findMax(List<T> list)
    //  It should return the largest element in the list.
    //  Compare elements using doubleValue(). If the list is empty, return null.

    static <T extends Number> T findMax(List<T> list) {
            return list.stream()
                    .max(Comparator.comparingDouble(Number::doubleValue))
                    .orElse(null);
    }


    // TODO: 3 - Create a generic class NumberBox<T extends Number> with a private T field
    //  called "number" and a constructor that takes T.
    static class NumberBox<T extends Number> {
        private T number;
        public NumberBox(T number) {
            this.number = number;
        }

        public boolean isPositive() {
            return number.doubleValue() > 0;
        }


        // TODO: 4 - In NumberBox, add an isPositive() method that returns true if the
        //  stored number's doubleValue() is greater than 0.


        // TODO: 5 - In NumberBox, add toInt() and toDouble() conversion methods that
        //  return the stored number as an int (using intValue()) and as a double
        //  (using doubleValue()) respectively.

        public int toInt() {
            return number.intValue();
        }

        public double toDouble() {
            return number.doubleValue();
        }


    }




    public static void main(String[] args) {

        // TODO: 6 - Test sum() and findMax() with Integer and Double lists

        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5);

        System.out.println("Integer sum: " + sum(integerList));
        System.out.println("Integer max: " + findMax(integerList));


        List<Double> doubleList = Arrays.asList(1.5, 2.5, 3.5);

        System.out.println("Double sum: " + sum(doubleList));
        System.out.println("Double max: " + findMax(doubleList));


        NumberBox<Integer> integerBox = new NumberBox<>(10);

        System.out.println("IntegerBox isPositive: " + integerBox.isPositive());
        System.out.println("IntegerBox toInt: " + integerBox.toInt());
        System.out.println("IntegerBox toDouble: " + integerBox.toDouble());


        NumberBox<Double> doubleBox = new NumberBox<>(12.5);

        System.out.println("DoubleBox isPositive: " + doubleBox.isPositive());
        System.out.println("DoubleBox toInt: " + doubleBox.toInt());
        System.out.println("DoubleBox toDouble: " + doubleBox.toDouble());


        // TODO: 7
        // This does not compile because String does not extend Number.
        // The sum() method only accepts List<T> where T extends Number.

        // List<String> strings = Arrays.asList("a", "b");
        // double result = sum(strings);

    }
}
