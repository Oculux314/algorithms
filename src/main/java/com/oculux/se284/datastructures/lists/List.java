package com.oculux.se284.datastructures.lists;

public interface List<T> {

  void add(T value);

  void add(T value, int index);

  void remove();

  void remove(int index);

  T get(int index);

  void set(int index, T value);

  int size();
}
