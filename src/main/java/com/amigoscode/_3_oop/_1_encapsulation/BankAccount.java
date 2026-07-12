package com.amigoscode._3_oop._1_encapsulation;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Exercise: Encapsulation with BankAccount
 *
 * Learn how to protect data using private fields, provide controlled access
 * through getters, and enforce business rules in methods.
 *
 * Key concepts:
 * - Private fields to hide internal state
 * - Public methods to provide controlled access
 * - Validation logic inside setters/methods
 * - Private helper methods
 */
public class BankAccount {

    // TODO: 1 - Declare three private fields:
    //   - accountNumber (String)
    //   - balance (double)
    //   - ownerName (String)
    private String accountNumber;
    private BigDecimal balance;
    private String ownerName;


    // TODO: 2 - Create a constructor that takes accountNumber, ownerName,
    //   and an initialBalance. Validate that initialBalance >= 0,
    //   throwing IllegalArgumentException if not. Assign all fields.

    public BankAccount(String accountNumber, BigDecimal balance, String ownerName) {
        if (Objects.isNull(accountNumber)
                || Objects.isNull(balance)
                || Objects.isNull(ownerName)
                || (balance.compareTo(BigDecimal.ZERO) <= 0))
            throw new IllegalArgumentException();
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.ownerName = ownerName;
    }


    // TODO: 3 - Create a getter method for balance (getBalance).
    //   Do NOT create a setter for balance — it should only change
    //   through deposit() and withdraw().

    public BigDecimal getBalance() {
        return balance;
    }


    // TODO: 4 - Create a deposit(double amount) method.
    //   - If amount <= 0, throw IllegalArgumentException with message
    //     "Deposit amount must be positive"
    //   - Add amount to balance
    //   - Call the private logTransaction() helper with a descriptive message
    //   - Return the new balance
    public BigDecimal deposit(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0)
            throw new IllegalArgumentException("Deposit amount must be positive");
        balance = balance.add(amount);
        logTransaction();
        return balance;
    }




    // TODO: 5 - Create a withdraw(double amount) method.
    //   - If amount <= 0, throw IllegalArgumentException with message
    //     "Withdrawal amount must be positive"
    //   - If amount > balance, throw IllegalStateException with message
    //     "Insufficient funds"
    //   - Subtract amount from balance
    //   - Call the private logTransaction() helper with a descriptive message
    //   - Return the new balance
    public BigDecimal withdraw(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0)
            throw new IllegalArgumentException("Withdrawal amount must be positive");
        if (amount.compareTo(balance) > 0)
            throw new IllegalArgumentException("Insufficient funds");
        balance = balance.subtract(amount);
        logTransaction();
        return balance;
    }


    // TODO: 6 - Override toString() to return a string in the format:
    //   "BankAccount{accountNumber='XXX', ownerName='XXX', balance=XXX}"

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                ", ownerName='" + ownerName + '\'' +
                '}';
    }


    // TODO: 7 - Create a private helper method logTransaction(String message)
    //   that prints the message to the console prefixed with
    //   "[Transaction Log] ". This method should NOT be accessible
    //   from outside the class.
    private void logTransaction() {
        System.out.println("[Transaction Log]: " + balance);
    }

    public static void main(String[] args) {
        // Uncomment and test after completing the TODOs:
        BankAccount account = new BankAccount("ACC-001", BigDecimal.valueOf(1000.0), "Alice");
        System.out.println(account);
        System.out.println("Balance: " + account.getBalance());
        //
        account.deposit(BigDecimal.valueOf(500.0));
        System.out.println("After deposit: " + account.getBalance());
        //
        account.withdraw(BigDecimal.valueOf(200.0));
        System.out.println("After withdrawal: " + account.getBalance());
        //
        // // These should throw exceptions:
        //account.deposit(BigDecimal.valueOf(-200.0));
        //account.withdraw(BigDecimal.valueOf(999999));
    }
}
