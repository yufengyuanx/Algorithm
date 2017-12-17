package advancedI;

import java.util.Arrays;

public class ArrayDeduplicationIII {
	public int[] dedup(int[] array) {
		// Assumption: array is not null
		if (array == null || array.length <= 1) {
			return array;
		}
		int end = 0;
		// use flag to see if there is any duplicates of array[end].
		boolean flag = false;
		for (int i = 1; i < array.length; i++) {
			if (array[i] == array[end]) {
				// if there is duplicate, set flag and do nothing
				flag = true;
			} else if (flag) {
				// if array[i] != array[end], and flag is set,
				// array[end] should not be included in the valid subarray,
				// and we can just replace it with array[i] since next
				// we are going to check if there is any duplicate of array[i].
				array[end] = array[i];
				// reset flag to false since we are processing another element now.
				flag = false;
			} else {
				// if array[i] != array[end] and flag is not set,
				// it means there is no duplicate of array[end] and it should be 
				// included in the valid subarray.
				array[++end] = array[i];
			}
		}
		return Arrays.copyOf(array, flag ? end : end + 1);
	}
	
	
	public int[] dedupII(int[] array) {
		if (array.length <= 1) {
			return array;
		}
		int slow = 0;
		int fast = 0;
		while (fast < array.length) {
			int begin = fast;
			while (fast < array.length && array[fast] == array[begin]) {
				fast++;
			}
			if (fast - begin == 1) {
				array[slow++] = array[begin];
			}
		}
		return Arrays.copyOf(array, slow);
	}
	
}
