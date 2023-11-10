package com.oculux.se284.datastructures.maps.binarytrees;

public class AVLTree extends RotationTree {

  protected class Node extends BinarySearchTree.Node {
    int height;

    private Node(int key, int value, Node parent) {
      super(key, value, parent);
      height = 0;
    }

    private int getSubHeight(Branch branch) {
      Node child = (Node) getChild(branch);
      return child == null ? -1 : child.height;
    }

    public int getLeftHeight() {
      return getSubHeight(Branch.LEFT);
    }

    public int getRightHeight() {
      return getSubHeight(Branch.RIGHT);
    }

    public int getBalance() {
      // +ve: right heavy
      // -ve: left heavy
      return getRightHeight() - getLeftHeight();
    }

    public void refreshHeight() {
      height = Math.max(getLeftHeight(), getRightHeight()) + 1;
    }
  }

  @Override
  protected Node createNode(int key, int value, BinarySearchTree.Node parent) {
    return new Node(key, value, (Node) parent);
  }

  @Override
  public void put(int key, int value) {
    if (root == null) {
      root = createNode(key, value, null);
      return;
    }

    Node node = (Node) root;
    Node next = null;

    while (true) {
      if (node.key == key) {
        node.value = value;
        return;
      }

      next = (Node) ((key < node.key) ? node.left : node.right);

      if (next == null) {
        if (key < node.key) {
          node.left = createNode(key, value, node);
          balanceFrom((Node) node.left);
        } else {
          node.right = createNode(key, value, node);
          balanceFrom((Node) node.right);
        }
        return;
      }

      node = next;
    }
  }

  private void balanceFrom(Node node) {
    if (node == null) {
      throw new IllegalArgumentException("Cannot balance null node");
    }

    Node parent = (Node) node.parent;
    if (parent == null) {
      return;
    }

    parent.refreshHeight();
    int balance = parent.getBalance();

    if (-1 <= balance && balance <= 1) {
      // Already balanced
      balanceFrom(parent);
      return;
    }

    // Letters correspond to SE284 slides
    if (balance == 2) { // Right-heavy (slides version)
      Node R = (Node) parent.right;
      if (R.getBalance() >= 0) {
        // Slides case 1
        rotate(R);
        balanceFrom(R);
        return;
      } else {
        // Slides case 2
        Node A = (Node) R.left;
        rotate(A);
        rotate(A);
        balanceFrom(A);
        return;
      }
    } else if (balance == -2) { // Left-heavy
      Node L = (Node) parent.left;
      if (L.getBalance() <= 0) {
        // Slides case 1 (flipped)
        rotate(L);
        balanceFrom(L);
        return;
      } else {
        // Slides case 2 (flipped)
        Node B = (Node) L.right;
        rotate(B);
        rotate(B);
        balanceFrom(B);
        return;
      }
    } else {
      throw new IllegalStateException("Invalid balance: " + balance);
    }
  }
}
