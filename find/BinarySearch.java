package find;

public class BinarySearch {
  
  // O(log(n))
  public static int run(int[] A, int x) {
    int left = 0;
    int right = A.length - 1;
    int mid;

    // Narrow bounds until left == right
    while(left < right) {
      mid = (right + left)/2;

      if (x > A[mid]) {
        left = mid + 1; // Not on left
      } else {
        right = mid; // Not on right
      }
    }

    if (A[left] == x) {
      return left;
    } else {
      return -1; // Not found
    }
  }
}
