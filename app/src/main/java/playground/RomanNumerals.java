package playground;

import java.util.HashMap;

public class RomanNumerals {


    public static String toRoman(int n) {
        
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanLiterals = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder roman = new StringBuilder();

        for(int i = 0; i < values.length; i++) {
            while(n >= values[i]) {
                n -= values[i];
                roman.append(romanLiterals[i]);
            }
        }
        return roman.toString();
    }

    public static int fromRoman(String romanNumeral) {
        if(romanNumeral.isEmpty()) {
            return 0;
        }

        String[] romanNumeralSplit = romanNumeral.split("");

        int result = 0;

        HashMap<String, Integer> romanNumbersCatalog = getRomanNumbersCatalog();
        for(int i = 0; i < romanNumeralSplit.length; i++) {
            String currentLetter = romanNumeralSplit[i];

            if(i > 0 && romanNumbersCatalog.get(currentLetter) > romanNumbersCatalog.get(romanNumeralSplit[i - 1])) {

                result += romanNumbersCatalog.get(currentLetter) - 2 * romanNumbersCatalog.get(romanNumeralSplit[i - 1]);
            } else {

                result += romanNumbersCatalog.get(currentLetter);
            }
        }

        return result;

    }

    public static HashMap<String, Integer> getRomanNumbersCatalog() {
        HashMap<String, Integer> romanNumbersCatalog = new HashMap<>();
        romanNumbersCatalog.put("I", 1);
        romanNumbersCatalog.put("V ", 5);
        romanNumbersCatalog.put("X", 10);
        romanNumbersCatalog.put("L", 50);
        romanNumbersCatalog.put("C", 100);
        romanNumbersCatalog.put("D", 500);
        romanNumbersCatalog.put("M", 1000);

        return romanNumbersCatalog;

    }

}
