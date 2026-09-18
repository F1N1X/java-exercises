package com.amigoscode._8_testing._2_assertions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Exercise: Testing Exceptions with assertThrows
 *
 * Practice verifying that code throws the expected exceptions.
 * Learn to check exception types, messages, and the assertDoesNotThrow assertion.
 */
@DisplayName("Exception Assertion Tests")
class AssertThrowsTest {

    // TODO: 1 - Test that Integer.parseInt("abc") throws NumberFormatException.
    //  Use assertThrows(NumberFormatException.class, () -> Integer.parseInt("abc")).
    //  Store the returned exception in a variable.
    @DisplayName("Try Parse abc to Integer.parseInt should throw exception")
    @Test
    void parseLiteralToIntThrowingException() {
        String given = "abc";
        assertThrows(NumberFormatException.class, () -> Integer.parseInt(given));
    }


    // TODO: 2 - Verify the exception message contains expected text.
    //  Using the exception from TODO 1, call getMessage() on it.
    //  Use assertTrue to check the message contains "abc".
    //  Hint: exception.getMessage().contains("abc")
    @DisplayName("When parse abc to Intager.parseInt should contain message abc")
    @Test
    void whenTryConvertLiteralToIntShouldContainStringInErrorMessage() {
        String given = "abc";
        assertThrows(NumberFormatException.class, () -> Integer.parseInt(given))
                .getMessage()
                .contains(given);
    }


    // TODO: 3 - Test that dividing by zero throws ArithmeticException.
    //  Use assertThrows to verify that the expression (1 / 0) throws ArithmeticException.
    //  Hint: assertThrows(ArithmeticException.class, () -> { int result = 1 / 0; });
    @DisplayName("Dividing 10 / 0 should throw Arithmetic Exception")
    @Test
    void shouldThrowArithmeticExceptionWhen10DividingByZero() {
        int a = 10;
        int b = 0;
        assertThrows(ArithmeticException.class, () -> Integer.divideUnsigned(a,b));
    }



    // TODO: 4 - Test that a custom exception is thrown.
    //  Create a lambda that throws new IllegalStateException("Invalid state").
    //  Use assertThrows to catch it and verify the message equals "Invalid state".
    //  Hint: assertThrows(IllegalStateException.class, () -> {
    //      throw new IllegalStateException("Invalid state");
    //  });
    @DisplayName("should throw invalid state exception")
    @Test
    void shouldThrowIllegalStateException() {
        // Given / When
        IllegalStateException exception = assertThrows(
                IllegalStateException.class,
                () -> {
                    throw new IllegalStateException("Invalid state");
                }
        );
        // Then
        assertEquals("Invalid state", exception.getMessage());
    }



    // TODO: 5 - Use assertDoesNotThrow to verify valid input does NOT throw.
    //  Wrap Integer.parseInt("123") in assertDoesNotThrow.
    //  Wrap Integer.parseInt("0") in assertDoesNotThrow.
    //  Hint: assertDoesNotThrow(() -> Integer.parseInt("123"));
    @DisplayName("should not throw exception when cast 123 as Strint to Integer")
    @Test
    void shouldNotThrowExceptionWhenCastNumberStringToInteger() {
        String given = "123";
        assertDoesNotThrow(() -> Integer.parseInt(given));
    }


    // TODO: 6 - Test exception type hierarchy.
    //  NumberFormatException extends IllegalArgumentException.
    //  Verify that Integer.parseInt("abc") can be caught as IllegalArgumentException.
    //  Also verify it can be caught as RuntimeException.
    //  Use assertThrows for each check.
    @Test
    void testExceptionTypeHierarchy() {
        assertThrows(
                IllegalArgumentException.class,
                () -> Integer.parseInt("abc")
        );

        assertThrows(
                RuntimeException.class,
                () -> Integer.parseInt("abc")
        );
    }

}
