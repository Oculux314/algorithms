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
      breakAndConnectNodes(null, null, node);
    } else if (grandparent.left == parent) {
      breakAndConnectNodes(grandparent, Branch.LEFT, node);
    } else {
      breakAndConnectNodes(grandparent, Branch.RIGHT, node);
    }

    if (isClockwiseRotation) {
      breakAndConnectNodes(node, Branch.LEFT, leftTree);
      breakAndConnectNodes(node, Branch.RIGHT, parent);
      breakAndConnectNodes(parent, Branch.LEFT, middleTree);
      breakAndConnectNodes(parent, Branch.RIGHT, rightTree);
    } else {
      breakAndConnectNodes(node, Branch.LEFT, parent);
      breakAndConnectNodes(node, Branch.RIGHT, rightTree);
      breakAndConnectNodes(parent, Branch.LEFT, leftTree);
      breakAndConnectNodes(parent, Branch.RIGHT, middleTree);
    }
  }
}
