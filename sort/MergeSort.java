

public class MergeSort {
  
  // O(nlog(n))
  public static void run(int[] A, int start, int end) {
    if (start == end) {
      return;
    }

    int mid = partion(A, start, end); // O(1)
    run(A, 0, mid); // Left
    run(A, mid + 1, end); // Right
    merge(A, start, end, mid); // O(n)
  }

  public static void run(int[] A) {
    run(A, 0, A.length - 1);
  }

  private static int partion(int[] a, int start, int end) {
    return (start + end)/2;
  }

  private static void merge(int[] A, int start, int end, int mid) {
    int index1 = start; // Index of min element (left half)
    int index2 = mid + 1; // Index of min element (right half)
    int[] B = new int[end - start + 1]; // Temp array
    int indexB = 0;

    // Merge left and right halves into temp array
    while (index1 <= mid || index2 <= end) {
      boolean addFrom1 = index2 > end || (index1 <= mid && A[index1] < A[index2]);
      
      // O(start - end)
      if (addFrom1) {
        B[indexB] = A[index1];
        index1++;
      } else {
        B[indexB] = A[index2];
        index2++;
      }

      indexB++;
    }

    // Copy temp --> A | O(end - start)
    for (int i = 0; i < indexB; i++) {
      A[i + start] = B[i];
    }
  }
}
