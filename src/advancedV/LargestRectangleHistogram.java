package advancedV;

import java.util.ArrayDeque;
import java.util.Deque;

public class LargestRectangleHistogram {
  public int larget(int[] array) {
    int result = 0;
    // Note that the stack contains the "index"
    // not the "value" of the array.
    Deque<Integer> stack = new ArrayDeque<>();
    
    for (int i = 0; i <= array.length; i++) {
      // we need a way of popping out all the elements in the stack.
      // at last, so that we explicitly add a bar of height 0.
      
      int cur = i == array.length ? 0 : array[i];
      
      while (!stack.isEmpty() && array[stack.peekFirst()] >= cur) {
        int height = array[stack.pollFirst()];
        // determine the left boundary of the largest rectangle.
        // with height array[i].
        int left = stack.isEmpty() ? 0 : stack.peekFirst() + 1;
        // determine the right boundary of the largest rectangle
        // with height of the popped element.
        result = Math.max(result, height * (i - left));
      }
      stack.offerFirst(i);
    }
    return result;
  }
}
