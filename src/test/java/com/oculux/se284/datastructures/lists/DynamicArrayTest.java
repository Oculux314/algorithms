package com.oculux.se284.datastructures.lists;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class DynamicArrayTest {

  @Test
  public void testInitialise() {
    DynamicArray array = new DynamicArray();
    assertEquals(array.size(), 0);
  }

  @Test
  public void testSizeAfterAdd() {
    DynamicArray array = new DynamicArray();
    array.add(1);
    assertEquals(1, array.size());
  }

  @Test
  public void testGetAfterAdd() {
    DynamicArray array = new DynamicArray();
    array.add(1);
    assertEquals(1, array.get(0));
  }

  @Test
  public void testSet() {
    DynamicArray array = new DynamicArray();
    array.add(1);
    array.set(0, 2);
    assertEquals(2, array.get(0));
  }

  @Test
  public void testRemove() {
    DynamicArray array = new DynamicArray();
    array.add(1);
    array.remove();
    assertEquals(0, array.size());
  }

  @Test
  public void testSizeAfterAddMany() {
    DynamicArray array = new DynamicArray();
    for (int i = 0; i < 100; i++) {
      array.add(i);
    }
    assertEquals(100, array.size());
  }

  @Test
  public void testGetAfterAddMany() {
    DynamicArray array = new DynamicArray();
    for (int i = 0; i < 100; i++) {
      array.add(i);
    }
    for (int i = 0; i < 100; i++) {
      assertEquals(i, array.get(i));
    }
  }
}
