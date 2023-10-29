package com.oculux.se284.datastructures.queues;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public abstract class QueueTests {
  
  protected abstract Queue createQueue();
  
  @Test
  public void testSizeEmpty() {
    Queue queue = createQueue();
    assertEquals(0, queue.size());
  }

  @Test
  public void testSizeOne() {
    Queue queue = createQueue();
    queue.put(1);
    assertEquals(1, queue.size());
  }

  @Test
  public void testSizeDuplicates() {
    Queue queue = createQueue();
    queue.put(1);
    queue.put(1);
    assertEquals(2, queue.size());
  }

  @Test
  public void testSizeMany() {
    Queue queue = createQueue();
    for (int i = 0; i < 100; i++) {
      queue.put(i);
    }
    assertEquals(100, queue.size());
  }
}
