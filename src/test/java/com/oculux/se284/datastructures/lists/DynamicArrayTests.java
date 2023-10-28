package com.oculux.se284.datastructures.lists;

public class DynamicArrayTests extends ListTests {

  @Override
  protected List createList() {
    return new DynamicArray();
  }
}
