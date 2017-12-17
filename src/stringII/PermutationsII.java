package stringII;

import java.util.*;

public class PermutationsII {
	public List<String> permutationsII(String set) {
		List<String> result = new ArrayList<String>();
		if (set == null) {
			return result;
		}
		char[] array = set.toCharArray();
		helper(array, 0, result);
		return result;
	}
	
	// index: at the level of index, we are to determine for the current
	// permutation, which element is positioned at the index
	private void helper(char[] array, int index, List<String> result) {
		if (index == array.length) {
			// base case: when we have determined for all the indices of
			// the current permutation which element to choose.
			result.add(new String(array));
			return;
		}
		// Notice: the rule is just for the current level, if a certain element
		// is picked, we can not pick any of its duplicates.
		// so that we use a set to record all the distinct element.
		Set<Character> used = new HashSet<>();
		for (int i = index; i < array.length; i++) {
			// used.add(array[i]) will return false if the value of array[i]
			// is already in the Set
			if (used.add(array[i])) {
				swap(array, i, index);
				// go for the next level, index + 1
				helper(array, index + 1, result);
				// don't forget to do the clear operation when backtracking.
				swap(array, i, index);
			}
		}
	}
	
	private void swap(char[] array, int i, int j) {
		char temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
