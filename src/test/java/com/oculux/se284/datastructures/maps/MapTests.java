package com.oculux.se284.datastructures.maps;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;

public abstract class MapTests {

  protected abstract Map createMap();

  @Test
  public void testNotContains() {
    Map map = createMap();
    assertFalse(map.contains(0));
  }

  @Test
  public void testContainsAfterAdd() {
    Map map = createMap();
    map.add(0, 0);
    assertTrue(map.contains(0));
  }

  @Test
  public void testNotContainsAfterRemove() {
    Map map = createMap();
    map.add(0, 0);
    map.remove(0);
    assertFalse(map.contains(0));
  }

  @Test
  public void testGet() {
    Map map = createMap();
    map.add(0, 5);
    assertEquals(5, map.get(0));
  }
}
