package playground;

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
    params.put(2, () -> String.join(" and ", names) + " like this");
    params.put(
        3,
        () -> {
          StringBuilder message = new StringBuilder();

          for (int i = 0; i < people; i++) {
            String name = names[i];
            boolean isLast = people == (i + 1);
            boolean isFirst = i == 0;

            if (isFirst) {
              message.append(name);
            } else if (isLast) {
              message.append(" and ").append(name).append(" like this");
            } else {
              message.append(", ").append(name);
            }
          }

          return message.toString();
        });
    params.put(
        4,
        () -> {
          StringBuilder message = new StringBuilder();
          message
              .append(names[0] + ", ")
              .append(names[1])
              .append(" and " + (people - 2) + " others like this");
          return message.toString();
        });

    StringBuilder finalMessage = new StringBuilder();
    String message;

    if (people >= 4) {
      message = params.get(4).get();
    } else {
      message = params.get(people).get();
    }

    return finalMessage.append(message).toString();
  }
}
