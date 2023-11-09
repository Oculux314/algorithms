package com.oculux.se284.datastructures.lists;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class DynamicArrayTests extends ListTests {

  @Override
  protected <T> List<T> createList() {
    return new DynamicArray<>();
  }

  private DynamicArray<Integer> createBaseDynamicArray() {
    DynamicArray<Integer> list = new DynamicArray<>();
    list.add(1);
    list.add(2);
    list.add(3);
    return list;
  }

  @Test
  public void testIndexAddSize() {
    DynamicArray<Integer> list = createBaseDynamicArray();
    list.add(4, 1);
    assertEquals(4, list.size());
  }

  @Test
  public void testIndexAdd() {
    DynamicArray<Integer> list = createBaseDynamicArray();
    list.add(4, 1);
    assertEquals(4, list.get(1));
  }

  @Test
  public void testIndexAddOtherValues() {
    DynamicArray<Integer> list = createBaseDynamicArray();
    list.add(4, 1);
    assertEquals(1, list.get(0));
    assertEquals(2, list.get(2));
    assertEquals(3, list.get(3));
  }

  @Test
  public void testIndexAddMany() {
    DynamicArray<Integer> list = createBaseDynamicArray();
    list.add(4, 1);
    list.add(5, 1);
    assertEquals(5, list.get(1));
    assertEquals(4, list.get(2));
  }

  @Test
  public void testIndexRemoveSize() {
    DynamicArray<Integer> list = createBaseDynamicArray();
    list.remove(1);
    assertEquals(2, list.size());
  }

  @Test
  public void testIndexRemove() {
    DynamicArray<Integer> list = createBaseDynamicArray();
    list.remove(1);
    assertEquals(1, list.get(0));
    assertEquals(3, list.get(1));
  }

  @Test
  public void testIndexRemoveMany() {
    DynamicArray<Integer> list = createBaseDynamicArray();
    list.remove(1);
    list.remove(1);
    assertEquals(1, list.get(0));
    assertEquals(1, list.size());
  }
}
