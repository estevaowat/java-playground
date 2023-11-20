package playground;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import playground.exercises.HighAndLow;

import java.util.stream.Stream;

class HighAndLowTest {
  static Stream<Arguments> testCases() {
    return Stream.of(
        Arguments.arguments("1 2 3 4 5", "5 1"),
        Arguments.arguments("1 2 -3 4 5", "5 -3"),
        Arguments.arguments("1 9 3 4 -5", "9 -5"),
        Arguments.arguments("8 3 -5 42 -1 0 0 -9 4 7 4 -4", "42 -9"));
  }

  @ParameterizedTest
  @DisplayName("should return high and low")
  @MethodSource("testCases")
  void shouldReturnHighAndLow(String numbers, String expected) {
    String result = HighAndLow.highAndLow(numbers);
    Assertions.assertEquals(expected, result);
  }
}
