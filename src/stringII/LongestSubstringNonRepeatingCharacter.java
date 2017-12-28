package stringII;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringNonRepeatingCharacter {
  public int longest(String input) {
    // Assumptions: the input string is not null.
    // the distinct set contains all distinct characters
    // in the sliding window of (slow, fast)
    Set<Character> distinct = new HashSet<>();
    int slow = 0;
    int fast = 0;
    int longest = 0;
    while (fast < input.length()) {
      if (distinct.contains(input.charAt(fast))) {
        // if there is duplicate character, we need to move
        // the slow pinter
        distinct.remove(input.charAt(slow++));
      } else {
        // if there is no duplicate character, we can slide
        // fast pointer and we have a new sliding window of
        // (slow, fast) contains all distinct characters.
        distinct.add(input.charAt(fast++));
        longest = Math.max(longest, fast - slow);
      }
    }
    return longest;
  }

  // The above solution requires at most 2n steps. In fact, it could be
  // optimized to require only n steps. Instead of using a set to tell if
  // a character exists or not, we could define a mapping of the characters
  // to its index. Then we can skip the characters immediately when we found
  // a repeated character.
  public int longestI(String input) {
    int res = 0;
    Map<Character, Integer> helper = new HashMap<>();
    for (int i = 0, j = 0; j < input.length(); j++) {
      char curr = input.charAt(j);
      if (helper.containsKey(curr)) {
        i = Math.max(i, helper.get(curr));
      }
      helper.put(curr, j + 1);
      res = Math.max(j - i + 1, res);
    }
    return res;
  }

  // If we know that the charset is rather small, we can replace the Map with an
  // integer array as direct access table.
  // 1. int[26] for letters 'a' - 'z' or 'A' - 'Z'
  // 2. int[128] for ASCII
  // 3. int[256] for extended ASCII
  public int longestII(String input) {
    int res = 0;
    int[] helper = new int[128];
    for (int i = 0, j = 0; j < input.length(); j++) {
      char curr = input.charAt(j);
      i = Math.max(i, helper[curr]);
      helper[curr] = j + 1;
      res = Math.max(j - i + 1, res);
    }
    return res;
  }
}
