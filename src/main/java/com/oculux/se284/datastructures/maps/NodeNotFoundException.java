package com.oculux.se284.datastructures.maps;

public class NodeNotFoundException extends Exception {
  public NodeNotFoundException(int key) {
    super("Node with key " + key + " not found");
  }
}
