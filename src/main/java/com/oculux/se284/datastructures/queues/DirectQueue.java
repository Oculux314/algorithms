package com.oculux.se284.datastructures.queues;

public class DirectQueue extends AbstractQueue {

  @SuppressWarnings("deprecation")
  @Override
  public void put(int value) {
    list.addToFront(value);
  }
}
