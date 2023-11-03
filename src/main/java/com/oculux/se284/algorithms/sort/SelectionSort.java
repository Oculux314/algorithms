package com.oculux.se284.algorithms.sort;

import com.oculux.se284.datastructures.lists.List;

public class SelectionSort<T extends Comparable<? super T>> implements Sort<T> {

  private List<T> list;

  public SelectionSort(List<T> list) {
    this.list = list;
  }

  @Override
  public void run() {
    sort();
  }

  private void sort() {
    for (int i = 0; i < list.size(); i++) {
      int j = getMinIndexRemaining(i);
      swap(i, j);
    }
  }

  private int getMinIndexRemaining(int fromIndex) {
    int minIndex = fromIndex;

    for (int i = fromIndex; i < list.size(); i++) {
      if (list.get(i).compareTo(list.get(minIndex)) < 0) {
        minIndex = i;
      }
    }

    return minIndex;
  }

  private void swap(int i, int j) {
    T temp = list.get(i);
    list.set(i, list.get(j));
    list.set(j, temp);
  }
}
