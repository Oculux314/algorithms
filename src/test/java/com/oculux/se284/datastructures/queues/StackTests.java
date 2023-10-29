package com.oculux.se284.datastructures.queues;

public class StackTests extends QueueTests {

  @Override
  protected Queue createQueue() {
    return new Stack();
  }
}
