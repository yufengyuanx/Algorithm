package dpI;

public class LongestAscendingSubArray {
	public int longest(int[] array) {
		// Assumption: the given array is not null.
		if (array.length == 0) {
			return 0;
		}
		// dp[i] = 1				(array[i] <= array[i - 1])
		//       = dp[i - 1] + 1 (array[i] > array[i - 1])
		// So we can make the space consumption more efficient by only
		// recording the latest dp[i]
		int result = 0;
		int cur = 1;
		for (int i = 0; i < array.length; i++) {
			if (i == 0 || array[i] == array[i - 1]) {
				cur++;
				result = Math.max(result, cur);
			} else {
				cur = 1;
			}
		}
		return result;
	}
}
