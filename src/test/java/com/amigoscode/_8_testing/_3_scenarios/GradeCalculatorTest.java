package com.amigoscode._8_testing._3_scenarios;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Exercise: Testing Multiple Scenarios
 *
 * Practice testing a class with many different input/output combinations.
 * Focus on testing normal cases, boundary values, and error conditions.
 */
@DisplayName("Grade Calculator Tests")
class GradeCalculatorTest {

    private GradeCalculator underTest;

    @BeforeEach
    void setUp() {
        underTest = new GradeCalculator();
    }

    // TODO: 1 - Test that a score of 95 returns grade "A".
    //  Use assertEquals to verify gradeCalculator.calculateGrade(95) returns "A".
    @DisplayName("should return A for Score 95")
    @Test
    void shouldReturnAForScore90() {
        int given = 95;
        String expected = "A";
        String actual = underTest.calculateGrade(given);
        assertThat(actual).isEqualTo(expected);
    }


    // TODO: 2 - Test that a score of 85 returns grade "B".
    //  Use assertEquals to verify gradeCalculator.calculateGrade(85) returns "B".
    @DisplayName("should return B for score 85")
    @Test
    void shouldReturnBForScore85() {
        int given = 85;
        String expected = "B";
        String actual = underTest.calculateGrade(given);
        assertThat(actual).isEqualTo(expected);
    }


    // TODO: 3 - Test that a score of 75 returns grade "C".
    //  Use assertEquals to verify gradeCalculator.calculateGrade(75) returns "C".
    @DisplayName("should return C for score 75")
    @Test
    void shouldReturnCForScore75() {
        int given = 75;
        String expected = "C";
        String actual = underTest.calculateGrade(given);
        assertThat(actual).isEqualTo(expected);
    }


    // TODO: 4 - Test that a score of 65 returns grade "D".
    //  Use assertEquals to verify gradeCalculator.calculateGrade(65) returns "D".
    @DisplayName("should return D for score 65")
    @Test
    void shouldReturnDForScore65() {
        int given = 65;
        String expected = "D";
        String actual = underTest.calculateGrade(given);
        assertThat(actual).isEqualTo(expected);
    }


    // TODO: 5 - Test that a score of 50 returns grade "F".
    //  Use assertEquals to verify gradeCalculator.calculateGrade(50) returns "F".
    @DisplayName("should return F for score 50")
    @Test
    void shouldReturnForScore50F() {
        int given = 50;
        String expected = "F";
        String actual = underTest.calculateGrade(given);
        assertThat(actual).isEqualTo(expected);
    }


    // TODO: 6 - Test boundary values using assertAll.
    //  Test the exact boundary scores where grades change:
    //  Score 90 -> "A", Score 89 -> "B"
    //  Score 80 -> "B", Score 79 -> "C"
    //  Score 70 -> "C", Score 69 -> "D"
    //  Score 60 -> "D", Score 59 -> "F"
    //  Group all assertions in a single assertAll block.
    @DisplayName("check boundary scores")
    @Test
    void checkBoundaryScoresOfAllScopesFromAtoF() {
        assertAll(
                () -> assertEquals("A", underTest.calculateGrade(90)),
                () -> assertEquals("B", underTest.calculateGrade(89)),
                () -> assertEquals("B", underTest.calculateGrade(80)),
                () -> assertEquals("C", underTest.calculateGrade(79)),
                () -> assertEquals("C", underTest.calculateGrade(70)),
                () -> assertEquals("D", underTest.calculateGrade(69)),
                () -> assertEquals("D", underTest.calculateGrade(60)),
                () -> assertEquals("F", underTest.calculateGrade(59))
        );
    }


    // TODO: 7 - Test that a negative score throws IllegalArgumentException.
    //  Use assertThrows to verify calculateGrade(-1) throws IllegalArgumentException.
    //  Optionally verify the exception message mentions the negative score.
    @DisplayName("should throw for negative values IllegalArgumentException")
    @Test
    void shouldThrowIllegalArgumentExceptionForNegativeNumbers() {
        assertThrows(IllegalArgumentException.class, () -> underTest.calculateGrade(-1));
    }


    // TODO: 8 - Test that a score greater than 100 throws IllegalArgumentException.
    //  Use assertThrows to verify calculateGrade(101) throws IllegalArgumentException.
    //  Also test calculateGrade(150) to be thorough.
    @DisplayName("should throw for scores above 100 an IllegalArgumentException")
    @Test
    void shouldThrowIllegalArgumentExceptionForNumbersAbove100() {
        assertThrows(IllegalArgumentException.class, () -> underTest.calculateGrade(101));
    }


}
