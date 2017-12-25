package advancedV;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

// Given a dictionary containing many words,
// find the largest product of two words' lengths,
// such that the two words do not share any common characters.
public class LargestLengthProduct {
  public int largestProduct(String[] dict) {
    // Assumptions: dict is not null and has length >= 2,
    // there is no null String in the dict.
    // The words in the dict only use characters 'a' - 'z'.
    // Get the bit mask for each of the word in the dict,
    // the bit mask is represented by the lowest 26 bits of an integer.
    // each of the bit represents one of the characters in 'a' - 'z'.
    HashMap<String, Integer> bitMasks = getBitMasks(dict);
    // sort the dict by length of the words in descending order.
    Arrays.sort(dict, new Comparator<String>() {
      @Override
      public int compare(String s0, String s1) {
        if (s0.length() == s1.length()) {
          return 0;
        }
        return s0.length() < s1.length() ? 1 : -1;
      }
    });
    
    int largest = 0;
    // note the order of constructing all the pairs,
    // we make our best to try largest product.
    for (int i = 1; i < dict.length; i++) {
      for (int j = 0; j < i; j++) {
        // early break if the production is already smaller than
        // current largest one.
        int prod = dict[i].length() * dict[j].length();
        if (prod <= largest) {
          break;
        }
        int iMask = bitMasks.get(dict[i]);
        int jMask = bitMasks.get(dict[j]);
        // if two words do not share any common characters,
        // the bit masks "and" result should be 0 since
        // there is not any position such that in the two bit masks
        // they are all 1.
        if ((iMask & jMask) == 0) {
          largest = prod;
        }
      }
    }
    return largest;
    
  }
  
  private HashMap<String, Integer> getBitMasks(String[] dict) {
    HashMap<String, Integer> map = new HashMap<>();
    for (String str : dict) {
      int bitMask = 0;
      for (int i = 0; i < str.length(); i++) {
        bitMask |= 1 << (str.charAt(i) - 'a');
      }
      map.put(str, bitMask);
    }
    return map;
  }
}
