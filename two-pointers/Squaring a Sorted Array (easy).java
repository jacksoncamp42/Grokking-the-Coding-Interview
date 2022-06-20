class SortedArraySquares {

  public static int[] makeSquares(int[] arr) {
    int[] squares = new int[arr.length];

    int left = 0;
    int right = arr.length - 1;
    int i = arr.length - 1;

    while (left <= right) {
      int leftSquared = arr[left] * arr[left];
      int rightSquared = arr[right] * arr[right];

      if (leftSquared < rightSquared) {
        squares[i] = rightSquared;
        i--;
        right--;
      } else {
        squares[i] = leftSquared;
        i--;
        left++;
      }
    }

    return squares;
  }
}