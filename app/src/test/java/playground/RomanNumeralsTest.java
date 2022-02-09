package playground;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class RomanNumeralsTest {
    static Stream<Arguments> testCasesToRoman() {
        return Stream.of(
                Arguments.arguments(1, "I"),
                Arguments.arguments(2, "II"),
                Arguments.arguments(1990, "MCMXC")
        );
    }

    static Stream<Arguments> testCasesFromRoman() {
        return Stream.of(
                Arguments.arguments("I", 1),
                Arguments.arguments("II", 2),
                Arguments.arguments("MCMXC", 1990),
                Arguments.arguments("IX", 9),
                Arguments.arguments("MMMM", 4000)
        );
    }

    @ParameterizedTest
    @DisplayName("should convert to Roman Numerals")
    @MethodSource("testCasesToRoman")
    void shouldConvertToRomanNumerals(int number, String expected) {
        String result = RomanNumerals.toRoman(number);
        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @DisplayName("should convert from Roman numerals")
    @MethodSource("testCasesFromRoman")
    void shouldConvertFromRomanNumerals(String romanNumeral, int expected) {
        int result = RomanNumerals.fromRoman(romanNumeral);
        Assertions.assertEquals(expected, result);
    }
}