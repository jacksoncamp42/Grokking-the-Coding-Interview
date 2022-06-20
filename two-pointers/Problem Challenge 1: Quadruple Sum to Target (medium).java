import java.util.*;

class QuadrupleSumToTarget {

  public static List<List<Integer>> searchQuadruplets(int[] arr, int target) {
    List<List<Integer>> quadruplets = new ArrayList<>();
    Arrays.sort(arr);

    for(int a = 0; a < arr.length - 3; a++) {
      if(a >= 2 && arr[a] == arr[a-1]) {
        continue;
      }
      for (int b = a + 1; b < arr.length - 2; b++) {
        if(b >= 2 && arr[b] == arr[b-1]) {
          continue;
        }
        int left = b + 1;
        int right = arr.length - 1;
        
        while(left < right) {
          int sum = arr[a] + arr[b] + arr[left] + arr[right];
          if(sum == target) {
            quadruplets.add(Arrays.asList(arr[a], arr[b], arr[left], arr[right]));
            left++;
            right--;
            while(left < right && arr[left] == arr[left - 1]) {
              left++;
            }
            while(left < right && arr[right] == arr[right + 1]) {
              right--;
            }
          }
          else if(sum < target) {
            left++;
          }
          else if(sum > target) {
            right--;
          }
        }
      }
    }
    return quadruplets;
  }
}