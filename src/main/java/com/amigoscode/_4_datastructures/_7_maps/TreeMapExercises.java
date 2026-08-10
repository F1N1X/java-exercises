package com.amigoscode._4_datastructures._7_maps;

// Exercise: TreeMap Operations
// Learn how to use TreeMap - a sorted map implementation that maintains keys in natural order.

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class TreeMapExercises {

    public static void main(String[] args) {

        // TODO: 1 - Create a TreeMap<String, Double> called 'productPrices'
        //           This will store product names and their prices
        TreeMap<String, Double> productPrices = new TreeMap<>();


        // TODO: 2 - Add 5 products with prices:
        //           "Laptop" -> 999.99, "Phone" -> 699.99, "Tablet" -> 449.99,
        //           "Headphones" -> 149.99, "Mouse" -> 29.99
        productPrices.put("Laptop", 999.99);
        productPrices.put("Phone", 699.99);
        productPrices.put("Tablet", 449.99);
        productPrices.put("Headphones", 149.99);
        productPrices.put("Mouse", 929.99);

        // TODO: 3 - Get and print the first key using firstKey()
        //           Get and print the last key using lastKey()
        //           Observe that they are in alphabetical order
        System.out.println(productPrices);
        System.out.println(productPrices.firstKey());
        System.out.println(productPrices.lastKey());


        // TODO: 4 - Get a submap of products from "Laptop" (inclusive) to "Phone" (exclusive)
        //           using subMap() and print it
        SortedMap<String, Double> stringDoubleSortedMap = productPrices.subMap("Laptop", "Phone");
        System.out.println(stringDoubleSortedMap);

        // TODO: 5 - Iterate over the TreeMap in natural (ascending) key order
        //           Print each product and price in format: "<product>: $<price>"
        productPrices.forEach((key, value) -> System.out.printf("%s: $%s \n", key, value));


        // TODO: 6 - Iterate in reverse order using descendingMap()
        //           Print each product and price
        productPrices.descendingMap().forEach((key, value) -> System.out.printf("%s: $%s \n", key, value));

    }
}
