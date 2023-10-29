package com.oculux.se284.datastructures.queues;

public interface Queue {
  
  void put(int value);

  int pop();

  int peek();

  int size();
}
