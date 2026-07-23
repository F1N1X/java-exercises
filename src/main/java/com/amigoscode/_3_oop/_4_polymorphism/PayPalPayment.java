package com.amigoscode._3_oop._4_polymorphism;

public class PayPalPayment implements Payment {
        private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public boolean processPayment(double amount) {
        if (amount <= 0)
            return false;
        System.out.printf("Processing PayPal payment of $%s from %s%n",amount, email);
        return true;
    }

    @Override
    public String getPaymentMethod() {
        return "PayPal";
    }
}
