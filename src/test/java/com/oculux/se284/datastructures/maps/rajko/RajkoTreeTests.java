package com.oculux.se284.datastructures.maps.rajko;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Random;

import org.junit.Test;

import com.oculux.se284.datastructures.maps.rajko.AVL.AVLTree;

/**
 * Hacked together just for a sanity check.
 * That's why there's references to 'map'.
 */
public class RajkoTreeTests {

  public static void main(String... args) {
    AVL.main(args);
  }

  private AVLTree createMap() {
    return new AVL().new AVLTree();
  };

  @Test
  public void testContainsEmpty() {
    AVLTree map = createMap();
    assertFalse(map.contains(0));
  }

  @Test
  public void testContainsAfterPut() {
    AVLTree map = createMap();
    map.put(0, 0);
    assertTrue(map.contains(0));
  }

  @Test
  public void testContainsAfterNegativePut() {
    AVLTree map = createMap();
    map.put(-1, 0);
    assertTrue(map.contains(-1));
  }

  @Test
  public void testContainsAfterTwoPuts() {
    AVLTree map = createMap();
    map.put(0, 0);
    map.put(1, 1);
    assertTrue(map.contains(0));
    assertTrue(map.contains(1));
  }

  @Test
  public void testContainsAfterChainedPuts() {
    AVLTree map = createMap();
    map.put(0, 0);
    map.put(1, 1);
    map.put(2, 2);
    assertTrue(map.contains(0));
    assertTrue(map.contains(1));
    assertTrue(map.contains(2));
  }

  @Test
  public void testContainsAfterBranchedPuts() {
    AVLTree map = createMap();
    map.put(1, 0);
    map.put(0, 0);
    map.put(2, 0);
    assertTrue(map.contains(0));
    assertTrue(map.contains(1));
    assertTrue(map.contains(2));
  }

  @Test
  public void testContainsAfterRootRemove() {
    AVLTree map = createMap();
    map.put(0, 0);
    map.put(1, 0);
    map.remove(0);
    assertFalse(map.contains(0));
    assertTrue(map.contains(1));
  }

  @Test
  public void testContainsAfterSimpleRemove() {
    AVLTree map = createMap();
    map.put(0, 0);
    map.put(1, 0);
    map.remove(1);
    assertTrue(map.contains(0));
    assertFalse(map.contains(1));
  }

  @Test
  public void testContainsAfterLeftRemove() {
    AVLTree map = createMap();
    map.put(2, 0);
    map.put(1, 0);
    map.remove(2);
    assertFalse(map.contains(2));
    assertTrue(map.contains(1));
  }

  @Test
  public void testContainsAfterRightRemove() {
    AVLTree map = createMap();
    map.put(0, 0);
    map.put(1, 0);
    map.remove(0);
    assertFalse(map.contains(0));
    assertTrue(map.contains(1));
  }

  @Test
  public void testContainsAfterComplexRemove() {
    AVLTree map = createMap();
    map.put(1, 0);
    map.put(0, 0);
    map.put(2, 0);
    map.remove(1);
    assertFalse(map.contains(1));
    assertTrue(map.contains(0));
    assertTrue(map.contains(2));
  }

  @Test
  public void testContainsAfterComplexRemoveWithChildren() {
    AVLTree map = createMap();
    map.put(1, 0);
    map.put(0, 0);
    map.put(4, 0);
    map.put(2, 0);
    map.put(3, 0);
    map.remove(1);
    assertFalse(map.contains(1));
    assertTrue(map.contains(0));
    assertTrue(map.contains(2));
    assertTrue(map.contains(3));
    assertTrue(map.contains(4));
  }

  @Test
  public void testGet() {
    AVLTree map = createMap();
    map.put(0, 5);
    assertEquals(5, map.get(0));
  }

  @Test
  public void testGetAfterOverwriteRoot() {
    AVLTree map = createMap();
    map.put(0, 5);
    map.put(0, 6);
    assertEquals(6, map.get(0));
  }

  @Test
  public void testGetAfterOverwriteNormal() {
    AVLTree map = createMap();
    map.put(1, 1);
    map.put(0, 5);
    map.put(0, 6);
    assertEquals(6, map.get(0));
  }

  @Test
  public void testSizeEmpty() {
    AVLTree map = createMap();
    assertEquals(0, map.size());
  }

  @Test
  public void testSizeAfterPut() {
    AVLTree map = createMap();
    map.put(0, 0);
    assertEquals(1, map.size());
  }

  @Test
  public void testSizeAfterPutNegative() {
    AVLTree map = createMap();
    map.put(-1, 0);
    assertEquals(1, map.size());
  }

  @Test
  public void testSizeAfterManyPuts() {
    AVLTree map = createMap();
    for (int i = 0; i < 100; i++) {
      map.put(i, i);
    }
    assertEquals(100, map.size());
  }

  @Test
  public void testSizeAfterRemove() {
    AVLTree map = createMap();
    map.put(0, 0);
    map.remove(0);
    assertEquals(0, map.size());
  }

  @Test
  public void testSizeAfterManyRemoves() {
    AVLTree map = createMap();
    for (int i = 0; i < 100; i++) {
      map.put(i, i);
    }
    for (int i = 0; i < 60; i++) {
      map.remove(i);
    }
    assertEquals(40, map.size());
  }

  @Test
  public void testPsuedoRandom() {
    AVLTree map = createMap();
    Random random = new Random(1);

    for (int i = 0; i < 100; i++) {
      int key = random.nextInt(100);
      if (random.nextBoolean()) {
        map.put(key, key);
      } else {
        map.contains(key);
      }
    }

    System.out.println(map.toString());
  }
}
