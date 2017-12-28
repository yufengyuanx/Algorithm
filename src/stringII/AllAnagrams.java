package stringII;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllAnagrams {
  // Find all anagrams of String s in String l, return all the starting indices.
  // Assumptions: s, l are not null, s is not empty.
  public List<Integer> allAnagrams(String s, String l) {
    List<Integer> result = new ArrayList<Integer>();
    if (l.length() == 0) {
      return result;
    }
    // when s is longer than l, there is no way any of the substrings of l
    // could be an anagram of s
    if (s.length() > l.length()) {
      return result;
    }
    // This map records for each of the distinct characters in s,
    // how many characters are needed.
    // e.g. s = "abbc", map = {'a': 1, 'b': 2, 'c': 1}
    // when we get an instance of 'a' in 1, we let count of 'a' decremented by 1,
    // and only when the count is from 1 to 0, we have 'a' totally matched.
    Map<Character, Integer> map = countMap(s);
    // Record how many distinct characters have been matched.
    // only when all the distinct characters are matched, A.K.A
    // match == map.size(), we find an anagram.
    int match = 0;
    // we have a sliding window of size s.length(), and since the size is fixed,
    // we only need to record the end index of the sliding window.
    // Also, when move the sliding window by one step from left to right,
    // what we only need to change is:
    // 1. remove the leftmost character at the current sliding window.
    // 2. add the rightmost character at the current sliding window.
    for (int i = 0; i < l.length(); i++) {
      // handle the new added character (rightmost) and the current sliding window.
      char tmp = l.charAt(i);
      Integer count = map.get(tmp);
      if (count != null) {
        // the number of needed count should be --
        // and only when the count is from 1 to 0, we find an additional
        // match of distinct character.
        map.put(tmp, count - 1);
        if (count == 1) {
          match++;
        }
      }
      // handle the left most character at the previous sliding window.
      if (i >= s.length()) {
        tmp = l.charAt(i - s.length());
        count = map.get(tmp);
        if (count != null) {
          // the number of needed count should be ++.
          // and only when the count is from 0 to 1, we are short for one
          // match of distinct character.
          map.put(tmp, count + 1);
          if (count == 0) {
            match--;
          }
        }
      }
      // for the current sliding window, if all the distinct characters are matched
      // the count all all zero.
      if (match == map.size()) {
        result.add(i - s.length() + 1);
      }
    }
    return result;
  }

  private Map<Character, Integer> countMap(String s) {
    Map<Character, Integer> map = new HashMap<>();
    for (char ch : s.toCharArray()) {
      Integer count = map.get(ch);
      if (count == null) {
        map.put(ch, 1);
      } else {
        map.put(ch, count + 1);
      }
    }
    return map;
  }

  public List<Integer> findAnagrams(String l, String s) {
    List<Integer> result = new ArrayList<>();
    int[] hash = new int[256];
    for (char ch : s.toCharArray()) {
      hash[ch]++;
    }
    int count = s.length();
    int left = 0;
    int right = 0;

    while (right < l.length()) {
      // move right every time, if the character exists in p's hash, decrease the
      // count
      // current hash value >= 1 means the character is existing in p
      if (hash[l.charAt(right++)]-- >= 1)
        count--;
      // when the count is down to 0, means we found the right anagram
      // then add window's left to result list
      if (count == 0)
        result.add(left);
      // if we find the window's size equals to p, then we have to move left (narrow
      // the window) to find the new match window
      // ++ to reset the hash because we kicked out the left
      // only increase the count if the character is in p
      // the count >= 0 indicate it was original in the hash, cuz it won't go below 0
      if (right - left == s.length() && hash[l.charAt(left++)]++ >= 0)
        count++;
    }
    return result;
  }
}
