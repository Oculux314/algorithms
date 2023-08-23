

public class InsertionSort {
  
  // O(n^2), O(n) when array is sorted
  public static void run(int[] A) {
    int n = A.length;

    for (int i = 0; i < n; i++) {
      int insertIndex = getInsertPosition(A, i);
      insertAtPosition(A, i, insertIndex);
    }
  }

  // O(n), O(1) when array is sorted
  private static int getInsertPosition(int[] A, int originIndex) {
    int j = originIndex;

    while (j > 0 && A[j - 1] > A[originIndex]) { // Scan until <= A[indexOfToShift]
      j--;
    }

    return j; // All elements j and onward will shift right 1 to allow insert
  }

  // O(n), O(1) when array is sorted
  private static void insertAtPosition(int[] A, int originIndex, int insertIndex) {
    int temp = A[originIndex];

    for (int k = originIndex; k > insertIndex; k--) {
      A[k] = A[k - 1]; // Shift right 1
    }

    A[insertIndex] = temp;
  }
}
