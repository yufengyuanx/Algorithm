package advancedIV;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class ThreeSum {
  public List<List<Integer>> allTriples(int[] array, int target) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(array);
    
    for (int i = 0; i < array.length - 2; i++) {
      if (i > 0 && array[i] == array[i - 1]) {
        continue;
      }
      int left = i + 1;
      int right = array.length - 1;
      while (left < right) {
        int temp = array[left] + array[right];
        if (temp + array[i] == target) {
          result.add(Arrays.asList(array[i], array[left], array[right]));
          left++;
          // ignore all possible duplicate j as well
          while (left < right && array[left] == array[left - 1]) {
            left++;
          }
        } else {
          if (temp + array[i] < target) {
            left++;
          } else {
            right--;
          }
        }
      }
    }
    return result;
  }
}
