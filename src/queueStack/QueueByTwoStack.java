package queueStack;

import java.util.LinkedList;

public class QueueByTwoStack {
  // we always insert into the in stack.
  private LinkedList<Integer> in;
  // we always remove from the out stack.
  private LinkedList<Integer> out;

  public QueueByTwoStack() {
    in = new LinkedList<Integer>();
    out = new LinkedList<Integer>();
  }

  public Integer poll() {
    // if out stack is empty,
    // need to move the elements from in stack to out stack.
    move();
    return out.isEmpty() ? null : out.pollFirst();
  }

  public void offer(int value) {
    // always push into the in stack.
    in.offerFirst(value);
  }

  public Integer peek() {
    move();
    return out.isEmpty() ? null : out.peekFirst();
  }

  // when out stack is empty, move the elements from
  // in stack to out stack.
  private void move() {
    if (out.isEmpty()) {
      while (!in.isEmpty()) {
        out.offerFirst(in.pollFirst());
      }
    }
  }

  public int size() {
    return in.size() + out.size();
  }

  public boolean isEmpty() {
    return in.size() == 0 && out.size() == 0;
  }

}
