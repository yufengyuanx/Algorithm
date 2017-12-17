package advancedVI;

public class MajorityNumberI {
  public int majority(int[] array) {
    // Assumptions: array is not null and is not empty.
    // majority number guarantees to exist;
    int candidate = array[0];
    int count = 1;
    for (int i = 1; i < array.length; i++) {
      if (count == 0) {
        count++;
        candidate = array[i];
      } else if (array[i] == candidate) {
        count++;
      } else {
        count--;
      }
    }
    return candidate;
  }
}
