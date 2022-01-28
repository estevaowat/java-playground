package playground;

import java.util.LinkedList;
import java.util.List;

public class Josephus {

    private Josephus() {
        // This is an empty constructor to make sonar lint shut up
    }

    public static <T> List<T> josephusPermutation(List<T> items, int k) {
        LinkedList<T> newList = new LinkedList<>(items);
        LinkedList<T> permutations = new LinkedList<>();
        int position = 0;

        while(!(newList.isEmpty())) {
            position = (position + k - 1) % newList.size();
            permutations.add(newList.remove(position));
        }

        return permutations;
    }


    static int josephus(int n, int k) {
        if(n == 1)
            return 0;
        else {
            int res = ((josephus(n - 1, k) + k) % n);
            System.out.println(res);

            return res;
        }
    }
}
