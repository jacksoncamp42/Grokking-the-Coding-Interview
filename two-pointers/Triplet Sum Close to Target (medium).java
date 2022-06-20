import java.util.*;

class TripletSumCloseToTarget {

  public static int searchTriplet(int[] arr, int targetSum) {
    if (arr == null || arr.length < 3)
      throw new IllegalArgumentException();

    Arrays.sort(arr);
    int smallestDiff = Integer.MAX_VALUE;
    for (int i = 0; i < arr.length - 2; i++) {
      int left = i + 1;
      int right = arr.length - 1;

      while (left < right) {
        int currDiff = targetSum - arr[i] - arr[left] - arr[right];

        if (currDiff == 0) {
          return targetSum;
        }
        if (Math.abs(currDiff) < Math.abs(smallestDiff)
            || (Math.abs(currDiff) == Math.abs(smallestDiff) && currDiff > smallestDiff)) {
          smallestDiff = currDiff;
        } else if (currDiff > 0) {
          left++;
        } else {
          right--;
        }
      }

    }
    return targetSum - smallestDiff;
  }
}