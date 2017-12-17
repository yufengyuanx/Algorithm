package sorting;
/**
 * Move 0s to the right end of the array, no need to keep the relative
 * order of the elements in the original array.
 */
public class MoveZeroI {
	public int[] moveZero(int[] array) {
		if (array == null || array.length <= 1) {
			return array;
		}
		int left = 0;
		int right = array.length - 1;
		while (left <= right) {
			if (array[left] != 0) {
				left++;
			} else if (array[right] == 0) {
				right--;
			} else {
				swap(array, left++, right--);
			}
		}
		return array;
	}
	
	private void swap(int[] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
}
