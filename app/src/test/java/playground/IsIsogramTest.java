package playground;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class IsIsogramTest {

    static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.arguments(true, "Dermatoglyphics"),
                Arguments.arguments(true, "isogram"),
                Arguments.arguments(false, "moose"),
                Arguments.arguments(false, "isIsogram"),
                Arguments.arguments(false, "aba"),
                Arguments.arguments(false, "moOse"),
                Arguments.arguments(true, "thumbscrewjapingly"),
                Arguments.arguments(true, ""));
    }


    @ParameterizedTest
    @MethodSource("testCases")
    @DisplayName("should test if a word is isogram or not")
    void shouldTestIsIsogram(boolean expected, String characters) {
        boolean result = IsIsogram.solution(characters);
        Assertions.assertEquals(expected, result);
    }
}
