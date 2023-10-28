package com.oculux.se284.algorithms.sort;

import com.oculux.se284.datastructures.lists.List;

public class InsertionSortTests extends SortTests {

  @Override
  protected void sort(List list) {
    InsertionSort.run(list);
  }
}
