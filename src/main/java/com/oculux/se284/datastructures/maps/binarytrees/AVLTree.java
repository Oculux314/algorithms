package com.oculux.se284.datastructures.maps.binarytrees;

public class AVLTree extends RotationTree {
  protected class Node extends BinarySearchTree.Node {
    int height;

    private Node(int key, int value, Node parent) {
      super(key, value, parent);

      if (parent != null) {
        height = parent.height + 1;
      } else {
        height = 0;
      }
    }
  }

  @Override
  protected Node createNode(int key, int value, BinarySearchTree.Node parent) {
    return new Node(key, value, convertNode(parent));
  }

  private Node convertNode(BinarySearchTree.Node node) {
    new RotationTree() {};
    return (Node) node;
  }
}
