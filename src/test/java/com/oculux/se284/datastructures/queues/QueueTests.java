package com.oculux.se284.datastructures.queues;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public abstract class QueueTests {

  protected abstract <T> Queue<T> createQueue();

  @Test
  public void testSizeEmpty() {
    Queue<Integer> queue = createQueue();
    assertEquals(0, queue.size());
  }

  @Test
  public void testSizeOne() {
    Queue<Integer> queue = createQueue();
    queue.put(1);
    assertEquals(1, queue.size());
  }

  @Test
  public void testSizeDuplicates() {
    Queue<Integer> queue = createQueue();
    queue.put(1);
    queue.put(1);
    assertEquals(2, queue.size());
  }

  @Test
  public void testSizeMany() {
    Queue<Integer> queue = createQueue();
    for (int i = 0; i < 100; i++) {
      queue.put(i);
    }
    assertEquals(100, queue.size());
  }

  @Test
  public void testAddOne() {
    Queue<Integer> queue = createQueue();
    queue.put(6);
    assertEquals(6, queue.pop());
  }

  @Test
  public void testPeek() {
    Queue<Integer> queue = createQueue();
    queue.put(6);
    assertEquals(6, queue.peek());
    assertEquals(6, queue.peek());
  }

  @Test
  public void testAddTwo() {
    testAddTwoImplementation();
  }

  protected abstract void testAddTwoImplementation();

  @Test
  public void testAddMany() {
    testAddManyImplementation();
  }

  protected abstract void testAddManyImplementation();
}
