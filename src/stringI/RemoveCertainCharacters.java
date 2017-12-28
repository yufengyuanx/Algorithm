package stringI;

import java.util.HashSet;
import java.util.Set;

public class RemoveCertainCharacters {
  // Assumption: input and t are not null.
  public String remove(String input, String t) {
    // We need to know how to solve this proble with inplace way.
    // Usually we can convert the immutable String to char[].
    char[] array = input.toCharArray();
    // Get set of all distinct charcters in t so that lookip
    // operation will be efficient.
    Set<Character> set = buildSet(t);
    // slow: [0, slow) contains the valid result.
    // fast: [fast, array.lenth) is the area to explore.
    int slow = 0;
    for (int fast = 0; fast < array.length; fast++) {
      // the exploring character can only be put into valid area.
      // if it is not in the set.
      if (!set.contains(array[fast])) {
        array[slow++] = array[fast];
      }
    }
    // Convert the char[] subarray back to String Object.
    return new String(array, 0, slow);
  }

  private Set<Character> buildSet(String t) {
    Set<Character> set = new HashSet<>();
    for (int i = 0; i < t.length(); i++) {
      set.add(t.charAt(i));
    }
    return set;
  }
}
