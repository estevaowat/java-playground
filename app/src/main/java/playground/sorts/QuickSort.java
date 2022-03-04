package playground.sorts;

public class QuickSort implements ISort {

    @Override
    public int[] sort(int[] numbers) {
        if(numbers.length == 0) {
            return numbers;
        }

        final int begin = 0;
        int end = numbers.length - 1;

        return sort(numbers, begin, end);
    }

    private int[] sort(int[] numbers, int begin, int end) {
        if(begin < end) {
            int pivoIndex = partition(numbers, begin, end);

            sort(numbers, begin, pivoIndex - 1);
            sort(numbers, pivoIndex + 1, end);
        }

        return numbers;

    }

    private int partition(int[] numbers, int begin, int end) {

        int pivotValue = numbers[end];
        int index = begin - 1;

        for(int j = begin; j < end; j++) {

            if(numbers[j] <= pivotValue) {
                index++;

                int swapTemp = numbers[index];
                numbers[index] = numbers[j];
                numbers[j] = swapTemp;

            }
        }

        int pivoTemp = numbers[index + 1];
        numbers[index + 1] = numbers[end];
        numbers[end] = pivoTemp;

        return index + 1;
    }


}
