package playground;

import java.util.HashMap;
import java.util.Map;

public class IsIsogram {
    public static boolean solution(String str) {
        String[] splitted = str.toLowerCase().split("");
        Map<String, Integer> letterCounter = new HashMap<>();

        for(String letter : splitted) {
            if(!letterCounter.containsKey(letter)) {
                letterCounter.put(letter, 1);
            } else {
                int counter = letterCounter.get(letter);
                counter++;
                letterCounter.put(letter, counter);
            }
        }

        return !(letterCounter.values().stream().anyMatch(c -> c.intValue() > 1));


    }
}
