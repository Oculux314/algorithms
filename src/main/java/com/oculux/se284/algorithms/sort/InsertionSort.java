package com.oculux.se284.algorithms.sort;

import com.oculux.se284.datastructures.lists.List;

public class InsertionSort<T extends Comparable<? super T>> implements Sort<T> {

  private List<T> list;

  public InsertionSort(List<T> list) {
    this.list = list;
  }

  @Override
  public void run() {
    sort();
  }

  private void sort() {
    for (int i = 1; i < list.size(); i++) {
      int insertIndex = getInsertIndex(i);
      insertElement(insertIndex, i);
    }
  }

  private int getInsertIndex(int i) {
    int j = i - 1;
    while (j >= 0 && list.get(j).compareTo((list.get(i))) > 0) {
      j--;
    }
    return j + 1;
  }

  private void insertElement(int insertIndex, int fromIndex) {
    T temp = list.get(fromIndex);
    for (int i = fromIndex; i > insertIndex; i--) {
      list.set(i, list.get(i - 1));
    }
    list.set(insertIndex, temp);
  }
}
