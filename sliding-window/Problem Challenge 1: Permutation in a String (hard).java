import java.util.*;

class StringPermutation {
  public static boolean findPermutation(String str, String pattern) {
    int startWindow = 0;
    int endWindow = pattern.length() - 1;
    char[] arr = str.toCharArray();
    Map<Character, Integer> patternMap  = new HashMap<>();
    Map<Character, Integer> windowMap = new HashMap<>();

    //fill initial hashmaps with (a, 0), (b, 0), (c, 0) ...
    for (char c = 'a'; c <= 'z'; c++) {
      patternMap.put(Character.valueOf(c), 0); 
      windowMap.put(Character.valueOf(c), 0);
    }

    //fills pattern/initial window map with char count
    for (int i = 0; i < pattern.length(); i++) {
      patternMap.put(pattern.charAt(i), patternMap.get(pattern.charAt(i)) + 1);
      windowMap.put(arr[i], windowMap.get(arr[i]) + 1);
    }
    
    if(patternMap.equals(windowMap)) {
        return true;
    }
    endWindow++;

    while (endWindow < arr.length) {
      //remove arr[startWindow] from map
      //add arr[endWindow to map]
      windowMap.put(arr[startWindow], windowMap.get(arr[startWindow]) - 1);
      startWindow++;
      windowMap.put(arr[endWindow], windowMap.get(arr[endWindow]) + 1);
      //check if substring matches pattern hash map
      if(patternMap.equals(windowMap)) {
        return true;
      }
     //slide window
      endWindow++;
    }
    return false;
  }
}