package com.oculux.se284.datastructures.maps.hashtables;

class Node {
  int key;
  int value;

  public Node(int key, int value) {
    this.key = key;
    this.value = value;
  }

  public int getKey() {
    return this.key;
  }

  public int getValue() {
    return this.value;
  }
}