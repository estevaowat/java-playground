package playground.sorts;

import java.util.Random;

public class RandomNumbers {
    private RandomNumbers() {
    }

    public static int[] createArrayWithRandomNumbers(int size) {
        int[] numbers = new int[size];

        for(int i = 0; i < size; i++) {
            numbers[i] = getRandomNumber(size);
        }

        return numbers;
    }

    public static int getRandomNumber(int size) {
        Random randomizer = new Random();
        return randomizer.nextInt(size);
    }
}
