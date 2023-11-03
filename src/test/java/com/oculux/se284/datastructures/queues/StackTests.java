package com.oculux.se284.datastructures.queues;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StackTests extends QueueTests {

  @Override
  protected <T> Queue<T> createQueue() {
    return new Stack<>();
  }

  @Override
  protected void testAddTwoImplementation() {
    Queue<Integer> stack = createQueue();
    stack.put(6);
    stack.put(7);
    int result = stack.pop();
    assertEquals(7, result);
    result = stack.pop();
    assertEquals(6, result);
  }

  @Override
  protected void testAddManyImplementation() {
    Queue<Integer> stack = createQueue();
    for (int i = 0; i < 100; i++) {
      stack.put(i);
    }
    for (int i = 99; i >= 0; i--) {
      assertEquals(i, stack.pop());
    }
  }
}
