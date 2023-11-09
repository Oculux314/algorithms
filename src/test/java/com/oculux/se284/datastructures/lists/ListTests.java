package com.oculux.se284.datastructures.lists;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Random;

import org.junit.Test;

public abstract class ListTests {

  protected abstract <T> List<T> createList();

  private List<Integer> createIndexTestsBaseList() {
    List<Integer> list = createList();
    list.add(1);
    list.add(2);
    list.add(3);
    return list;
  }

  @Test
  public void testInitialise() {
    List<Integer> list = createList();
    assertEquals(list.size(), 0);
  }

  @Test
  public void testSizeAfterAdd() {
    List<Integer> list = createList();
    list.add(1);
    assertEquals(1, list.size());
  }

  @Test
  public void testGetAfterAdd() {
    List<Integer> list = createList();
    list.add(1);
    assertEquals(1, list.get(0));
  }

  @Test
  public void testSet() {
    List<Integer> list = createList();
    list.add(1);
    list.set(0, 2);
    assertEquals(2, list.get(0));
  }

  @Test
  public void testRemove() {
    List<Integer> list = createList();
    list.add(1);
    list.remove();
    assertEquals(0, list.size());
  }

  @Test
  public void testSizeAfterAddMany() {
    List<Integer> list = createList();
    for (int i = 0; i < 100; i++) {
      list.add(i);
    }
    assertEquals(100, list.size());
  }

  @Test
  public void testGetAfterAddMany() {
    List<Integer> list = createList();
    for (int i = 0; i < 100; i++) {
      list.add(i);
    }
    for (int i = 0; i < 100; i++) {
      assertEquals(i, list.get(i));
    }
  }

  @Test
  public void testRemoveAfterAddMany() {
    List<Integer> list = createList();
    for (int i = 0; i < 100; i++) {
      list.add(i);
    }
    for (int i = 0; i < 100; i++) {
      list.remove();
    }
    assertEquals(0, list.size());
  }

  @Test
  public void testPsuedoRandom() {
    List<Integer> list = createList();
    ArrayList<Integer> expected = new ArrayList<>();
    Random random = new Random(1);

    for (int i = 0; i < 100; i++) {
      if (list.size() == 0 || random.nextDouble() < 0.5) {
        list.add(i);
        expected.add(i);
      } else {
        list.remove();
        expected.remove(expected.size() - 1);
      }
    }

    for (int i = 0; i < expected.size(); i++) {
      assertEquals(expected.get(i), list.get(i));
    }
  }

  @Test
  public void testIndexAddSize() {
    List<Integer> list = createIndexTestsBaseList();
    list.add(4, 1);
    assertEquals(4, list.size());
  }

  @Test
  public void testIndexAdd() {
    List<Integer> list = createIndexTestsBaseList();
    list.add(4, 1);
    assertEquals(4, list.get(1));
  }

  @Test
  public void testIndexAddOtherValues() {
    List<Integer> list = createIndexTestsBaseList();
    list.add(4, 1);
    assertEquals(1, list.get(0));
    assertEquals(2, list.get(2));
    assertEquals(3, list.get(3));
  }

  @Test
  public void testIndexAddMany() {
    List<Integer> list = createIndexTestsBaseList();
    list.add(4, 1);
    list.add(5, 1);
    assertEquals(5, list.get(1));
    assertEquals(4, list.get(2));
  }

  @Test
  public void addIndexAtEnd() {
    List<Integer> list = createIndexTestsBaseList();
    list.add(4, 3);
    assertEquals(4, list.get(3));
  }

  @Test
  public void testIndexRemoveSize() {
    List<Integer> list = createIndexTestsBaseList();
    list.remove(1);
    assertEquals(2, list.size());
  }

  @Test
  public void testIndexRemove() {
    List<Integer> list = createIndexTestsBaseList();
    list.remove(1);
    assertEquals(1, list.get(0));
    assertEquals(3, list.get(1));
  }

  @Test
  public void testIndexRemoveMany() {
    List<Integer> list = createIndexTestsBaseList();
    list.remove(1);
    list.remove(1);
    assertEquals(1, list.get(0));
    assertEquals(1, list.size());
  }
}
