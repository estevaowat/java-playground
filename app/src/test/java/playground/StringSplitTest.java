package playground;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import playground.exercises.StringSplit;

import java.util.stream.Stream;

class StringSplitTest {

    static Stream<Arguments> testCases() {
        String[] expected1 = new String[]{
                "ab", "cd", "e_"
        };

        String[] expected2 = new String[]{
                "Lo", "ve", "Pi", "zz", "a_"
        };

        String[] expected3 = new String[]{
                "ab", "cd", "ef"
        };
        String[] expected4 = new String[]{
                "He", "ll", "oW", "or", "ld"
        };

        return Stream.of(
                Arguments.arguments("abcde", expected1),
                Arguments.arguments("LovePizza", expected2),
                Arguments.arguments("abcdef", expected3),
                Arguments.arguments("HelloWorld", expected4)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    @DisplayName("should create a array with pairs of characters")
    void shouldCreateOddArray(String characters, String[] expected) {
        String[] result = StringSplit.solution(characters);
        Assertions.assertArrayEquals(expected, result);
    }
    
}