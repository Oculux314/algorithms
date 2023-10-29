package com.oculux.se284.datastructures.queues;

public class Stack extends AbstractQueue {

  @Override
  public void put(int value) {
    list.add(value);
  }
}
