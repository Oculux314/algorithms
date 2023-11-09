package com.oculux.se284.datastructures.lists;

import com.oculux.se284.Untested;

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
  public void add(T value, int index) {
    if (index > size() || index < 0) {
      throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
    }

    add(value);
    for (int i = size() - 1; i > index; i--) {
      array[i] = array[i - 1];
    }
    array[index] = value;
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
  public void remove(int index) {
    if (index >= size() || index < 0) {
      throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
    }

    for (int i = index; i < size() - 1; i++) {
      array[i] = array[i + 1];
    }
    remove();
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

  @Untested
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("[");
    for (int i = 0; i < size(); i++) {
      builder.append(array[i]);
      if (i < size() - 1) {
        builder.append(", ");
      }
    }
    builder.append("]");
    return builder.toString();
  }
}
