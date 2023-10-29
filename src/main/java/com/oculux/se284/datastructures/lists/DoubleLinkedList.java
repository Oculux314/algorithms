package com.oculux.se284.datastructures.lists;

public class DoubleLinkedList extends LinkedList {

  protected class Dinode extends Node {
    private Dinode prev;
    private Dinode next;

    Dinode(int value, Dinode next, Dinode prev) {
      super(value, next);
      this.prev = prev;
    }
  }

  @Override
  public void add(int value) {
    Dinode newNode = (Dinode) makeNewNodeAtEnd(value);

    if (head == null) {
      head = newNode;
    } else {
      ((Dinode) tail).next = newNode;
    }

    tail = newNode;
    size++;
  }

  @Override
  protected Dinode getNode(int index) {
    if (index >= size() || index < 0) {
      throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
    }

    Dinode node;

    if (index < size() / 2) {
      node = (Dinode) head;
      for (int i = 0; i < index; i++) {
        node = node.next;
      }
    } else {
      node = (Dinode) tail;
      for (int i = size() - 1; i > index; i--) {
        node = node.prev;
      }
    }

    return node;
  }

  @Override
  protected Node makeNewNodeAtEnd(int value) {
    return new Dinode(value, null, (Dinode) tail);
  }

  @Override
  protected Node makeNewNodeAtFront(int value) {
    return new Dinode(value, (Dinode) head, null);
  }

  @Override
  @Deprecated
  public void addToFront(int value) {
    Dinode newNode = (Dinode) makeNewNodeAtFront(value);
    head = newNode;

    if (size() == 0) {
      tail = newNode;
    } else {
      getNode(0).prev = newNode;
    }

    size++;
  }
}
