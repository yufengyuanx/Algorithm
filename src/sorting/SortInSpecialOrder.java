package sorting;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SortInSpecialOrder {
  public int[] sortSpecial(int[] A1, int[] A2) {
    // Write your solution here.
    Map<Integer, Integer> dic = new HashMap<>();
    for (int i = 0; i < A2.length; i++) {
      dic.put(A2[i], i);
    }

    int[] helper = new int[A1.length];
    mergeSort(A1, 0, A1.length - 1, dic, helper);

    return A1;
  }

  private void mergeSort(int[] A1, int left, int right, Map<Integer, Integer> dic, int[] helper) {
    // base case
    if (left >= right) {
      return;
    }
    int mid = left + (right - left) / 2;
    mergeSort(A1, left, mid, dic, helper);
    mergeSort(A1, mid + 1, right, dic, helper);
    merge(A1, left, mid, right, dic, helper);
  }

  private void merge(int[] A1, int left, int mid, int right, Map<Integer, Integer> dic, int[] helper) {
    for (int i = left; i <= right; i++) {
      helper[i] = A1[i];
    }

    int leftIndex = left;
    int rightIndex = mid + 1;
    int index = left;

    while (leftIndex <= mid && rightIndex <= right) {
      // check dic
      // both in dic
      Integer dicl = dic.get(helper[leftIndex]);
      Integer dicr = dic.get(helper[rightIndex]);
      if (dicl != null && dicr != null) {
        if (dicl <= dicr) {
          A1[index++] = helper[leftIndex++];
        } else {
          A1[index++] = helper[rightIndex++];
        }
      } else if (dicl != null) {
        A1[index++] = helper[leftIndex++];
      } else if (dicr != null) {
        A1[index++] = helper[rightIndex++];
      } else {
        if (helper[leftIndex] <= helper[rightIndex]) {
          A1[index++] = helper[leftIndex++];
        } else {
          A1[index++] = helper[rightIndex++];
        }
      }
    }

    while (leftIndex <= mid) {
      A1[index++] = helper[leftIndex++];
    }
  }

  public static void main(String[] args) {
    SortInSpecialOrder test = new SortInSpecialOrder();
    int[] A1 = new int[] { 5, 5, 5, 5, 1, 2, 2, 3, 4, 4, 5 };
    int[] A2 = new int[] { 4, 3, 2 };
    int[] res = test.sortSpecial(A1, A2);
    System.out.println(Arrays.toString(res));
  }
}
