import java.util.*;

class TripletWithSmallerSum {

  public static int searchTriplets(int[] arr, int target) {
    int count = 0;
    Arrays.sort(arr);

    for (int a = 0; a < arr.length - 2; a++) {
      if (a > 0 && arr[a] == arr[a - 1]) {
        continue;
      }

      int left = a + 1;
      int right = arr.length - 1;

      while (left < right) {
        int sum = arr[a] + arr[left] + arr[right];
        if (sum < target) {
          count += right - left;
          left++;
        } else {
          right--;
        }
      }
    }
    return count;
  }
}
