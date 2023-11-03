package com.oculux.se284.datastructures.lists;

public interface List<T> {

  void add(T value);

  void remove();

  T get(int index);

  void set(int index, T value);

  int size();
}
