package com.oculux.se284.algorithms.sort;

import com.oculux.se284.algorithms.InsertionSort;
import com.oculux.se284.datastructures.lists.List;

public class InsertionSortTest extends SortTest {

  @Override
  protected void sort(List list) {
    InsertionSort.run(list);
  }
}
