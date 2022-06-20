class MinSizeSubArraySum {
  public static int findMinSubArray(int S, int[] arr) {
    int startWindow = 0;
    int sum = 0;
    int lengthMinWindow = arr.length - 1;
    int endWindow = 0;

    while (endWindow < arr.length) {
      sum += arr[endWindow];

      // window exceeds minWindow -> shift window
      if ((endWindow - startWindow + 1) >= lengthMinWindow) {
        startWindow++;
        endWindow = startWindow;
        sum = 0;
      }
      // found valid sub-array -> shift
      else if (sum >= S) {
        // store new length
        lengthMinWindow = endWindow - startWindow + 1;
        // move start of window and start with window size 1 again
        startWindow++;
        endWindow = startWindow;
        sum = 0;
      }
      // havent reached sum or window length -> just keep expanding window
      else {
        endWindow++;
      }
    }
    return lengthMinWindow;
  }
}