package sorting;

/**
 * Selection Sort
 * 
 * Time: O(n^2) Space: O(1)
 * 
 * Stable Sort
 * 
 * Best for almost sorted array
 * 
 * @author yufengyuan
 *
 */

public class SelectionSort {
  public int[] selectionSort(int[] array) {
    // check null before any other things.
    // check other conditions - empty array... etc.
    if (array == null || array.length <= 1) {
      return array;
    }
    for (int i = 0; i < array.length - 1; i++) {
      int min = i;
      // find the min element in the subarray of (i, array.length - 1)
      for (int j = i; j < array.length; j++) {
        if (array[j] < min) {
          min = j;
        }
      }
      swap(array, i, min);
    }
    return array;
  }

  private void swap(int[] array, int left, int right) {
    int temp = array[left];
    array[left] = array[right];
    array[right] = temp;
  }
}
