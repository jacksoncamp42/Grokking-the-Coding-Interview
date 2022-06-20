class PairWithTargetSum {

  public static int[] search(int[] arr, int targetSum) {
    int left = 0;
    int right = arr.length - 1;
    int sum = 0;

    while (left < right) {
      sum = arr[left] + arr[right];
      if (sum == targetSum) {
        return new int[] { left, right };
      } else if (sum < targetSum) {
        left++;
      } else if (sum > targetSum) {
        right--;
      }
    }

    return new int[] { -1, -1 };
  }
}