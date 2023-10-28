package com.oculux.se284.datastructures.lists;

public class DynamicArray implements List {

  private static final int DEFAULT_SIZE = 8;
  private int[] array;
  private int size;

  public DynamicArray() {
    this(DEFAULT_SIZE);
  }

  public DynamicArray(int size) {
    array = new int[size];
    size = 0;
  }

  @Override
  public void add(int value) {
    if (size() >= maxSize()) {
      resize(maxSize() * 2);
    }

    array[size()] = value;
    size++;
  }

  @Override
  public void remove() {
    if (size() == 0) {
      throw new UnsupportedOperationException("Cannot remove from empty list");
    }
    
    if (size() < maxSize() / 4 && maxSize() > DEFAULT_SIZE) {
      resize(maxSize() / 2);
    }

    array[size() - 1] = 0;
    size--;
  }

  @Override
  public int get(int index) {
    return array[index];
  }

  @Override
  public void set(int index, int value) {
    if (index >= size()) {
      throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
    }

    array[index] = value;
  }

  @Override
  public int size() {
    return size;
  }

  private int maxSize() {
    return array.length;
  }

  private void resize(int newSize) {
    int[] newArray = new int[newSize];
    for (int i = 0; i < maxSize(); i++) {
      newArray[i] = array[i];
    }
    array = newArray;
  }
}
