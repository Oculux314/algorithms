package com.oculux.se284.datastructures.queues;

import com.oculux.se284.datastructures.lists.LinkedList;
import com.oculux.se284.datastructures.lists.List;

public abstract class AbstractQueue<T> implements Queue<T> {

  protected List<T> list;

  public AbstractQueue() {
    list = new LinkedList<>();
  }

  @Override
  public abstract void put(T value);

  @Override
  public T pop() {
    T value = peek();
    list.remove();
    return value;
  }

  @Override
  public T peek() {
    return list.get(size() - 1);
  }

  @Override
  public int size() {
    return list.size();
  }
}
