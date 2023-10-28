package com.oculux.se284.datastructures.trees;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class DisjointSetTests {

  @Test
  public void testEmpty() {
    try {
      DisjointSet set = new DisjointSet(0);
      assert(false);
    } catch (IllegalArgumentException e) {
      assert(true);
    }
  }

  @Test
  public void testNegativeSize() {
    try {
      DisjointSet set = new DisjointSet(-1);
      assert(false);
    } catch (IllegalArgumentException e) {
      assert(true);
    }
  }

  @Test
  public void testSelfFind() {
    DisjointSet set = new DisjointSet(1);
    assertEquals(0, set.find(0));
  }
  
  @Test
  public void testSelfConnected() {
    DisjointSet set = new DisjointSet(1);
    assertTrue(set.isConnected(0, 0));
  }

  @Test
  public void testNotConnected() {
    DisjointSet set = new DisjointSet(2);
    assertFalse(set.isConnected(0, 1));
  }

  @Test
  public void testUnion() {
    DisjointSet set = new DisjointSet(2);
    set.union(0, 1);
    assertTrue(set.isConnected(0, 1));
  }

  @Test
  public void testFindAfterUnion() {
    DisjointSet set = new DisjointSet(2);
    set.union(0, 1);
    assertTrue(set.find(0) == set.find(1));
  }

  @Test
  public void testConnectedAfterUnion() {
    DisjointSet set = new DisjointSet(2);
    set.union(0, 1);
    assertTrue(set.isConnected(0, 1));
  }

  @Test
  public void testUnionReflexive() {
    DisjointSet set = new DisjointSet(2);
    set.union(0, 1);
    assertTrue(set.isConnected(1, 0));
  }

  @Test
  public void testUnionTransitive() {
    DisjointSet set = new DisjointSet(3);
    set.union(0, 1);
    set.union(1, 2);
    assertTrue(set.isConnected(0, 2));
  }
}
