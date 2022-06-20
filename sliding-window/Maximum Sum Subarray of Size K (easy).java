class MaxSumSubArrayOfSizeK {
  public static int findMaxSumSubArray(int k, int[] arr) {
    int startWindow = 0;
    int maxSum = 0;
    int sum = 0;
    for (int endWindow = 0; endWindow < arr.length; endWindow++) {
      sum += arr[endWindow];

      // shift window
      if (endWindow >= k - 1) {
        maxSum = Math.max(maxSum, sum);
        sum -= arr[startWindow];
        startWindow++;
      }
    }
    return maxSum;
  }
}