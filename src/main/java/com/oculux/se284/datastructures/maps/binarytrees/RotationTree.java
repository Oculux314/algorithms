package com.oculux.se284.datastructures.maps.binarytrees;

public abstract class RotationTree extends BinarySearchTree {

  protected void rotate(Node node) {
    Node parent = node.parent;
    if (parent == null) {
      throw new IllegalArgumentException("Cannot rotate root node");
    }

    boolean isClockwiseRotation = (parent.left == node);
    Node leftTree, middleTree, rightTree;

    if (isClockwiseRotation) {
      leftTree = node.left;
      middleTree = node.right;
      rightTree = parent.right;
    } else {
      leftTree = parent.left;
      middleTree = node.left;
      rightTree = node.right;
    }

    Node grandparent = parent.parent;
    if (grandparent == null) {
      connectNodes(null, null, node);
    } else if (grandparent.left == parent) {
      connectNodes(grandparent, Branch.LEFT, node);
    } else {
      connectNodes(grandparent, Branch.RIGHT, node);
    }

    if (isClockwiseRotation) {
      connectNodes(node, Branch.LEFT, leftTree);
      connectNodes(node, Branch.RIGHT, parent);
      connectNodes(parent, Branch.LEFT, middleTree);
      connectNodes(parent, Branch.RIGHT, rightTree);
    } else {
      connectNodes(node, Branch.LEFT, parent);
      connectNodes(node, Branch.RIGHT, rightTree);
      connectNodes(parent, Branch.LEFT, leftTree);
      connectNodes(parent, Branch.RIGHT, middleTree);
    }
  }
}
