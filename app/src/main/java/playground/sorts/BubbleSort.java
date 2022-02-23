package playground.sorts;

public class BubbleSort implements ISort {
//http://www.universidadejava.com.br/pesquisa_ordenacao/bubble-sort/#:~:text=O%20Bubble%2DSort%20%C3%A9%20um,se%20est%C3%A3o%20na%20ordem%20desejada.

    @Override
    public int[] sort(int[] numbers) {
        for(int number : numbers) {
            System.out.println("number = " + number);
        }

        for(int i = 0; i < numbers.length - 1; i++) {
            for(int j = 0; j < numbers.length - 1 - i; j++) {
                System.out.println("i = " + i);
                System.out.println("j = " + j);
                if(numbers[j] > numbers[j + 1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }
        return numbers;
    }
}
