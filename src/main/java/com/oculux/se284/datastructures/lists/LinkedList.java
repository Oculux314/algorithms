package com.oculux.se284.datastructures.lists;

public class LinkedList implements List {

  private class Node {
    int value;
    Node next;

    Node(int value) {
      this.value = value;
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
  public void add(int value) {
    Node newNode = new Node(value);

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

  private Node getNode(int index) {
    if (index >= size()) {
      throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
    }

    Node node = head;
    for (int i = 0; i < index; i++) {
      node = node.next;
    }

    return node;
  }
}
