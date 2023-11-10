package com.oculux.se284.datastructures.maps.binarytrees;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.oculux.se284.datastructures.maps.Map;
import com.oculux.se284.datastructures.maps.MapTests;
import org.junit.jupiter.api.Test;

public class BinarySearchTreeTests extends MapTests {

  @Override
  protected Map createMap() {
    return new BinarySearchTree();
  }

  protected BinarySearchTree createTemplateTree() {
    BinarySearchTree tree = (BinarySearchTree) createMap();
    tree.put(5, 5);
    tree.put(7, 7);
    tree.put(6, 6);
    tree.put(8, 8);
    tree.put(3, 3);
    tree.put(2, 2);
    tree.put(1, 1);
    tree.put(4, 4);
    return tree;
  }

  @Test
  public void testToString() {
    String string = createTemplateTree().toString();
    assertEquals("((((1)2)3(4))5((6)7(8)))", string);
  }

  @Test
  public void testToStringEmpty() {
    String string = ((BinarySearchTree) createMap()).toString();
    assertEquals("()", string);
  }
}
