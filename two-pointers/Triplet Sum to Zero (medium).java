import java.util.*;

class TripletSumToZero {

  public static List<List<Integer>> searchTriplets(int[] arr) {
    List<List<Integer>> triplets = new ArrayList<>();
    Arrays.sort(arr);

    for (int i = 0; i < arr.length - 2; i++) {
      // skip duplicates
      if (i > 0 && arr[i] == arr[i - 1]) {
        continue;
      }
      searchPair(arr, -arr[i], i + 1, triplets);
    }
    return triplets;
  }

  public static void searchPair(int[] arr, int targetSum, int left, List<List<Integer>> triplets) {
    int right = arr.length - 1;
    while (left < right) {
      int sum = arr[left] + arr[right];
      if (sum == targetSum) { // found the triplet
        triplets.add(Arrays.asList(-targetSum, arr[left], arr[right]));
        left++;
        right--;
        while (left < right && arr[left] == arr[left - 1])
          left++; // skip same element to avoid duplicate triplets
        while (left < right && arr[right] == arr[right + 1])
          right--; // skip same element to avoid duplicate triplets
      } else if (sum < targetSum) {
        left++;
      } else {
        right--;
      }
    }

  }
}