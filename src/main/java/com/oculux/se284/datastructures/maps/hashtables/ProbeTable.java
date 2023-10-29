package com.oculux.se284.datastructures.maps.hashtables;

import com.oculux.se284.datastructures.maps.NodeNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class ProbeTable implements HashTable {

  private static Node DELETED = new Node(-1, -1);
  private static final int DEFAULT_CAPACITY = 8;
  private List<Node> table;
  private int numElements;

  public ProbeTable() {
    this(DEFAULT_CAPACITY);
  }

  public ProbeTable(int capacity) {
    this.numElements = 0;
    table = makeEmptyTable(capacity);
  }

  @Override
  public void put(int key, int value) {
    try {
      Node node = getNode(key);
      node.value = value;
    } catch (NodeNotFoundException e) {
      createAndAddNode(key, value);
    }
  }

  @Override
  public void remove(int key) {
    int index = getIndex(key, false);

    if (table.get(index) == null) {
      throw new IllegalArgumentException("Key " + key + " not found");
    } else {
      removeNode(index);
    }
  }

  @Override
  public boolean contains(int key) {
    try {
      getNode(key);
      return true;
    } catch (NodeNotFoundException e) {
      return false;
    }
  }

  @Override
  public int get(int key) {
    try {
      return getNode(key).getValue();
    } catch (NodeNotFoundException e) {
      throw new IllegalArgumentException(e);
    }
  }

  private Node getNode(int key) throws NodeNotFoundException {
    int index = getIndex(key, false);
    if (table.get(index) == null) {
      throw new NodeNotFoundException(key);
    } else {
      return table.get(index);
    }
  }

  private int getIndex(int key, boolean treatDeletedLikeEmpty) {
    int index = Integer.hashCode(key) % getCapacity();
    if (index < 0) {
      index += getCapacity();
    }

    // Linear probing
    while (table.get(index) != null && table.get(index).getKey() != key) {
      if (treatDeletedLikeEmpty && table.get(index) == DELETED) {
        return index;
      }
      index = (index + 1) % getCapacity();
    }
    return index;
  }

  @Override
  public int size() {
    return numElements;
  }

  private int getCapacity() {
    return table.size();
  }

  private List<Node> makeEmptyTable(int capacity) {
    List<Node> table = new ArrayList<>(capacity);
    for (int i = 0; i < capacity; i++) {
      table.add(null);
    }
    return table;
  }

  private void addNode(int key, Node node) {
    table.set(getIndex(key, true), node);
  }

  private void createAndAddNode(int key, int value) {
    Node node = new Node(key, value);
    addNode(key, node);
    numElements++;

    if (numElements > getCapacity() * 0.75) {
      resize(getCapacity() * 2);
    }
  }

  private void removeNode(int index) {
    table.set(index, DELETED);
    numElements--;

    if (numElements < getCapacity() * 0.5 && getCapacity() > DEFAULT_CAPACITY) {
      resize(getCapacity() / 2);
    }
  }

  private void resize(int newCapacity) {
    List<Node> oldTable = table;
    table = makeEmptyTable(newCapacity);

    for (Node node : oldTable) {
      if (node != null && node != DELETED) {
        addNode(node.getKey(), node);
      }
    }
  }
}
