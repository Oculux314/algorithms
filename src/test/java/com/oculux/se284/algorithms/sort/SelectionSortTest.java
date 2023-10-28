package com.oculux.se284.algorithms.sort;

import com.oculux.se284.datastructures.lists.List;

public class SelectionSortTest extends SortTest {

  @Override
  protected void sort(List list) {
    SelectionSort.run(list);
  }
  
}
