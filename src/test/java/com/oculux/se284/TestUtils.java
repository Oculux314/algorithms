package com.oculux.se284;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import com.oculux.se284.datastructures.lists.List;

public class TestUtils {

  public static void assertListEquals(List x, List y) {
    assertArrayEquals(listToArray(x), listToArray(y));
  }

  private static int[] listToArray(List list) {
    int[] array = new int[list.size()];
    for (int i = 0; i < list.size(); i++) {
      array[i] = list.get(i);
    }
    return array;
  }
}
