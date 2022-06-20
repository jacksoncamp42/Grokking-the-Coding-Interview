import java.util.*;

class MinimumWindowSubstring {
  public static String findSubstring(String str, String pattern) {
    int startWindow = 0;
    int endWindow = 0;
    char[] arr = str.toCharArray();
    HashMap<Character, Integer> map = new HashMap<>();
    boolean patternFound = false;

    //fill hashmap based on chars in pattern
    for (char c : pattern.toCharArray()) {
      map.put(c, map.getOrDefault(c, 0) + 1);
    }
    
    while(endWindow < arr.length) {
      char c = arr[endWindow];

      if(map.containsKey(c)) {
        map.put(c, map.get(c) - 1);
      }

      boolean allZeros = true;
      //check if map has all 0 values
      for (Integer value : map.values()) {
        if(value > 0) {
          allZeros = false;
          break;
        }
      }

      //if patternFound try shrinking -> increase startWindow
      while (allZeros) {
        patternFound = true;
        char ch = arr[startWindow];
        if(!map.containsKey(ch)) {
          startWindow++;
        }
        else if (map.get(ch) < 0) {
          map.put(ch, map.get(ch) + 1);
          startWindow++;
        }
        else {
          allZeros = false;
        }
      }
      endWindow++;
    }

    if (patternFound) return str.substring(startWindow, endWindow);
    else return "";
  }
}