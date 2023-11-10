package com.oculux.se284.datastructures.maps.binarytrees;

import com.oculux.se284.Untested;
import com.oculux.se284.datastructures.maps.Map;
import com.oculux.se284.datastructures.maps.NodeNotFoundException;

public class BinarySearchTree implements Map {

  protected enum Branch {
    LEFT,
    RIGHT
  }

  protected class Node {
    int key;
    int value;
    Node left;
    Node right;
    Node parent;

    Node(int key, int value, Node parent) {
      this.key = key;
      this.value = value;
      this.parent = parent;
      size++;
    }

    @Override
    public String toString() {
      String leftString = (left == null) ? "" : left.toString();
      String rightString = (right == null) ? "" : right.toString();
      return String.format("(%s%s%s)", leftString, key, rightString);
    }
  }

  protected Node root = null;
  private int size = 0;

  protected Node createNode(int key, int value, Node parent) {
    return new Node(key, value, parent);
  }

  public void put(int key, int value) {
    if (root == null) {
      root = createNode(key, value, null);
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
          node.left = createNode(key, value, node);
        } else {
          node.right = createNode(key, value, node);
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

    size--;
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
    // Connects the specified node's parent to the child in the same direction (left/right)
    // The child must be the only child of the node or null (if the node has no children)
    if (node.parent == null) {
      root = child;
    } else if (node.parent.left == node) {
      connectNodes(node.parent, Branch.LEFT, child);
    } else {
      connectNodes(node.parent, Branch.RIGHT, child);
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

  @Override
  public int size() {
    return size;
  }

  protected Node getNode(int key) throws NodeNotFoundException {
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

  protected void connectNodes(Node parent, Branch connectionDirection, Node child) {
    if (parent == null) {
      root = child;
      return;
    }

    if (connectionDirection == Branch.LEFT) {
      parent.left = child;
    } else {
      parent.right = child;
    }

    if (child != null) {
      child.parent = parent;
    }
  }

  @Override
  public String toString() {
    if (root == null) {
      return "()";
    }

    return root.toString();
  }
}
