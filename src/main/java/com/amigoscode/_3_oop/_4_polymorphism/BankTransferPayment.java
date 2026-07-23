package com.amigoscode._3_oop._4_polymorphism;

public class BankTransferPayment implements Payment {

    private String bankAccountId;

    public BankTransferPayment(String bankAccountId) {
        this.bankAccountId = bankAccountId;
    }

    @Override
    public boolean processPayment(double amount) {
        if (amount <= 0)
            return false;
        System.out.printf("Processing bank transfer of $%s from account %s", amount, bankAccountId);
        return true;
    }

    @Override
    public String getPaymentMethod() {
        return "Bank Transfer";
    }
}
