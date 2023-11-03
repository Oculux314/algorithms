package com.oculux.se284.datastructures.queues;

public interface Queue<T> {
  
  void put(T value);

  T pop();

  T peek();

  int size();
}
