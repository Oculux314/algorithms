package com.oculux.se284.datastructures.lists;

public class LinkedListTests extends ListTests {
  
  @Override
  protected <T> List<T> createList() {
    return new LinkedList<>();
  }

  
}
