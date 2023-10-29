package com.oculux.se284.datastructures.queues;

import com.oculux.se284.datastructures.lists.DoubleLinkedList;
import com.oculux.se284.datastructures.lists.LinkedList;

public abstract class AbstractQueue implements Queue {

  protected LinkedList list;

  public AbstractQueue() {
    list = new DoubleLinkedList();
  }

  @Override
  public abstract void put(int value);

  @Override
  public int pop() {
    int value = peek();
    list.remove();
    return value;
  }

  @Override
  public int peek() {
    return list.get(size() - 1);
  }

  @Override
  public int size() {
    return list.size();
  }
}
