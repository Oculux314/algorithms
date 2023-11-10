package com.oculux.se284.datastructures.maps.binarytrees;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.oculux.se284.datastructures.maps.Map;
import com.oculux.se284.datastructures.maps.NodeNotFoundException;
import org.junit.Test;

public class RotationTreeTests extends BinarySearchTreeTests {

  private class TestRotationTree extends RotationTree {
    public void rotate(int key) {
      try {
        Node node = getNode(key);
        super.rotate(node);
      } catch (NodeNotFoundException e) {
        fail("Node " + key + " not found");
      }
    }
  }

  @Override
  protected Map createMap() {
    return new TestRotationTree();
  }

  private TestRotationTree createTemplateRotationTree() {
    return (TestRotationTree) createTemplateTree();
  }

  @Test
  public void testNoRotations() {
    TestRotationTree tree = createTemplateRotationTree();
    assertEquals("((((1)2)3(4))5((6)7(8)))", tree.toString());
  }

  @Test
  public void testRotate1() {
    TestRotationTree tree = createTemplateRotationTree();
    tree.rotate(1);
    assertEquals("(((1(2))3(4))5((6)7(8)))", tree.toString());
  }

  @Test
  public void testRotate2() {
    TestRotationTree tree = createTemplateRotationTree();
    tree.rotate(2);
    assertEquals("(((1)2(3(4)))5((6)7(8)))", tree.toString());
  }

  @Test
  public void testRotate3() {
    TestRotationTree tree = createTemplateRotationTree();
    tree.rotate(3);
    assertEquals("(((1)2)3((4)5((6)7(8))))", tree.toString());
  }

  @Test
  public void testRotate4() {
    TestRotationTree tree = createTemplateRotationTree();
    tree.rotate(4);
    assertEquals("(((((1)2)3)4)5((6)7(8)))", tree.toString());
  }

  @Test
  public void testRotate5() {
    TestRotationTree tree = createTemplateRotationTree();
    try {
      tree.rotate(5);
      fail("Should have thrown exception");
    } catch (IllegalArgumentException e) {
      // Expected
    }
  }

  @Test
  public void testRotate6() {
    TestRotationTree tree = createTemplateRotationTree();
    tree.rotate(6);
    assertEquals("((((1)2)3(4))5(6(7(8))))", tree.toString());
  }

  @Test
  public void testRotate7() {
    TestRotationTree tree = createTemplateRotationTree();
    tree.rotate(7);
    assertEquals("(((((1)2)3(4))5(6))7(8))", tree.toString());
  }

  @Test
  public void testRotate8() {
    TestRotationTree tree = createTemplateRotationTree();
    tree.rotate(8);
    assertEquals("((((1)2)3(4))5(((6)7)8))", tree.toString());
  }
}
