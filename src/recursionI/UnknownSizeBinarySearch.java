package recursionI;

import recursionI.Dictionary;

/**
 * Binary search implementation on an dictionary with unknown size.
 * Assumption:
 * 	1. The dictionary is an unknown sized sorted array, it only provides 
 * 		get(int index) functionality, if the index asked for is out of right
 * 		bound, it will return null;
 * 	2. The elements in the dictionary are all Integers.
 */
public class UnknownSizeBinarySearch {
	public int search(Dictionary dictionary, int target) {
		if (dictionary == null) {
			return -1;
		}
		int left = 0;
		int right = 1;
		// find the right bound for binary search.
		// extends until we are sure the target is within the [left, right] range
		while (dictionary.get(right) != null && dictionary.get(right) < target) {
			// 1. move left to right
			// 2. double right index;
			left = right;
			right = 2 * right;
		}
		return binarySearch(dictionary, target, left, right);
	}
	
	private int binarySearch(Dictionary dict, int target, int left, int right) {
		// classical binary search
		while (left <= right) {
			int mid = left  + (right - left) / 2;
			if (dict.get(mid) == null || dict.get(mid) > target) {
				right = mid - 1;
			} else if (dict.get(mid) < target){
				left = mid + 1;
			} else {
				return mid;
			}
		}
		return -1;
	}
}
