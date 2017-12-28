package recursionI;

public class FirstOccurrence {
  public int firstOccur(int[] array, int target) {
    if (array == null || array.length == 0) {
      return -1;
    }
    int left = 0;
    int right = array.length - 1;
    // We need to use left < right -1 here to make sure there is no infinite loop.
    // Think about the case when left == right - 1,
    // then mid == left, it will be possible picking [mid, right] for the next round
    // and it will go into an infinite loop in that case.
    while (left < right - 1) {
      int mid = left + (right - left) / 2;
      if (array[mid] >= target) {
        right = mid;
      } else {
        left = mid;
      }
    }
    // Make sure you understand all the possible situations when entering
    // this post-processing procedure.
    // 1. array has only 1 element.
    // 2. array has only 2 elements.
    // 3. left = right - 1 and left is the result.
    // 4. left = right - 1 and right is the result.
    // 5. left = right - 1 and none of left, right is the result.
    if (array[left] == target) {
      return left;
    } else if (array[right] == target) {
      return right;
    }
    return -1;
  }
}
