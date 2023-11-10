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

  private BinarySearchTree createTemplateTree() {
    BinarySearchTree tree = (BinarySearchTree) createMap();
    tree.put(5, 5);
    tree.put(3, 3);
    tree.put(7, 7);
    tree.put(2, 2);
    tree.put(6, 6);
    tree.put(8, 8);
    return tree;
  }

  @Test
  public void testToString() {
    System.out.println(createTemplateTree().toString());

    String string = createTemplateTree().toString();
    assertEquals("(((2)3)5((6)7(8)))", string);
  }

  @Test
  public void testToStringEmpty() {
    String string = ((BinarySearchTree) createMap()).toString();
    assertEquals("()", string);
  }
}
