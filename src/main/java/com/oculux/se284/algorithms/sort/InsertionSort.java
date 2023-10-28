package com.oculux.se284.algorithms.sort;

import com.oculux.se284.datastructures.lists.List;

public class InsertionSort {

  private static List list;

  public static void run(List list) {
    InsertionSort.list = list;
    sort();
  }

  private static void sort() {
    for (int i = 1; i < list.size(); i++) {
      int insertIndex = getInsertIndex(i);
      insertElement(insertIndex, i);
    }
  }

  private static int getInsertIndex(int i) {
    int j = i - 1;
    while (j >= 0 && list.get(j) > list.get(i)) {
      j--;
    }
    return j + 1;
  }

  private static void insertElement(int insertIndex, int fromIndex) {
    int temp = list.get(fromIndex);
    for (int i = fromIndex; i > insertIndex; i--) {
      list.set(i, list.get(i - 1));
    }
    list.set(insertIndex, temp);
  }
}
