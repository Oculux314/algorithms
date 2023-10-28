package com.oculux.se284.algorithms.sort;

import static com.oculux.se284.TestUtils.assertListEquals;

import com.oculux.se284.datastructures.lists.DynamicArray;
import com.oculux.se284.datastructures.lists.List;
import org.junit.Test;

public abstract class SortTest {

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
    assertListEquals(createList(new int[] {1, 2, 3}), list);
  }

  @Test
  public void testAntisorted() {
    List list = createList(new int[] {3, 2, 1});
    sort(list);
    assertListEquals(createList(new int[] {1, 2, 3}), list);
  }

  @Test
  public void testNegative() {
    List list = createList(new int[] {-5, 2, 1, 4});
    sort(list);
    assertListEquals(createList(new int[] {-5, 1, 2, 4}), list);
  }

  @Test
  public void testDuplicates() {
    List list = createList(new int[] {1, 2, 1, 4});
    sort(list);
    assertListEquals(createList(new int[] {1, 1, 2, 4}), list);
  }

  @Test
  public void testEmpty() {
    List list = createList();
    sort(list);
    assertListEquals(createList(), list);
  }
}
