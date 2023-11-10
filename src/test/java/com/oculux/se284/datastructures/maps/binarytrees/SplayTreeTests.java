package com.oculux.se284.datastructures.maps.binarytrees;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import com.oculux.se284.datastructures.maps.Map;

public class SplayTreeTests extends BinarySearchTreeTests {

  @Override
  protected Map createMap() {
    return new SplayTree();
  }

  private SplayTree createTemplateSplayTree() {
    return (SplayTree) createTemplateTree();
  }

  @Test
  public void testSplay() {
    SplayTree tree = createTemplateSplayTree();
    assertEquals("((1((2)3))4(5((6)7(8))))", tree.toString());
  }

}
