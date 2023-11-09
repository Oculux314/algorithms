package com.oculux.se284.datastructures.lists;

public class DynamicArrayTests extends ListTests {

  @Override
  protected <T> List<T> createList() {
    return new DynamicArray<>();
  }
}
