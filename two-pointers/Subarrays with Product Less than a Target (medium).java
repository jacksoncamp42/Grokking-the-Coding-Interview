import java.util.*;

class SubarrayProductLessThanK {

  public static List<List<Integer>> findSubarrays(int[] arr, int target) {
    List<List<Integer>> subarrays = new ArrayList<>();
    int left = 0;
    int right = 0;
    double product = 1;

    while (right < arr.length) {
      product *= arr[right];
      while (left < right && target <= product) {
        product /= arr[left];
        left++;
      }

      List<Integer> sub = new ArrayList<>();
      for (int i = right; i >= left; i--) {
        sub.add(0, arr[i]);
        subarrays.add(new ArrayList<>(sub));
      }
      right++;
    }

    return subarrays;
  }
}