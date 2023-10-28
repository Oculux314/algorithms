package com.oculux.se284.datastructures.lists;

public class DynamicArray implements List {

  private int[] array;
  private int size;

  public DynamicArray() {
    this(10);
  }

  public DynamicArray(int size) {
    array = new int[size];
    size = 0;
  }

  @Override
  public void add(int value) {
    if (size() == maxSize()) {
      throw new UnsupportedOperationException("Resizing not implemented");
    }

    array[size()] = value;
    size++;
  }

  @Override
  public void set(int index, int value) {
    if (index >= size()) {
      throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
    }

    array[index] = value;
  }

  @Override
  public void remove() {
    if (size() == 0) {
      throw new UnsupportedOperationException("Cannot remove from empty list");
    }

    array[size() - 1] = 0;
    size--;
  }

  @Override
  public int get(int index) {
    return array[index];
  }

  @Override
  public int size() {
    return size;
  }

  private int maxSize() {
    return array.length;
  }
}
