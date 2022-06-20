import java.util.*;

class StringAnagrams {
  public static List<Integer> findStringAnagrams(String str, String pattern) {
    List<Integer> resultIndices = new ArrayList<Integer>();
    Map<Character, Integer> patternMap = new HashMap<Character, Integer>();
    Map<Character, Integer> windowMap = new HashMap<Character, Integer>();
    int startWindow = 0;
    int endWindow = pattern.length() - 1;
    char[] arr = str.toCharArray();

    //fill maps with (a,0), (b,0), ... (z,0)
    for(char ch = 'a'; ch <= 'z'; ch++) {
      patternMap.put(Character.valueOf(ch), 0);
      windowMap.put(Character.valueOf(ch), 0);
    }
    //fill maps
    for(int i = 0; i < pattern.length(); i++) {
      patternMap.put(pattern.charAt(i), patternMap.get(pattern.charAt(i)) + 1);
      windowMap.put(arr[i], windowMap.get(arr[i]) + 1);
    }

    if(patternMap.equals(windowMap)) {
      resultIndices.add(startWindow);
    }
    endWindow++;

    while(endWindow < arr.length) {
      windowMap.put(arr[endWindow], windowMap.get(arr[endWindow]) + 1);
      windowMap.put(arr[startWindow], windowMap.get(arr[startWindow]) - 1);
      startWindow++;
      
      if(patternMap.equals(windowMap)) {
        resultIndices.add(startWindow);
      }
      endWindow++;
    }
    return resultIndices;
  }
}