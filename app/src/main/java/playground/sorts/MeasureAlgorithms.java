package playground.sorts;

import java.time.Duration;
import java.time.Instant;

public class MeasureAlgorithms {

  public static void main(String[] args) {
    try {
      final int size = 100000;

      int[] numbers = RandomNumbers.createArrayWithRandomNumbers(size);
      int[] quickNumbers = numbers.clone();
      int[] mergeNumbers = numbers.clone();
      System.out.println("Measuring Bubble Sort");
      BubbleSort bubbleSort = new BubbleSort();
      measureSortAlgorithm(bubbleSort, numbers);

      System.out.println("Measuring Quick sort");
      QuickSort quickSort = new QuickSort();
      measureSortAlgorithm(quickSort, quickNumbers);

      System.out.println("Measuring Merge Sort");
      MergeSort mergeSort = new MergeSort();
      measureSortAlgorithm(mergeSort, mergeNumbers);

    } catch (Exception ex) {
      System.out.println(ex.getCause());
      System.out.println(ex.getMessage());
    }
  }

  private static void measureSortAlgorithm(ISort algorithm, int[] numbers) {
    Instant startInstant = Instant.now();

    int[] sortedNumbers = algorithm.sort(numbers);
    Instant endInstant = Instant.now();

    System.out.println();
    System.out.println(
        "TIME ELAPSED IN NANOSECONDS: " + Duration.between(startInstant, endInstant).toNanos());
    System.out.println(
        "TIME ELAPSED IN MILLISECONDS: " + Duration.between(startInstant, endInstant).toMillis());
    System.out.println(
        "TIME ELAPSED IN SECONDS: " + Duration.between(startInstant, endInstant).toSeconds());
    System.out.println();
  }
}
