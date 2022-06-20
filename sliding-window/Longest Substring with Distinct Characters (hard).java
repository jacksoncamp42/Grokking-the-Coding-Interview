import java.util.*;

class NoRepeatSubstring {
  public static int findLength(String str) {
    char[] arr = str.toCharArray();
    int startWindow = 0;
    int endWindow = 0;
    int longest = 0;
    int currLength = 0;

    Map<Character, Integer> map = new HashMap<>();

    while (endWindow < arr.length) {
      char c = arr[endWindow];

      // if char is not distinct -> slide window
      if (map.containsKey(c)) {
        // move start window to next character after first appearence of the distinct
        // char
        startWindow = map.get(c) + 1;
        endWindow = startWindow;
        currLength = 0;
        map = new HashMap<>();
      }
      // if char is distinct
      else {
        map.put(c, endWindow);
        endWindow++;
        currLength++;
        longest = Math.max(longest, currLength);
      }
    }
    return longest;
  }
}