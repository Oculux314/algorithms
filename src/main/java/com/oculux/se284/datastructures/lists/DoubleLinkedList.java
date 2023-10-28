package com.oculux.se284.datastructures.lists;

public class DoubleLinkedList extends LinkedList {

  protected class Dinode extends Node {
    private Node prev;

    Dinode(int value, Node next, Node prev) {
      super(value, next);
      this.prev = prev;
    }
  }

  @Override
  public void add(int value) {
    Node newNode = new Dinode(value, null, tail);

    if (head == null) {
      head = newNode;
    } else {
      tail.next = newNode;
    }

    tail = newNode;
    size++;
  }

  @Override
  protected Node getNode(int index) {
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
        node = ((Dinode) node).prev;
      }
    }

    return node;
  }
}
