package com.oculux.se284.datastructures.maps.binarytrees;

import com.oculux.se284.datastructures.maps.Map;
import com.oculux.se284.datastructures.maps.NodeNotFoundException;

public class BinarySearchTree implements Map {

  private class Node {
    private int key;
    private int value;
    private Node left;
    private Node right;
    private Node parent;

    private Node(int key, int value, Node parent) {
      this.key = key;
      this.value = value;
      this.parent = parent;
    }
  }

  private Node root = null;

  public void put(int key, int value) {
    if (root == null) {
      root = new Node(key, value, null);
      return;
    }

    Node node = root;
    Node next = null;

    while (true) {
      if (node.key == key) {
        node.value = value;
        return;
      }

      next = (key < node.key) ? node.left : node.right;

      if (next == null) {
        if (key < node.key) {
          node.left = new Node(key, value, node);
        } else {
          node.right = new Node(key, value, node);
        }
        return;
      }

      node = next;
    }
  }

  @Override
  public void remove(int key) {
    Node node = null;

    try {
      node = getNode(key);
    } catch (NodeNotFoundException e) {
      throw new IllegalArgumentException(e);
    }

    if (node.left == null && node.right == null) {
      connectParentToChild(node, null);
    } else if (node.left == null) {
      connectParentToChild(node, node.right);
    } else if (node.right == null) {
      connectParentToChild(node, node.left);
    } else {
      Node nextLarger = getNextLarger(node);
      node.key = nextLarger.key;
      node.value = nextLarger.value;
      connectParentToChild(nextLarger, nextLarger.right);
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
      return getNode(key).value;
    } catch (NodeNotFoundException e) {
      throw new IllegalArgumentException(e);
    }
  }

  private Node getNode(int key) throws NodeNotFoundException {
    Node current = root;

    while (current != null) {
      if (key == current.key) {
        return current;
      } else if (key < current.key) {
        current = current.left;
      } else {
        current = current.right;
      }
    }

    throw new NodeNotFoundException(key);
  }

  private Node getNextLarger(Node node) {
    if (node.right != null) {
      return getMinOfSubtree(node.right);
    } else {
      return getNextRightParent(node);
    }
  }

  private Node getMinOfSubtree(Node node) {
    while (node.left != null) {
      node = node.left;
    }
    return node;
  }

  private Node getNextRightParent(Node node) {
    while (node.parent != null && node.parent.left == node) {
      node = node.parent;
    }
    return node.parent;
  }

  private void connectParentToChild(Node node, Node child) {
    // Only call on nodes with at most one child
    if (node.parent == null) {
      root = child;
    } else if (node.parent.left == node) {
      node.parent.left = child;
    } else {
      node.parent.right = child;
    }
  }
}
