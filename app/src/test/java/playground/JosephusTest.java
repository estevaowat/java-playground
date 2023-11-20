package playground;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import playground.exercises.Josephus;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class JosephusTest {
    static Stream<Arguments> testCases() {
        List<Integer> items1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> expected1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> items2 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> expected2 = Arrays.asList(2, 4, 6, 8, 10, 3, 7, 1, 9, 5);

        List<String> items3 = Arrays.asList("C", "o", "d", "e", "W", "a", "r", "s");
        List<String> expected3 = Arrays.asList("e", "s", "W", "o", "C", "d", "r", "a");

        return Stream.of(
                Arguments.arguments(items1, 1, expected1),
                Arguments.arguments(items2, 2, expected2),
                Arguments.arguments(items3, 4, expected3)
        );
    }

    @ParameterizedTest
    @DisplayName("should return the joseph permutations given the list of soldiers and counter")
    @MethodSource("testCases")
    void name(List<Object> items, int quantity, List<Object> expected) {
        var result = Josephus.solution(items, quantity);
        Assertions.assertEquals(expected, result);
    }
}

