package advancedIV;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TwoSum {
  // Method 1: sort the array first, then use two pointers.
  public boolean existSum(int[] array, int target) {
    Arrays.sort(array);
    int left = 0;
    int right = array.length - 1;
    while (left < right) {
      int sum = array[left] + array[right];
      if (sum == target) {
        return true;
      } else if (sum < target) {
        left++;
      } else {
        right--;
      }
    }
    return false;
  }
  
  
  public boolean existSumII(int[] array, int target) {
    Set<Integer> set = new HashSet<Integer>();
    for (int num : array) {
      if (set.contains(target - num)) {
        return true;
      }
      set.add(num);
    }
    return false;
  }
}
