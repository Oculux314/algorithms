package com.oculux.se284.datastructures.maps;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;

public abstract class MapTests {

  protected abstract Map createMap();

  @Test
  public void testContainsEmpty() {
    Map map = createMap();
    assertFalse(map.contains(0));
  }

  @Test
  public void testContainsAfterPut() {
    Map map = createMap();
    map.put(0, 0);
    assertTrue(map.contains(0));
  }

  @Test
  public void testContainsAfterNegativePut() {
    Map map = createMap();
    map.put(-1, 0);
    assertTrue(map.contains(-1));
  }

  @Test
  public void testContainsAfterTwoPuts() {
    Map map = createMap();
    map.put(0, 0);
    map.put(1, 1);
    assertTrue(map.contains(0));
    assertTrue(map.contains(1));
  }

  @Test
  public void testContainsAfterChainedPuts() {
    Map map = createMap();
    map.put(0, 0);
    map.put(1, 1);
    map.put(2, 2);
    assertTrue(map.contains(0));
    assertTrue(map.contains(1));
    assertTrue(map.contains(2));
  }

  @Test
  public void testContainsAfterBranchedPuts() {
    Map map = createMap();
    map.put(1, 0);
    map.put(0, 0);
    map.put(2, 0);
    assertTrue(map.contains(0));
    assertTrue(map.contains(1));
    assertTrue(map.contains(2));
  }

  @Test
  public void testContainsAfterRootRemove() {
    Map map = createMap();
    map.put(0, 0);
    map.put(1, 0);
    map.remove(0);
    assertFalse(map.contains(0));
    assertTrue(map.contains(1));
  }

  @Test
  public void testContainsAfterSimpleRemove() {
    Map map = createMap();
    map.put(0, 0);
    map.put(1, 0);
    map.remove(1);
    assertTrue(map.contains(0));
    assertFalse(map.contains(1));
  }

  @Test
  public void testContainsAfterLeftRemove() {
    Map map = createMap();
    map.put(2, 0);
    map.put(1, 0);
    map.remove(2);
    assertFalse(map.contains(2));
    assertTrue(map.contains(1));
  }

  @Test
  public void testContainsAfterRightRemove() {
    Map map = createMap();
    map.put(0, 0);
    map.put(1, 0);
    map.remove(0);
    assertFalse(map.contains(0));
    assertTrue(map.contains(1));
  }

  @Test
  public void testContainsAfterComplexRemove() {
    Map map = createMap();
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
    Map map = createMap();
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
    Map map = createMap();
    map.put(0, 5);
    assertEquals(5, map.get(0));
  }

  @Test
  public void testGetAfterOverwriteRoot() {
    Map map = createMap();
    map.put(0, 5);
    map.put(0, 6);
    assertEquals(6, map.get(0));
  }

  @Test
  public void testGetAfterOverwriteNormal() {
    Map map = createMap();
    map.put(1, 1);
    map.put(0, 5);
    map.put(0, 6);
    assertEquals(6, map.get(0));
  }
}
