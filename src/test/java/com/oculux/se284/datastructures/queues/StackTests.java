package com.oculux.se284.datastructures.queues;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class StackTests extends QueueTests {

  @Override
  protected Queue createQueue() {
    return new Stack();
  }

  @Test
  public void testAddTwo() {
    Queue stack = createQueue();
    stack.put(6);
    stack.put(7);
    int result = stack.pop();
    assertEquals(7, result);
    result = stack.pop();
    assertEquals(6, result);
  }

  @Test
  public void testAddMany() {
    Queue stack = createQueue();
    for (int i = 0; i < 100; i++) {
      stack.put(i);
    }
    for (int i = 100; i > 0; i--) {
      assertEquals(i, stack.pop());
    }
  }
}
