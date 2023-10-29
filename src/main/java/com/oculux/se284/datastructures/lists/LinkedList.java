package com.oculux.se284.datastructures.lists;

public class LinkedList implements List {

  protected class Node {
    private int value;
    private Node next;

    Node(int value, Node next) {
      this.value = value;
      this.next = next;
    }
  }

  protected Node head;
  protected Node tail;
  protected int size;

  public LinkedList() {
    head = null;
    tail = null;
    size = 0;
  }

  @Override
  public void add(int value) {
    Node newNode = makeNewNodeAtFront(value);

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
  public int get(int index) {
    Node node = getNode(index);
    return node.value;
  }

  @Override
  public void set(int index, int value) {
    Node node = getNode(index);
    node.value = value;
  }

  @Override
  public int size() {
    return size;
  }

  protected Node getNode(int index) {
    if (index >= size() || index < 0) {
      throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
    }

    Node node = head;
    for (int i = 0; i < index; i++) {
      node = node.next;
    }

    return node;
  }

  protected Node makeNewNodeAtEnd(int value) {
    return new Node(value, null);
  }

  protected Node makeNewNodeAtFront(int value) {
    return new Node(value, head);
  }

  @Deprecated
  public void addToFront(int value) {
    Node newNode = makeNewNodeAtFront(value);
    head = newNode;

    if (size() == 0) {
      tail = newNode;
    }

    size++;
  }

  @Deprecated
  public void removeFromFront() {
    if (size() == 0) {
      throw new IndexOutOfBoundsException("Cannot remove from empty list");
    }

    if (size() == 1) {
      head = null;
      tail = null;
    } else {
      head = head.next;
    }

    size--;
  }
}
