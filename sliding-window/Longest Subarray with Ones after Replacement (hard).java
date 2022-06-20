class ReplacingOnes {
  public static int findLength(int[] arr, int k) {
    int startWindow = 0;
    int endWindow = 0;
    int numOnesInWindow = 0;
    int longest = 0;

    while (endWindow < arr.length) {
      int curr = arr[endWindow];

      if (curr == 1) {
        numOnesInWindow++;
      }
      if (((endWindow - startWindow + 1) - numOnesInWindow) > k) {
        if (arr[startWindow] == 1) {
          numOnesInWindow--;
        }
        startWindow++;
      }
      longest = Math.max(longest, (endWindow - startWindow + 1));

      endWindow++;
    }

    return longest;
  }
}