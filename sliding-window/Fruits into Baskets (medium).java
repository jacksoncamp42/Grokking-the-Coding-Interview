import java.util.*;

class MaxFruitCountOf2Types {
  public static int findLength(char[] arr) {
    int startWindow = 0;
    int endWindow = 0;

    int mostFruit = 0;
    Map<Character, Integer> map = new HashMap<>();

    while (endWindow < arr.length) {
      // update hashmap with current char
      map.put(arr[endWindow], map.getOrDefault(arr[endWindow], 0) + 1);

      // if distinct fruit exceeds 2 -> shrink window
      while (map.size() > 2) {
        map.put(arr[startWindow], map.get(arr[startWindow]) - 1);
        if (map.get(arr[startWindow]) == 0) {
          map.remove(arr[startWindow]);
        }
        startWindow++;
      }

      mostFruit = Math.max(mostFruit, endWindow - startWindow + 1);
      endWindow++;
    }
    return mostFruit;
  }
}