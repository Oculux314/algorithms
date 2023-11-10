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

  @Test
  public void testStagePut1() {
    SplayTree tree = (SplayTree) createMap();
    tree.putStatic(2);
    tree.putStatic(3);
    tree.putStatic(7);
    tree.putStatic(8);
    tree.putStatic(5);
    tree.putStatic(6);

    tree.put(1, 1);
    assertEquals("(1(2(3((5(6))7(8)))))", tree.toString());
  }

  @Test
  public void testStagePut4() {
    SplayTree tree = (SplayTree) createMap();
    tree.putStatic(1);
    tree.putStatic(2);
    tree.putStatic(3);
    tree.putStatic(7);
    tree.putStatic(8);
    tree.putStatic(5);
    tree.putStatic(6);

    tree.put(4, 4);
    assertEquals("((1((2)3))4(5((6)7(8))))", tree.toString());
  }
}
