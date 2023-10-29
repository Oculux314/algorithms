package com.oculux.se284.datastructures.maps.binarytrees;

import com.oculux.se284.datastructures.maps.Map;
import com.oculux.se284.datastructures.maps.MapTests;

public class BinarySearchTreeTests extends MapTests {

  @Override
  protected Map createMap() {
    return new BinarySearchTree();
  }
}
