package com.oculux.se284.algorithms.sort;

import com.oculux.se284.datastructures.lists.List;

public class SelectionSort {

  private static List list;

  public static void run(List list) {
    SelectionSort.list = list;
    sort();
  }

  private static void sort() {
    for (int i = 0; i < list.size(); i++) {
      int j = getMinIndexRemaining(i);
      swap(i, j);
    }
  }

  private static int getMinIndexRemaining(int fromIndex) {
    int minIndex = fromIndex;

    for (int i = fromIndex; i < list.size(); i++) {
      if (list.get(i) < list.get(minIndex)) {
        minIndex = i;
      }
    }

    return minIndex;
  }

  private static void swap(int i, int j) {
    int temp = list.get(i);
    list.set(i, list.get(j));
    list.set(j, temp);
  }
}
