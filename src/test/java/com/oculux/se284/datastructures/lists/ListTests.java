package com.oculux.se284.datastructures.lists;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Random;

import org.junit.Test;

public abstract class ListTests {

  protected abstract List createList();

  @Test
  public void testInitialise() {
    List list = createList();
    assertEquals(list.size(), 0);
  }

  @Test
  public void testSizeAfterAdd() {
    List list = createList();
    list.add(1);
    assertEquals(1, list.size());
  }

  @Test
  public void testGetAfterAdd() {
    List list = createList();
    list.add(1);
    assertEquals(1, list.get(0));
  }

  @Test
  public void testSet() {
    List list = createList();
    list.add(1);
    list.set(0, 2);
    assertEquals(2, list.get(0));
  }

  @Test
  public void testRemove() {
    List list = createList();
    list.add(1);
    list.remove();
    assertEquals(0, list.size());
  }

  @Test
  public void testSizeAfterAddMany() {
    List list = createList();
    for (int i = 0; i < 100; i++) {
      list.add(i);
    }
    assertEquals(100, list.size());
  }

  @Test
  public void testGetAfterAddMany() {
    List list = createList();
    for (int i = 0; i < 100; i++) {
      list.add(i);
    }
    for (int i = 0; i < 100; i++) {
      assertEquals(i, list.get(i));
    }
  }

  @Test
  public void testRemoveAfterAddMany() {
    List list = createList();
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
    List list = createList();
    List expected = new LinkedList();
    Random random = new Random(1);

    for (int i = 0; i < 100; i++) {
      if (list.size() == 0 || random.nextDouble() < 0.5) {
        list.add(i);
        expected.add(i);
      } else {
        list.remove();
        expected.remove();
      }
    }

    for (int i = 0; i < expected.size(); i++) {
      assertEquals(expected.get(i), list.get(i));
    }
  }

}
