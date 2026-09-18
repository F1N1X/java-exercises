package com.amigoscode._8_testing._1_firsttest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Exercise: Your First Unit Tests
 *
 * In this exercise you will write your first JUnit 5 tests for the Calculator class.
 * Complete each TODO to practice basic assertions and test lifecycle annotations.
 */
class CalculatorTest {

    private Calculator underTest;

    @BeforeEach
    void setUp() {
        underTest = new Calculator();
    }


    @ParameterizedTest
    @CsvSource({
            "1,2,3",
            "4,5,9",
            "10, 11, 21",
    })
    void add(int a, int b, int expected) {
        int add = underTest.add(a, b);
        assertThat(add).isEqualTo(expected);
    }

    @DisplayName("3 - 2 should equals 1")
    @Test
    void subtract3And2ResultShould1() {
        //given
        int a = 3;
        int b = 2;
        //when
        int actual = underTest.subtract(a, b);
        //then
        assertThat(actual).isEqualTo(1);
    }

    @DisplayName("3 * 3 should equals 9")
    @Test
    void multiply() {
        int a = 3;
        int b = 3;

        int actual = underTest.multiply(a, b);
        assertThat(actual).isEqualTo(9);
    }

    @DisplayName("15 divide by 3 should 5")
    @Test
    void divide() {
        int a = 15;
        int b = 3;
        int actual = underTest.divide(a, b);
        assertThat(actual).isEqualTo(5);
    }

    // TODO: 1 - Declare a Calculator field and use @BeforeEach to create a fresh
    //  Calculator instance before each test. This ensures tests are independent.
    //  Hint: Write a setUp() method annotated with @BeforeEach that assigns
    //  a new Calculator() to your field.


    // TODO: 2 - Write a test for the add method using assertEquals.
    //  Annotate it with @Test and @DisplayName("2 + 3 should equal 5").
    //  Call calculator.add(2, 3) and assert the result equals 5.


    // TODO: 3 - Write a test for the subtract method.
    //  Annotate with @Test and @DisplayName.
    //  Test that calculator.subtract(10, 4) equals 6.


    // TODO: 4 - Write a test for the multiply method.
    //  Annotate with @Test and @DisplayName.
    //  Test that calculator.multiply(3, 7) equals 21.


    // TODO: 5 - Write a test that verifies dividing by zero throws ArithmeticException.
    //  Use assertThrows(ArithmeticException.class, () -> calculator.divide(10, 0)).
    //  Add a @DisplayName annotation.


    // TODO: 6 - Write a test using assertNotEquals.
    //  Verify that calculator.add(2, 2) is NOT equal to 5.
    //  Add a @DisplayName annotation.


    // TODO: 7 - Add @DisplayName annotations to ALL of your tests above (if not done already).
    //  Make the display names descriptive, e.g., "Adding 2 and 3 should return 5".
    //  Then write one more test: verify that calculator.divide(10, 2) equals 5.

}
