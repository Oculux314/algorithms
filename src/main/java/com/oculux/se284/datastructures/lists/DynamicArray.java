package com.oculux.se284.datastructures.lists;

public class DynamicArray<T> implements List<T> {

  private static final int DEFAULT_SIZE = 8;
  private Object[] array;
  private int size;

  public DynamicArray() {
    this(DEFAULT_SIZE);
  }

  public DynamicArray(int size) {
    array = new Object[size];
    size = 0;
  }

  @Override
  public void add(T value) {
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
  public T get(int index) {
    if (index >= size() || index < 0) {
      throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
    }

    @SuppressWarnings("unchecked")
    T value = (T) array[index];
    return value;
  }

  @Override
  public void set(int index, T value) {
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
    Object[] newArray = new Object[newSize];
    for (int i = 0; i < size(); i++) {
      newArray[i] = array[i];
    }
    array = newArray;
  }
}
