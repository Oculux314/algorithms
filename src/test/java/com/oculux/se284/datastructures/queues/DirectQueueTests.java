package com.oculux.se284.datastructures.queues;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DirectQueueTests extends QueueTests {

  @Override
  protected <T> Queue<T> createQueue() {
    return new DirectQueue<>();
  }

  @Override
  protected void testAddTwoImplementation() {
    Queue<Integer> queue = createQueue();
    queue.put(6);
    queue.put(7);
    assertEquals(6, queue.pop());
    assertEquals(7, queue.pop());
  }

  @Override
  protected void testAddManyImplementation() {
    Queue<Integer> queue = createQueue();
    for (int i = 0; i < 100; i++) {
      queue.put(i);
    }
    for (int i = 0; i < 100; i++) {
      assertEquals(i, queue.pop());
    }
  }
}
