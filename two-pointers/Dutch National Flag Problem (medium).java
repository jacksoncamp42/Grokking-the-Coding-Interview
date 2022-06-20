class DutchFlag {

  public static void sort(int[] arr) {
    int low = 0;
    int high = arr.length - 1;
    int i = 0;
    while (i <= high) {
      int num = arr[i];
      if (num == 0) {
        swap(arr, low, i);
        low++;
        i++;
      } else if (num == 1) {
        i++;
      } else if (num == 2) {
        swap(arr, high, i);
        high--;
      }
    }
  }

  private static void swap(int[] arr, int a, int b) {
    int temp = arr[a];
    arr[a] = arr[b];
    arr[b] = temp;
  }
}