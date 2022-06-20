import java.util.*;

class LongestSubstringKDistinct {
  public static int findLength(String str, int k) {
    char[] arr = str.toCharArray();

    int startWindow = 0;
    int endWindow = 0;

    Set<Character> set = new HashSet<>();
    int currLength = 0;
    int longest = 0;

    while (endWindow < arr.length) {
      char c = arr[endWindow];
      // if repeat char -> expand window & and add to length
      if (set.contains(c)) {
        currLength++;
        endWindow++;
        if (currLength > longest) {
          longest = currLength;
        }
      }
      // if Set is not at max -> expand window & add c
      else if (set.size() < k) {
        currLength++;
        endWindow++;
        set.add(c);
        if (currLength > longest) {
          longest = currLength;
        }
      }
      // set full of distinct characters -> slide window
      else {
        currLength = 0;
        startWindow++;
        set = new HashSet<>();
        endWindow = startWindow;
      }

    }
    return longest;
  }
}