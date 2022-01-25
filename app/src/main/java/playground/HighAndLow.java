package playground;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class HighAndLow {

    public static String highAndLow(String numbers) {
        List<Integer> numbersList = Arrays.stream(numbers.split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        if(numbersList.isEmpty()) {
            throw new IllegalArgumentException("numbers parameter is invalid");
        }

        Integer maxNumber = numbersList.stream().reduce(Integer::max).orElse(0);
        Integer minNumber = numbersList.stream().reduce(Integer::min).orElse(0);

        String maxNumberStringified = maxNumber.toString();
        String minNumberStringified = minNumber.toString();

        return String.format("%s %s", maxNumberStringified, minNumberStringified);
    }

    
}
