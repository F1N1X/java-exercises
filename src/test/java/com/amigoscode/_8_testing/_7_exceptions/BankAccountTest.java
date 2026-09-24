package com.amigoscode._8_testing._7_exceptions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Exercise: Testing Exceptions with BankAccount
 *
 * Practice testing both successful operations and exception scenarios
 * using AssertJ's assertThatThrownBy for fluent exception testing.
 */
@DisplayName("Bank Account Tests")
class BankAccountTest {

    private BankAccount underTest;

    @BeforeEach
    void setUp() {
        underTest = new BankAccount("ACC-001", 100.0);
    }

    // TODO: 1 - Test that deposit increases the balance.
    //  Deposit 50.0 into the account.
    //  Assert that getBalance() returns 150.0.
    //  Use assertThat(account.getBalance()).isEqualTo(150.0);

    @Test
    void depositShouldIncreaseTheBalance() {
        // given
        double depositValue = 50.0;
        // when
        underTest.deposit(depositValue);
        // then
        assertThat(underTest.getBalance()).isEqualTo(150.0);
    }


    // TODO: 2 - Test that withdraw decreases the balance.
    //  Withdraw 30.0 from the account.
    //  Assert that getBalance() returns 70.0.

    @Test
    void withdraw30From100ShouldReturn70() {
        double withdrawValue = 30.0;
        underTest.withdraw(withdrawValue);
        assertThat(underTest.getBalance()).isEqualTo(70.0);
    }


    // TODO: 3 - Test that withdrawing more than the balance throws InsufficientFundsException.
    //  Use assertThatThrownBy(() -> account.withdraw(200.0))
    //      .isInstanceOf(InsufficientFundsException.class);
    @Test
    void withdrawingShouldReturnInsufficientFundsException() {
        double given = 200.00;
        assertThatThrownBy(
                () -> underTest.withdraw(given))
                .isInstanceOf(InsufficientFundsException.class);
    }


    // TODO: 4 - Test that depositing a negative amount throws IllegalArgumentException.
    //  Use assertThatThrownBy(() -> account.deposit(-50.0))
    //      .isInstanceOf(IllegalArgumentException.class)
    //      .hasMessageContaining("positive");
    @Test
    void negativeShouldThrowIllegalArgumentException() {
        assertThatThrownBy(() -> underTest.deposit(-50.0))
       .isInstanceOf(IllegalArgumentException.class)
       .hasMessageContaining("positive");
    }


    // TODO: 5 - Test transfer between two accounts.
    //  Create a second BankAccount ("ACC-002", 50.0).
    //  Transfer 40.0 from account to the second account.
    //  Assert account balance is 60.0 and second account balance is 90.0.
    @Test
    void testTransferBetweenTwoAccounts() {
        BankAccount otherAccount = new BankAccount("ACC-002", 50.0);
        underTest.transfer(otherAccount, 40.0);
        assertThat(otherAccount.getBalance()).isEqualTo(90.0);
    }


    // TODO: 6 - Verify exception message content for insufficient funds.
    //  Use assertThatThrownBy(() -> account.withdraw(500.0))
    //      .hasMessageContaining("Insufficient funds")
    //      .hasMessageContaining("500");
    @Test
    void checkThatWhenExceptionDrawContainsTheValue() {
        assertThatThrownBy(() -> underTest.withdraw(500.00))
                .hasMessageContaining("Insufficient funds")
                .hasMessageContaining("500");
    }


    // TODO: 7 - Verify exception type for multiple error scenarios.
    //  Test that withdraw(0) throws IllegalArgumentException.
    //  Test that withdraw(-10) throws IllegalArgumentException.
    //  Test that deposit(0) throws IllegalArgumentException.
    //  Test that transfer to null account throws IllegalArgumentException.

    @Test
    void testInvalidTransactions() {
        BankAccount account = new BankAccount("abc",123.00);

        assertThrows(IllegalArgumentException.class, () -> account.withdraw(0));
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(-10));
        assertThrows(IllegalArgumentException.class, () -> account.deposit(0));
        assertThrows(IllegalArgumentException.class, () -> account.transfer(null, 10));
    }

}
