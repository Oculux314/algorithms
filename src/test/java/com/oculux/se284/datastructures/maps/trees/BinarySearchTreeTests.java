package com.oculux.se284.datastructures.maps.trees;

import com.oculux.se284.datastructures.maps.Map;
import com.oculux.se284.datastructures.maps.MapTests;
import com.oculux.se284.datastructures.maps.binarytrees.BinarySearchTree;

public class BinarySearchTreeTests extends MapTests {

  @Override
  protected Map createMap() {
    return new BinarySearchTree();
  }
}
