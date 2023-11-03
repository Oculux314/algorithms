package com.oculux.se284.algorithms.sort;

import com.oculux.se284.datastructures.lists.DynamicArray;
import com.oculux.se284.datastructures.lists.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public abstract class SortTests {

  protected abstract <T extends Comparable<? super T>> void sort(List<T> list);

  @SafeVarargs
  private final <T> List<T> createList(T... values) {
    List<T> list = new DynamicArray<>();
    for (T value : values) {
      list.add(value);
    }
    return list;
  }

  @Test
  public void testAlreadySorted() {
    List<Integer> list = createList(1,2,3);
    sort(list);
    assertEquals(1, list.get(0));
    assertEquals(2, list.get(1));
    assertEquals(3, list.get(2));
  }

  @Test
  public void testAntisorted() {
    List<Integer> list = createList(3, 2, 1);
    sort(list);
    assertEquals(1, list.get(0));
    assertEquals(2, list.get(1));
    assertEquals(3, list.get(2));
  }

  @Test
  public void testNegative() {
    List<Integer> list = createList(-5, 2, 1, 4);
    sort(list);
    assertEquals(-5, list.get(0));
    assertEquals(1, list.get(1));
    assertEquals(2, list.get(2));
    assertEquals(4, list.get(3));
  }

  @Test
  public void testDuplicates() {
    List<Integer> list = createList(1, 2, 1, 4);
    sort(list);
    assertEquals(1, list.get(0));
    assertEquals(1, list.get(1));
    assertEquals(2, list.get(2));
    assertEquals(4, list.get(3));
  }

  @Test
  public void testEmpty() {
    List<Integer> list = createList();
    sort(list);
    assertEquals(0, list.size());
  }
}
