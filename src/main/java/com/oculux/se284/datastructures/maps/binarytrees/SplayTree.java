package com.oculux.se284.datastructures.maps.binarytrees;

import com.oculux.se284.datastructures.maps.NodeNotFoundException;

public class SplayTree extends RotationTree {

  @Override
  public void put(int key, int value) {
    super.put(key, value);
    get(key);
  }

  @Override
  public int get(int key) {
    try {
      Node node = getNode(key);
      splay(node);
      return node.value;
    } catch (NodeNotFoundException e) {
      throw new IllegalArgumentException(e);
    }
  }

  private void splay(Node node) {
    if (node == null) {
      throw new IllegalArgumentException("Cannot splay null node");
    }

    while (true) {
      if (node.parent == null) {
        return;
      } else if (node.parent.parent == null) {
        zig(node);
      } else if (node.getParentDirection() == node.parent.getParentDirection()) {
        zigzig(node);
      } else {
        zigzag(node);
      }
    }
  }

  private void zig(Node node) {
    rotate(node);
  }

  private void zigzig(Node node) {
    rotate(node.parent);
    rotate(node);
  }

  private void zigzag(Node node) {
    rotate(node);
    rotate(node);
  }
}
