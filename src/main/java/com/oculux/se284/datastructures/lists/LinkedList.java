package com.oculux.se284.datastructures.lists;

import com.oculux.se284.Untested;

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
    addAtEnd(value);
  }

  public void add(T value, int index) {
    if (index > size() || index < 0) {
      throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
    }

    if (index == size()) {
      addAtEnd(value);
    } else if (index == 0) {
      addAtStart(value);
    } else {
      addAtMiddle(value, index);
    }
  }

  private void addAtEnd(T value) {
    Node node = new Node(value, tail, null);

    if (tail == null) {
      head = node;
    } else {
      tail.next = node;
    }

    tail = node;
    size++;
  }

  private void addAtStart(T value) {
    Node node = new Node(value, null, head);

    if (head == null) {
      tail = node;
    } else {
      head.prev = node;
    }

    head = node;
    size++;
  }

  private void addAtMiddle(T value, int index) {
    Node nextNode = getNode(index);
    Node prevNode = nextNode.prev;
    Node newNode = new Node(value, prevNode, nextNode);
    nextNode.prev = newNode;
    prevNode.next = newNode;
    size++;
  }

  @Override
  public void remove() {
    if (size() == 0) {
      throw new IndexOutOfBoundsException("Cannot remove from empty list");
    }

    if (size() == 1) {
      clear();
    } else {
      removeAtEnd();
    }
  }

  @Override
  public void remove(int index) {
    if (index >= size() || index < 0) {
      throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
    }

    if (index == size() - 1) {
      remove(); // removeAtEnd() with size == 1 check
    } else if (index == 0) {
      removeAtStart();
    } else {
      removeAtMiddle(index);
    }
  }

  private void clear() {
    head = null;
    tail = null;
    size = 0;
  }

  private void removeAtEnd() {
    Node prevNode = getNode(size() - 2);
    prevNode.next = null;
    tail = prevNode;
    size--;
  }

  private void removeAtStart() {
    Node nextNode = getNode(1);
    nextNode.prev = null;
    head = nextNode;
    size--;
  }

  private void removeAtMiddle(int index) {
    Node prevNode = getNode(index - 1);
    Node nextNode = prevNode.next.next;
    prevNode.next = nextNode;
    nextNode.prev = prevNode;
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

  @Untested
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("[");

    Node node = head;
    while (node != null) {
      builder.append(node.value);
      if (node.next != null) {
        builder.append(", ");
      }
      node = node.next;
    }

    builder.append("]");
    return builder.toString();
  }
}
