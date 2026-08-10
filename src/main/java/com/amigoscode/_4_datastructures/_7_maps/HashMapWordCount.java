package com.amigoscode._4_datastructures._7_maps;

// Exercise: Word Frequency Counter using HashMap
// A practical exercise to count word occurrences in a sentence.

import java.util.*;

public class HashMapWordCount {

    public static void main(String[] args) {

        String sentence = "the cat sat on the mat and the cat ate the rat on the mat";

        // TODO: 1 - Split the sentence into an array of words using split(" ")
        String[] sentenceSplit = sentence.split(" ");


        // TODO: 2 - Create a HashMap<String, Integer> called 'wordCount'
        //           Iterate through the words array and count the frequency of each word
        //           Hint: use getOrDefault(word, 0) + 1 to increment the count
        HashMap<String, Integer> wordCount = new HashMap<>();
        for (String letter : sentenceSplit)
            wordCount.put(letter,
                    (wordCount.getOrDefault(letter, 0) + 1));


        // TODO: 3 - Print each word and its count by iterating over the map
        //           Format: "<word>: <count>"
        for (var key : wordCount.keySet())
            System.out.printf("%s : %s \n", key, wordCount.get(key));


        // TODO: 4 - Find and print the most frequent word
        //           Iterate through the entrySet and track the entry with the highest value

        Map.Entry<String, Integer> max = null;
        for (var key : wordCount.entrySet())
            if (max == null || max.getValue() < key.getValue())
                max = key;

        System.out.println(wordCount);
        System.out.println(max);


        // TODO: 5 - Find and print all words that appear only once
        //           Iterate through the entrySet and collect entries where value == 1
        for (var key : wordCount.entrySet())
            if (key.getValue() == 0)
                System.out.println(key);


        // TODO: 6 - Sort the map entries by value (frequency) in descending order and print
        //           Hint: create a List from entrySet(), then sort using a Comparator
        //           that compares entry values in reverse order

        TreeMap<String, Integer> sortedMap = new TreeMap<>(wordCount);
        System.out.println(sortedMap);

        List<Map.Entry<String, Integer>> entries = new ArrayList<>(wordCount.entrySet());

        entries.sort(
                Comparator.comparing(Map.Entry<String, Integer>::getValue).reversed()
        );

        System.out.println(entries);
    }
}
