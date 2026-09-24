package com.amigoscode._8_testing._6_parameterized;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Exercise: Parameterized Tests
 *
 * Practice using JUnit 5 parameterized tests to test the EmailValidator
 * with multiple sets of input data.
 */
@DisplayName("Email Validator Parameterized Tests")
class EmailValidatorTest {

    private EmailValidator underTest;

    @BeforeEach
    void setUp() {
        underTest = new EmailValidator();
    }

    // TODO: 1 - Use @ParameterizedTest with @ValueSource for valid emails.
    //  Create a parameterized test that receives a String parameter.
    //  Annotate with @ValueSource(strings = {"user@example.com", "test@domain.org",
    //      "name.surname@company.co.uk", "user123@test.com"}).
    //  Assert that emailValidator.isValid(email) returns true for each.
    @DisplayName("test multiple emails for validation in EmailValidator")
    @ParameterizedTest
    @ValueSource(
            strings = {"user@example.com", "second@domain.com", "name.sor@company.com", "boiler@plate.com"}
    )
    void name(String email) {
        assertThat(underTest.isValid(email)).isTrue();
    }
    // TODO: 2 - Use @ParameterizedTest with @ValueSource for invalid emails.
    //  Test invalid email formats: "plaintext", "@missing-local.com",
    //      "missing-domain@", "missing@dot", "user@@double.com".
    //  Assert that emailValidator.isValid(email) returns false for each.
    @DisplayName("testing invalid email formats")
    @ParameterizedTest
    @ValueSource(
            strings = {"plaintext", "@missing-local.com",
            "missing-domain@", "missing@dot", "user@@double.com"}
    )
    void invalidEmailFormat(String test) {
        assertThat(underTest.isValid(test)).isFalse();
    }


    // TODO: 3 - Use @NullAndEmptySource to test null and empty inputs.
    //  Create a parameterized test annotated with @ParameterizedTest
    //  and @NullAndEmptySource.
    //  Assert that emailValidator.isValid(email) returns false for null and empty strings.
    //  Hint: You can combine @NullAndEmptySource with @ValueSource by also adding
    //  @ValueSource(strings = {"  ", "\t", "\n"}) to test whitespace-only strings.

    @DisplayName("check emails for null, empty and blank values")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"  ", "\t", "\n"})
    void checkEmails(String email) {
        assertThat(underTest.isValid(email)).isFalse();
    }


    // TODO: 4 - Use @CsvSource with email and expected result pairs.
    //  Annotate with @CsvSource({
    //      "user@example.com, true",
    //      "invalid-email, false",
    //      "test@domain.org, true",
    //      "@no-local.com, false",
    //      "no-domain@, false"
    //  }).
    //  The test method should take (String email, boolean expected) parameters.
    //  Assert that emailValidator.isValid(email) equals expected.


    @DisplayName("check multiple inputs for validation correct")
    @ParameterizedTest
    @CsvSource({
            "user@example.com, true",
            "invalid-email, false",
            "test@domain.org, true",
            "@no-local.com, false",
            "no-domain@, false"
    })
    void checkMultipleMailsForValidation(String value, boolean expected) {
            assertThat(underTest.isValid(value)).isEqualTo(expected);
    }


    // TODO: 5 - Use @MethodSource to provide test arguments from a static method.
    //  Create a static method named emailProvider() that returns Stream<Arguments>.
    //  Use Arguments.of("email", expectedBoolean) to provide test cases.
    //  Include at least 4 different test cases.
    //  Hint:
    //  static Stream<Arguments> emailProvider() {
    //      return Stream.of(
    //          Arguments.of("valid@test.com", true),
    //          Arguments.of("invalid", false),
    //          ...
    //      );
    //  }
    @DisplayName("test emails for validation with stream of arguments and method source")
    @ParameterizedTest
    @MethodSource("emailProvider")
    void shouldValidateEmails(String email, boolean expected) {
        boolean actual = underTest.isValid(email);
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> emailProvider() {
        return Stream.of(
                Arguments.of("valid@email.com", true),
                Arguments.of("vaasda.com", false),
                Arguments.of("@email.com", false),
                Arguments.of("valid@email", false)

        );
    }


    // TODO: 6 - Use @EnumSource to test with enum values (if applicable).
    //  Create a simple enum inside this test class:
    //  enum EmailDomain { GMAIL("gmail.com"), YAHOO("yahoo.com"), OUTLOOK("outlook.com");
    //      final String domain; EmailDomain(String d) { this.domain = d; }
    //  }
    //  Write a parameterized test with @EnumSource(EmailDomain.class).
    //  For each domain, construct "test@" + domain.domain and assert it's valid.
    @ParameterizedTest
    @EnumSource(EmailDomain.class)
    void testWithEnum(EmailDomain domain) {
        assertThat(underTest.isValid("test@"+domain.domain)).isTrue();
    }

}
