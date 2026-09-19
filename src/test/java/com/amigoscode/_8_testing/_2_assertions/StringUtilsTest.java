package com.amigoscode._8_testing._2_assertions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Exercise: JUnit 5 Assertions
 *
 * Practice using different JUnit 5 assertion methods to test the StringUtils class.
 * Each TODO requires a different assertion type.
 */
@DisplayName("StringUtils Tests")
class StringUtilsTest {

    private StringUtils underTest;

    @BeforeEach
    void setUp() {
        underTest = new StringUtils();
    }

    // TODO: 1 - Test isPalindrome using assertTrue and assertFalse.
    //  Assert that "racecar" is a palindrome (assertTrue).
    //  Assert that "hello" is NOT a palindrome (assertFalse).
    //  Assert that "A man a plan a canal Panama" is a palindrome (assertTrue).
    @DisplayName("testing multiple values for palindrome")
    @ParameterizedTest
    @CsvSource({
        "racecar, true",
        "hello, false",
        "A man a plan a canal Panama, true"
    })
    void checkPalindromeWithParameterizedTest(String value, boolean expected) {
        boolean actual = underTest.isPalindrome(value);
        assertThat(actual).isEqualTo(expected);
    }



    // TODO: 2 - Test reverse using assertEquals.
    //  Assert that reversing "hello" returns "olleh".
    //  Assert that reversing "Java" returns "avaJ".
    //  Assert that reversing "" (empty string) returns "".
    @DisplayName("reversing multiple strings test")
    @ParameterizedTest
    @CsvSource({
            "hello,olleh",
            "Java,avaJ",
            ","
    })
    void reversingMultipleString(String value, String expected) {
        if (value == null) {
            value = "";
            expected = "";
        }

        String actual = underTest.reverse(value);
        assertThat(actual).isEqualTo(expected);
    }


    // TODO: 3 - Test capitalize using assertEquals.
    //  Assert that capitalizing "hello" returns "Hello".
    //  Assert that capitalizing "java" returns "Java".
    //  Assert that capitalizing "" (empty string) returns "".
    @DisplayName("testing capitalize multiple strings")
    @ParameterizedTest
    @CsvSource({
            "hello,Hello",
            "java,Java",
            ","
    })
    void capitalizingMultipleStrings(String input, String expected) {
        if (input == null) {
            input = "";
            expected = "";
        }
        String actual = underTest.capitalize(input);
        assertThat(actual).isEqualTo(expected);
    }


    // TODO: 4 - Test isEmpty with various inputs including a null check.
    //  Assert that isEmpty(null) returns true (assertTrue).
    //  Assert that isEmpty("") returns true.
    //  Assert that isEmpty("   ") returns true (whitespace only).
    //  Assert that isEmpty("hello") returns false (assertFalse).
    @DisplayName("testing is empty check for multiple strings")
    @ParameterizedTest
    @CsvSource({
            ",true",
            "    ,true",
            "hello, false"
    })
    void checkIsEmptyWithMultipleValues(String input, boolean expected) {
        if (input == null)
            input = "";
        boolean actual = underTest.isEmpty(input);
        assertThat(actual).isEqualTo(expected);
    }


    // TODO: 5 - Test countVowels using assertEquals.
    //  Assert that countVowels("hello") returns 2.
    //  Assert that countVowels("AEIOU") returns 5.
    //  Assert that countVowels("xyz") returns 0.
    @DisplayName("should count vowels for multipleInputs")
    @ParameterizedTest
    @CsvSource({
            "hello,2",
            "AEIOU,5",
            "xyz,0"
    })
    void shouldCountVowelsForMultipleInputs(String input, int expected) {
        int actual = underTest.countVowels(input);
        assertThat(actual).isEqualTo(expected);
    }


    // TODO: 6 - Use assertAll to group multiple related assertions together.
    //  Group at least 3 assertions about the reverse method into a single assertAll call.
    //  Example: assertAll(
    //      () -> assertEquals("olleh", stringUtils.reverse("hello")),
    //      () -> assertEquals("avaJ", stringUtils.reverse("Java")),
    //      () -> assertEquals("", stringUtils.reverse(""))
    //  );
    @DisplayName("test assertAll with multiple inputs")
    @Test
    void shouldReverseMultipleString() {
        assertAll(
                () -> assertEquals("olleh", underTest.reverse("hello")),
                () -> assertEquals("avaJ", underTest.reverse("Java")),
                () -> assertEquals("", underTest.reverse(""))
                 );
    }

    // TODO: 7 - Test that passing null input to methods throws IllegalArgumentException.
    //  Use assertThrows to verify that isPalindrome(null) throws IllegalArgumentException.
    //  Use assertThrows to verify that reverse(null) throws IllegalArgumentException.
    //  Use assertThrows to verify that countVowels(null) throws IllegalArgumentException.
    @DisplayName("test methods that all throw IllegalArgumentException")
    @Test
    void shouldThrowIllegalArgumentExceptionForNullInput() {

        assertThrows(
                IllegalArgumentException.class,
                () -> underTest.isPalindrome(null)
        );

        assertThrows(
                IllegalArgumentException.class,
                () -> underTest.reverse(null)
        );

        assertThrows(
                IllegalArgumentException.class,
                () -> underTest.countVowels(null)
        );
    }

}
