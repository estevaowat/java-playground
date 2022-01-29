package playground;

import java.util.LinkedList;
import java.util.List;

public class Josephus {

    private Josephus() {
        // This is an empty constructor to make sonar lint shut up
    }

    public static <T> List<T> solution(List<T> items, int k) {
        LinkedList<T> newList = new LinkedList<>(items);
        LinkedList<T> permutations = new LinkedList<>();
        int position = 0;

        while(!(newList.isEmpty())) {
            position = (position + k - 1) % newList.size();
            T removedItem = newList.remove(position);
            permutations.add(removedItem);
        }

        return permutations;
    }
}
