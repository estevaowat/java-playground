package playground;

import java.util.ArrayList;
import java.util.List;

public class StringSplit {

    public static String[] solution(String characters) {
        var split = characters.split("");
        List<String> pairs = new ArrayList<>();

        for(int i = 0; i < split.length; i += 2) {
            String character = split[i];
            String nextCharacter = i == split.length - 1 ? "_" : split[i + 1];

            String result = character + nextCharacter;
            pairs.add(result);
        }

        return pairs.toArray(new String[0]);
    }
}
