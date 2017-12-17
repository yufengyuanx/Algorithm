package sorting;

import java.util.Random;

public class QuickSort {
	public int[] quickSort(int[] array) {
		// check null first
		if (array == null) {
			return array;
		}
		quickSort(array, 0, array.length - 1);
		return array;
	}
	
	private void quickSort(int[] array, int left, int right) {
		if (left >= right) {
			return;
		}
		// define a pivot and use the pivot to partition the array.
		int pivotIndex = partition(array, left, right);
		// pivot is already at its position, when we do the recursive call on
		// the two partitions, pivot should not be included in ary of them.
		quickSort(array, left, pivotIndex - 1);
		quickSort(array, pivotIndex + 1, right);
	}
	
	private int partition(int[] array, int left, int right) {
		int pivotIndex = getPivotIndex(left, right);
		int pivot = array[pivotIndex];
		// swap the pivot element to the rightmost position first.
		swap(array, pivotIndex, right);
		int leftBound = left;
		int rightBound = right;
		while (leftBound <= rightBound) {
			if (array[leftBound] < pivot) {
				leftBound++;
			} else if (array[rightBound] >= pivot) {
				rightBound--;
			} else {
				swap(array, leftBound++, rightBound--);
			}
		}
		// swap back the pivot element.
		swap(array, leftBound, right);
		return leftBound;
	}
	
	private void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	// this is one of the ways defining the pivot,
	// pick random element in the range of [left, right].
	private int getPivotIndex(int left, int right) {
		Random rand = new Random();
		return left + rand.nextInt(right - left + 1);
	}
}
