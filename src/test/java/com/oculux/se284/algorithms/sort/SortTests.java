package com.oculux.se284.algorithms.sort;

import com.oculux.se284.datastructures.lists.DynamicArray;
import com.oculux.se284.datastructures.lists.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public abstract class SortTests {

  protected abstract void sort(List list);

  private List createList(int... values) {
    List list = new DynamicArray();
    for (int value : values) {
      list.add(value);
    }
    return list;
  }

  @Test
  public void testAlreadySorted() {
    List list = createList(new int[] {1, 2, 3});
    sort(list);
    assertEquals(1, list.get(0));
    assertEquals(2, list.get(1));
    assertEquals(3, list.get(2));
  }

  @Test
  public void testAntisorted() {
    List list = createList(new int[] {3, 2, 1});
    sort(list);
    assertEquals(1, list.get(0));
    assertEquals(2, list.get(1));
    assertEquals(3, list.get(2));
  }

  @Test
  public void testNegative() {
    List list = createList(new int[] {-5, 2, 1, 4});
    sort(list);
    assertEquals(-5, list.get(0));
    assertEquals(1, list.get(1));
    assertEquals(2, list.get(2));
    assertEquals(4, list.get(3));
  }

  @Test
  public void testDuplicates() {
    List list = createList(new int[] {1, 2, 1, 4});
    sort(list);
    assertEquals(1, list.get(0));
    assertEquals(1, list.get(1));
    assertEquals(2, list.get(2));
    assertEquals(4, list.get(3));
  }

  @Test
  public void testEmpty() {
    List list = createList();
    sort(list);
    assertEquals(0, list.size());
  }
}
