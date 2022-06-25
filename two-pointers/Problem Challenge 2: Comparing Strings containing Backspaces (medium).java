class BackspaceCompare {

  public static boolean compare(String str1, String str2) {
    //another method: use two stacks
    int index1 = str1.length();
    int index2 = str2.length();

    while(index1 > 0 && index2 > 0) {
      index1 = findNextValid(str1, index1 - 1);
      index2 = findNextValid(str2, index2 - 1);
      if(str1.charAt(index1) != str2.charAt(index2)) {
        return false;
      }
    }
    return true;
  }

  public static int findNextValid(String str, int index) {
    //like a stack!
    int backspaceCount = 0;
    while (index >= 0) {
      if (str.charAt(index) == '#') // found a backspace character
        backspaceCount++;
      else if (backspaceCount > 0) // a non-backspace character
        backspaceCount--;
      else
        break;

      index--; // skip a backspace or a valid character
    }
    return index;
  }
}