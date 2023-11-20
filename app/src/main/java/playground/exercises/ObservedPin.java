package playground.exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ObservedPin {

  public static List<String> getPINs(String observed) {
    String[] characters = observed.split("");

    List<String> combinations = new ArrayList<>();
    combinations.add("");

    String[][] matrix = createMatrix();
    for (String character : characters) {
      combinations = merge(combinations, getAdjacentsPin(character, matrix));
    }

    return combinations.stream().distinct().collect(Collectors.toList()); // create a mutable list
  }

  private static List<String> merge(
          List<String> previousDigitsCombinations, List<String> currentDigitsCombinations) {
    List<String> newCombinations = new ArrayList<>();
    for (String prev : previousDigitsCombinations) {
      for (String current : currentDigitsCombinations) {
        newCombinations.add(prev + current);
      }
    }

    return newCombinations.stream().distinct().toList();
  }

  private static List<String> getAdjacentsPin(String input, String[][] matrix) {
    String indexes = getIndexMatrix(input, matrix);
    String[] values = indexes.split(",");

    int row = Integer.parseInt(values[0]);
    int column = Integer.parseInt(values[1]);

    List<String> adjacents = new ArrayList<>();
    adjacents.add(input);

    adjacents.add(column - 1 > -1 ? matrix[row][column - 1] : null);
    adjacents.add(column + 1 < 3 ? matrix[row][column + 1] : null);
    adjacents.add(row - 1 > -1 ? matrix[row - 1][column] : null);
    adjacents.add(row + 1 < 4 ? matrix[row + 1][column] : null);

    return adjacents.stream().filter(Objects::nonNull).toList();
  }

  private static String getIndexMatrix(String input, String[][] matrix) {

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        if (input.equals(matrix[i][j])) {
          return i + "," + j;
        }
      }
    }

    return "notfound";
  }

  private static String[][] createMatrix() {
    String[][] matrix = new String[4][3];

    matrix[0][0] = "1";
    matrix[0][1] = "2";
    matrix[0][2] = "3";

    matrix[1][0] = "4";
    matrix[1][1] = "5";
    matrix[1][2] = "6";

    matrix[2][0] = "7";
    matrix[2][1] = "8";
    matrix[2][2] = "9";

    matrix[3][0] = null;
    matrix[3][1] = "0";
    matrix[3][2] = null;

    return matrix;
  }
}
