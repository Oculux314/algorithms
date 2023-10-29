package com.oculux.se284.datastructures.maps.hashtables;

import com.oculux.se284.datastructures.maps.NodeNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class ChainTable implements HashTable {

  private class Node {
    private int key;
    private int value;

    public Node(int key, int value) {
      this.key = key;
      this.value = value;
    }

    public int getKey() {
      return this.key;
    }

    public int getValue() {
      return this.value;
    }
  }

  private static final int DEFAULT_CAPACITY = 10;
  private List<List<Node>> table;
  private int capacity;

  public ChainTable() {
    this(DEFAULT_CAPACITY);
  }

  public ChainTable(int capacity) {
    this.capacity = capacity;
    table = new ArrayList<List<Node>>(capacity);

    for (int i = 0; i < capacity; i++) {
      table.add(new ArrayList<Node>());
    }
  }

  @Override
  public void put(int key, int value) {
    try {
      Node node = getNode(key);
      node.value = value;
    } catch (NodeNotFoundException e) {
      Node node = new Node(key, value);
      List<Node> chain = getChain(key);
      chain.add(node);
    }
  }

  @Override
  public void remove(int key) {
    try {
      List<Node> chain = getChain(key);
      int index = getChainIndex(chain, key);
      chain.remove(index);
    } catch (NodeNotFoundException e) {
      throw new IllegalArgumentException(e);
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
      Node node = getNode(key);
      return node.getValue();
    } catch (NodeNotFoundException e) {
      throw new IllegalArgumentException(e);
    }
  }

  private List<Node> getChain(int key) {
    if (key < 0) {
      key *= -1;
    }

    int index = Integer.hashCode(key) % capacity;
    return table.get(index);
  }

  private int getChainIndex(List<Node> chain, int key) throws NodeNotFoundException {
    for (int i = 0; i < chain.size(); i++) {
      if (chain.get(i).getKey() == key) {
        return i;
      }
    }
    throw new NodeNotFoundException(key);
  }

  private Node getNode(int key) throws NodeNotFoundException {
    List<Node> chain = getChain(key);
    int index = getChainIndex(chain, key);
    return chain.get(index);
  }
}
