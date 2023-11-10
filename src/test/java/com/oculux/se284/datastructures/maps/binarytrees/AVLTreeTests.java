package com.oculux.se284.datastructures.maps.binarytrees;

import com.oculux.se284.datastructures.maps.Map;

public class AVLTreeTests extends BinarySearchTreeTests {
  
  @Override
  protected Map createMap() {
    return new AVLTree();
  }
}
