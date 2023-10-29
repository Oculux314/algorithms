package com.oculux.se284.datastructures.maps;

public interface Map {

  void put(int key, int value);

  void remove(int key);

  boolean contains(int key);

  int get(int key);

  int size();
}
