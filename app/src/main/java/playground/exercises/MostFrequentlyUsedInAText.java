package playground.exercises;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class MostFrequentlyUsedInAText {

    public static List<String> top3(String text) {
        String firstCharacterToBeAlphabeticalRegex = "[^a-z*|']";

        List<String> textSplitted = Arrays.asList(text.toLowerCase().split(firstCharacterToBeAlphabeticalRegex));

        return textSplitted.stream()
                .filter(word -> !word.isEmpty() && !word.replace("'", "").isEmpty())
                .collect(groupingBy(Function.identity(), Collectors.counting())).entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .limit(3)
                .map(Map.Entry::getKey)
                .toList();
    }
}
