package com.amigoscode._3_oop._4_polymorphism;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

/**
 * Exercise: Polymorphism - Payment Processing
 *
 * Build a payment processing system using interfaces and polymorphism.
 * Multiple payment methods implement the same interface, allowing
 * the processor to handle any payment type without knowing the details.
 *
 * Key concepts:
 * - Defining interfaces
 * - Multiple classes implementing the same interface
 * - Runtime polymorphism (method dispatch)
 * - Programming to an interface, not an implementation
 * - Default methods in interfaces
 */

// TODO: 1 - Create a Payment interface with:
//   - A method: boolean processPayment(double amount)
//   - A method: String getPaymentMethod()
//   - A default method: void printReceipt(double amount) that prints:
//     "Receipt: $<amount> paid via <getPaymentMethod()>"
//     Default methods provide a body in the interface itself.

    interface Payment {
        boolean processPayment(double amount);
        String getPaymentMethod();
        default void printReceipt(double amount) {
            System.out.println("Receipt: $"+ amount + " paid via " + getPaymentMethod());
        }
}



// TODO: 5 - Create a PaymentProcessor class with a method:
//   void processAllPayments(List<Payment> payments, double amount)
//   Iterate over the list and call processPayment(amount) on each.
//   After each payment, call printReceipt(amount).

public class PaymentProcessor {
        public void processAllPayments(List<Payment> payments, double amount) {
            for (var payment : payments) {
                payment.processPayment(amount);
                payment.printReceipt(amount);
            }
        }
}


class PaymentDemo {
    public static void main(String[] args) {
        // TODO: 6 - Create a List<Payment> containing one of each payment type:
        //   CreditCardPayment, PayPalPayment, BankTransferPayment.
        //   Then create a PaymentProcessor and call processAllPayments().
        CreditCardPayment credit = new CreditCardPayment("12312312312");
        PayPalPayment paypal = new PayPalPayment("bugi");
        BankTransferPayment bank = new BankTransferPayment("IB12312312");

        List<Payment> payments = List.of(credit, paypal, bank);
        PaymentProcessor processer = new PaymentProcessor();
        processer.processAllPayments(payments, 100);


        // TODO: 7 - Demonstrate runtime polymorphism:
        //   Create a Payment variable and assign different implementations to it.
        //   Call processPayment() each time and observe that the correct
        //   implementation runs based on the actual object type.
        //   Example:
        //     Payment payment = new CreditCardPayment("1234-5678");
        //     payment.processPayment(100.0);
        //     payment = new PayPalPayment("user@email.com");
        //     payment.processPayment(200.0);

    }
}
