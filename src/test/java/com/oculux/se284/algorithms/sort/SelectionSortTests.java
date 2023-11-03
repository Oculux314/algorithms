package com.oculux.se284.algorithms.sort;

import com.oculux.se284.datastructures.lists.List;

public class SelectionSortTests extends SortTests {

  @Override
  protected <T extends Comparable<? super T>> void sort(List<T> list) {
    new SelectionSort<>(list).run();
  }
}
