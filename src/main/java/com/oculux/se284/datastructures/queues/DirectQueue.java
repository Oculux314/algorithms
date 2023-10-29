package com.oculux.se284.datastructures.queues;

public class DirectQueue extends AbstractQueue {

  @Override
  public void put(int value) {
    list.addToFront(value);
  }
}
