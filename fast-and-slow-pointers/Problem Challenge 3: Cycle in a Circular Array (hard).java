class CircularArrayLoop {

  public static boolean loopExists(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      boolean direction;
      if(arr[i] > 0) {
        direction = true;
      }
      else if(arr[i] < 0) {
        direction = false;
      }
      else {
        continue;
      }
      if (loop(arr, i, direction)) {
        return true;
      }
    }
    return false;
  }

  public static boolean loop(int[] arr, int index, boolean direction) {
    int slow = next(arr, index);
    int fast = next(arr, next(arr, index));
    boolean initialDirection = direction;

    while (direction == initialDirection) {
      if (arr[slow] > 0 != direction) {
        return false;
      }
      if (arr[fast] > 0 != direction) {
        return false;
      }
      if(slow == fast) {
        return true;
      }
      slow = next(arr, slow);
      fast = next(arr, next(arr, fast));
    }
    return false;
  }

  public static int next(int[] arr, int index) {
    int step = arr[index];
    return (index + step) % (arr.length);
  }

  public static void main(String[] args) {
    System.out.println(CircularArrayLoop.loopExists(new int[] { 1, 2, -1, 2, 2 }));
    System.out.println(CircularArrayLoop.loopExists(new int[] { 2, 2, -1, 2 }));
    System.out.println(CircularArrayLoop.loopExists(new int[] { 2, 1, -1, -2 }));
  }
}