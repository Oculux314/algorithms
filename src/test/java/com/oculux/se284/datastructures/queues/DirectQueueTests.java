package com.oculux.se284.datastructures.queues;

public class DirectQueueTests extends QueueTests {

  @Override
  protected Queue createQueue() {
    return new DirectQueue();
  }
}
