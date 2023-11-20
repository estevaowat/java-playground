package playground.exercises;

import com.google.common.base.Supplier;

import java.util.HashMap;

public class LikersFacebook {

    /*
    * You probably know the "like" system from Facebook and other pages.
    * People can "like" blog posts, pictures or other items.
    * We want to create the text that should be displayed next to such an item.

    * Implement the function which takes an array containing the names of people that like an item.
    * It must return the display text as shown in the examples:

    []                                -->  "no one likes this"
    ["Peter"]                         -->  "Peter likes this"
    ["Jacob", "Alex"]                 -->  "Jacob and Alex like this"
    ["Max", "John", "Mark"]           -->  "Max, John and Mark like this"
    ["Alex", "Jacob", "Mark", "Max"]  -->  "Alex, Jacob and 2 others like this"

    * Note: For 4 or more names, the number in "and 2 others" simply increases.
    *
    *
    *
    *  switch (names.length) {
            case 0: return "no one likes this";
            case 1: return String.format("%s likes this", names[0]);
            case 2: return String.format("%s and %s like this", names[0], names[1]);
            case 3: return String.format("%s, %s and %s like this", names[0], names[1], names[2]);
            default: return String.format("%s, %s and %d others like this", names[0], names[1], names.length - 2);
          }
          *  */
    public static String whoLikesIt(String... names) {
        int people = names.length;

        HashMap<Integer, Supplier<String>> params = new HashMap<>();

        params.put(0, () -> "no one likes this");
        params.put(1, () -> names[0] + " likes this");
        params.put(2, () -> names[0] + " and " + names[1] + " like this");
        params.put(3, () -> names[0] + ", " + names[1] + " and " + names[2] + " like this");
        params.put(4, () -> names[0] + ", " + names[1] + " and " + (people - 2) + " others like this");

        java.util.function.Supplier<String> supplier = params.get(people);

        if(params.get(people) == null) {
            supplier = params.get(4);
        }

        return supplier.get();
    }
}
