package com.oculux.se284.datastructures.lists;

public class LinkedList<T> implements List<T> {

  private class Node {
    private T value;
    private Node prev;
    private Node next;

    Node(T value, Node prev, Node next) {
      this.value = value;
      this.prev = prev;
      this.next = next;
    }
  }

  private Node head;
  private Node tail;
  private int size;

  public LinkedList() {
    head = null;
    tail = null;
    size = 0;
  }

  @Override
  public void add(T value) {
    Node newNode = new Node(value, tail, null);

    if (head == null) {
      head = newNode;
    } else {
      tail.next = newNode;
    }

    tail = newNode;
    size++;
  }

  @Override
  public void remove() {
    if (size() == 0) {
      throw new IndexOutOfBoundsException("Cannot remove from empty list");
    }

    if (size() == 1) {
      head = null;
      tail = null;
    } else {
      Node prevNode = getNode(size() - 2);
      prevNode.next = null;
      tail = prevNode;
    }

    size--;
  }

  @Override
  public T get(int index) {
    Node node = getNode(index);
    return node.value;
  }

  @Override
  public void set(int index, T value) {
    Node node = getNode(index);
    node.value = value;
  }

  @Override
  public int size() {
    return size;
  }

  private Node getNode(int index) {
    if (index >= size() || index < 0) {
      throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
    }

    Node node;

    if (index < size() / 2) {
      node = head;
      for (int i = 0; i < index; i++) {
        node = node.next;
      }
    } else {
      node = tail;
      for (int i = size() - 1; i > index; i--) {
        node = node.prev;
      }
    }

    return node;
  }
}
