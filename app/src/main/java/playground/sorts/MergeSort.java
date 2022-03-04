package playground.sorts;

public class MergeSort implements ISort {

    @Override
    public int[] sort(int[] numbers) {

        if(numbers.length < 2) {
            return numbers;
        }

        int middle = numbers.length / 2;

        int[] leftSideNumbers = new int[middle];
        System.arraycopy(numbers, 0, leftSideNumbers, 0, middle);


        int[] rightSideNumbers = new int[numbers.length - middle];

        if(numbers.length - middle >= 0)
            System.arraycopy(numbers, middle, rightSideNumbers, 0, numbers.length - middle);

 
        /// - apply merge sort in left array
        sort(leftSideNumbers);

        /// - apply merge sort in right array
        sort(rightSideNumbers);

        //merge leftside with right side
        merge(numbers, leftSideNumbers, rightSideNumbers);


        return numbers;

    }


    private int[] merge(int[] numbers, int[] left, int[] right) {
        int totalElementsLeft = left.length;
        int totalElementsRight = right.length;
        int i = 0;
        int j = 0;
        int k = 0;

        while(i < totalElementsLeft && j < totalElementsRight) {
            if(left[i] <= right[j]) {
                numbers[k++] = left[i++];
            } else {
                numbers[k++] = right[j++];
            }
        }

        while(i < totalElementsLeft) {
            numbers[k++] = left[i++];
        }
        while(j < totalElementsRight) {
            numbers[k++] = right[j++];
        }

        return numbers;
    }
}
