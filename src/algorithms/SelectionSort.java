package algorithms;

public class SelectionSort {
  
  // O(n^2)
  public static void run(int[] A) {
    int n = A.length;

    for (int i = 0; i < n; i++) {
      int minIndex = getMin(A, i, n);

      int temp = A[i];
      A[i] = A[minIndex];
      A[minIndex] = temp;
    }
  }

  // O(n)
  private static int getMin(int[] A, int start, int end) {
    int min = A[start];
    int minIndex = start;

    for (int i = start; i < end; i++) {
      if (A[i] < min) {
        min = A[i];
        minIndex = i;
      }
    }

    return minIndex;
  }
}
