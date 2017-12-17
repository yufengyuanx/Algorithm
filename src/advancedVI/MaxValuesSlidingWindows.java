package advancedVI;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class MaxValuesSlidingWindows {
  public List<Integer> maxWindows(int[] array, int k) {
    // Assumptions: array is not null or not empty,
    // k >= 1 and k <= a.length.
    List<Integer> max = new ArrayList<>();
    // use a descending deque to solve this problem,
    // we store the index instead of the actual value in the deque,
    // and we make sure:
    // 1. the deque only contains index in the current sliding window.
    // 2. for any index, the previous index with smaller value is
    // discarded from the deque.
    Deque<Integer> deque = new LinkedList<>();
    for (int i = 0; i < array.length; i++) {
      // discard any index with smaller value than index i.
      while (!deque.isEmpty() && array[deque.peekLast()] <= array[i]) {
        deque.pollLast();
      }
      // it is possible the head element is out of the current
      // sliding window so we might need to discard it as well.
      if (!deque.isEmpty() && deque.peekFirst() <= i - k) {
        deque.pollFirst();
      }
      deque.offerFirst(i);
      if (i >= k - 1) {
        max.add(array[deque.peekFirst()]);
      }
    }
    return max;
  }
}
