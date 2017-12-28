package stringI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommonNumbersII {
  // Assumptions: there could be duplicated elements in the given arrays.
  public List<Integer> commonI(int[] a, int[] b) {
    // Assumption: a, b is not null.
    List<Integer> common = new ArrayList<>();
    int i = 0;
    int j = 0;
    while (i < a.length && j < b.length) {
      if (a[i] == b[i]) {
        common.add(a[i]);
        i++;
        j++;
      } else if (a[i] < b[j]) {
        i++;
      } else {
        j++;
      }
    }
    return common;
  }

  // Method 2: use HashMap.
  public List<Integer> commonII(int[] a, int[] b) {
    List<Integer> common = new ArrayList<>();
    HashMap<Integer, Integer> countA = new HashMap<>();
    for (int num : a) {
      Integer ct = countA.get(num);
      if (ct != null) {
        countA.put(num, ct + 1);
      } else {
        countA.put(num, 1);
      }
    }

    HashMap<Integer, Integer> countB = new HashMap<>();
    for (int num : b) {
      Integer ct = countB.get(num);
      if (ct != null) {
        countB.put(num, ct + 1);
      } else {
        countB.put(num, 1);
      }
    }
    for (Map.Entry<Integer, Integer> entry : countA.entrySet()) {
      Integer ctInB = countB.get(entry.getKey());
      if (ctInB != null) {
        int appear = Math.min(entry.getValue(), ctInB);
        for (int i = 0; i < appear; i++) {
          common.add(entry.getKey());
        }
      }
    }
    return common;
  }
}
