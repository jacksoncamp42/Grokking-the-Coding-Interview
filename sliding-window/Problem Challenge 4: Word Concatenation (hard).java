import java.util.*;

class WordConcatenation {
  public static List<Integer> findWordConcatenation(String str, String[] words) {
    Set<String> resultWords = new HashSet<String>();
    List<Integer> resultIndicies = new ArrayList<Integer>();

    int length = 0;

    for(int i = 0; i < words.length; i++) {
      length += words[i].length();
    }

    int startWindow = 0;
    int endWindow = length - 1;

    while (endWindow < str.length()) {
      String word = str.substring(startWindow, endWindow + 1);
      if(isConcatenation(word, words)) {
        if(!resultWords.contains(word)) {
          resultWords.add(word);
          resultIndicies.add(startWindow);
        }
      }
      startWindow++;
      endWindow++;
    }

    return resultIndicies;
  }

  public static boolean isConcatenation(String str, String[] words) {
    Map<String, Integer> map = new HashMap<>();
    Map<String, Integer> expectedMap = new HashMap<>();

    int index = 0;

    //fill hashmap
    for (int i = 0; i < words.length; i++) {
        map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        expectedMap.put(words[i], 0);
    }
    
    while (index < str.length()) {
      int wordLength = 0;
      boolean foundWord = false;
      //find next word
      for (int i = 0; i < words.length; i++) {
        wordLength = words[i].length();
        String curr = str.substring(index, index + wordLength);

        if (curr.equals(words[i])) {
          map.put(words[i], map.get(words[i]) - 1);
          foundWord = true;
          break;
        }
      }
      if(!foundWord) return false;
      index += wordLength;
    }

    return expectedMap.equals(map);
  }
}
