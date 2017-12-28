package dpII;

public class LargestSubArraySum {
  public int largestSum(int[] array) {
    // Assumptions: array != null && length >= 1.
    // The subarray must contains at least one element.
    int result = array[0];
    int cur = array[0];
    // dp[i] means the largest sum of subarray ending at index i.
    // dp[i] = array[i] if dp[i - 1] <= 0
    // = dp[i-1] + array[i] if dp[i-1] > 0
    // So that we can reduce the space consumption by
    // recording the latest largest sum.
    for (int i = 1; i < array.length; i++) {
      cur = Math.max(cur + array[i], array[i]);
      result = Math.max(result, cur);
    }
    return result;
  }
}
