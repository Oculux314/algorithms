package com.oculux.se284.datastructures.queues;

public class DirectQueue<T> extends AbstractQueue<T> {

  @Override
  public void put(T value) {
    list.add(value, 0);
  }
}
