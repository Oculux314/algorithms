package com.oculux.se284.datastructures.lists;

public class DoubleLinkedListTests extends LinkedListTests {

  @Override
  protected <T> List<T> createList() {
    return new DoubleLinkedList<>();
  }
}
