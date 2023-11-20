package playground.exercises;

import java.util.HashMap;
import java.util.Map;

public class IsIsogram {

  private IsIsogram() {
    // This is an empty constructor to make sonar lint shut up
  }

  public static boolean solution(String str) {
    String[] splitted = str.toLowerCase().split("");
    Map<String, Integer> letterCounter = new HashMap<>();

    for (String letter : splitted) {
      if (!letterCounter.containsKey(letter)) {
        letterCounter.put(letter, 1);
      } else {
        int counter = letterCounter.get(letter);
        counter++;
        letterCounter.put(letter, counter);
      }
    }
    boolean hasRepeatedLetters = letterCounter.values().stream().anyMatch(c -> c > 1);

    final var n = 14;
    Double a = Math.log(n) / Math.log(5);
    int value = a.intValue();

    return !hasRepeatedLetters;
  }
}
