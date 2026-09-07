package com.amigoscode._7_streams._12_challenge;

import org.w3c.dom.ls.LSOutput;

import java.time.LocalDate;
import java.time.Month;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Exercise: Streams Challenge
 *
 * Put everything together! This challenge uses a realistic Transaction model
 * and requires you to combine multiple stream operations to answer
 * business-style questions.
 */
public class StreamsChallenge {

    record Transaction(int id, double amount, String type, LocalDate date) {}

    public static void main(String[] args) {
        List<Transaction> transactions = List.of(
                new Transaction(1, 500.00, "DEPOSIT", LocalDate.of(2024, 1, 15)),
                new Transaction(2, 200.00, "WITHDRAWAL", LocalDate.of(2024, 1, 20)),
                new Transaction(3, 1500.00, "DEPOSIT", LocalDate.of(2024, 2, 10)),
                new Transaction(4, 300.00, "WITHDRAWAL", LocalDate.of(2024, 2, 14)),
                new Transaction(5, 750.00, "TRANSFER", LocalDate.of(2024, 2, 28)),
                new Transaction(6, 200.00, "WITHDRAWAL", LocalDate.of(2024, 3, 5)),
                new Transaction(7, 1200.00, "DEPOSIT", LocalDate.of(2024, 3, 12)),
                new Transaction(8, 500.00, "TRANSFER", LocalDate.of(2024, 3, 18)),
                new Transaction(9, 100.00, "WITHDRAWAL", LocalDate.of(2024, 3, 22)),
                new Transaction(10, 2000.00, "DEPOSIT", LocalDate.of(2024, 4, 1)),
                new Transaction(11, 750.00, "TRANSFER", LocalDate.of(2024, 4, 10)),
                new Transaction(12, 300.00, "WITHDRAWAL", LocalDate.of(2024, 4, 15)),
                new Transaction(13, 1500.00, "DEPOSIT", LocalDate.of(2024, 5, 3)),
                new Transaction(14, 450.00, "TRANSFER", LocalDate.of(2024, 5, 8)),
                new Transaction(15, 100.00, "WITHDRAWAL", LocalDate.of(2024, 5, 20))
        );

        System.out.println("=== Streams Challenge ===\n");

        // TODO: 1 - Filter transactions by type: find all DEPOSIT transactions
        //           Print each deposit transaction's id and amount
        transactions.stream()
                .filter(t -> t.type().equals("DEPOSIT"))
                .forEach(t -> System.out.println("ID:\t" + t.id() + "\tamount:\t" + t.amount()));


        // TODO: 2 - Group transactions by type and sum the amounts per type
        //           Result type: Map<String, Double>
        //           Print each type and its total amount
        transactions.stream()
                .collect(Collectors.toMap(Transaction::type, Transaction::amount, Double::sum))
                .forEach((k, v) -> System.out.println("K:"+k+"\tV:"+v));

        System.out.println(transactions.stream()
                .collect(Collectors.groupingBy(
                        Transaction::type,
                        Collectors.summingDouble(Transaction::amount)
                )));


        // TODO: 3 - Find the 3 highest value transactions (by amount)
        //           Sort by amount descending, limit to 3
        //           Print each transaction's id, amount, and type
        transactions.stream()
                .sorted(Comparator.comparingDouble(Transaction::amount).reversed())
                .limit(3)
                .forEach(System.out::println);


        // TODO: 4 - Calculate the average transaction amount per type
        //           Use groupingBy with averagingDouble as downstream collector
        //           Print each type and its average
        System.out.println(transactions.stream()
                .collect(Collectors.groupingBy(
                        Transaction::type,
                        Collectors.averagingDouble(Transaction::amount))));


        // TODO: 5 - Find the month with the most transactions
        //           Group by month (use date.getMonth()), count per month,
        //           then find the entry with the max count
        //           Print the month and how many transactions it had
        System.out.println(transactions.stream()
                .collect(Collectors.groupingBy(
                        t -> t.date.getMonth(),
                        Collectors.counting()
                ))
                .entrySet().stream().max(Map.Entry.comparingByValue()));


        // TODO: 6 - Generate a summary report string in the format:
        //           "Total transactions: X | Total amount: $Y | Avg amount: $Z"
        //           Use streams to calculate each value
        //           Print the report

        long totalTransactions = transactions.stream()
                .count();

        double totalAmount = transactions.stream()
                .mapToDouble(Transaction::amount)
                .sum();

        double avgAmount = transactions.stream()
                .mapToDouble(Transaction::amount)
                .average()
                .orElse(0.0);

        String report = String.format(
                "Total transactions: %d | Total amount: $%.2f | Avg amount: $%.2f",
                totalTransactions,
                totalAmount,
                avgAmount
        );

        System.out.println(report);



        // TODO: 7 - Find duplicate amounts (amounts that appear more than once)
        //           Group by amount, count occurrences, filter entries with count > 1
        //           Print each duplicate amount and how many times it appears
        transactions.stream()
                .collect(Collectors.groupingBy(
                        Transaction::amount,
                        Collectors.counting()
                ))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .forEach(entry ->
                        System.out.println(entry.getKey() + ": " + entry.getValue())
                );


        // TODO: 8 - Sort transactions by date, then by amount (descending) for same date
        //           Collect to a list and print each transaction
        List<Transaction> sortedTransactions = transactions.stream()
                .sorted(
                        Comparator.comparing(Transaction::date)
                                .thenComparing(
                                        Comparator.comparingDouble(Transaction::amount)
                                                .reversed()
                                )
                )
                .toList();

        sortedTransactions.forEach(System.out::println);
    }
}
