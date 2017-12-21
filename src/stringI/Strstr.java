package stringI;

public class Strstr {
  public int strstr(String large, String small) {
    if (small.length() == 0) {
      return 0;
    }
    if (large.length() < small.length()) {
      return -1;
    }

    for (int i = 0; i <= large.length() - small.length(); i++) {
      int j = 0; // We need understand why we need initialize j out of the inner loop
      for (; j < small.length(); j++) {
        if (large.charAt(i + j) != small.charAt(j)) {
          break;
        }
      }
      if (j == small.length()) {
        return i;
      }
    }
    return -1;
  }

  /**
   * KMP
   */

  public int strstrKMP(String large, String small) {
    if (small.isEmpty())
      return 0;
    if (large.length() < small.length())
      return -1;
    int[] table = createTable(small);

    for (int i = 0, matchPos = 0; i < large.length();) {
      System.out.println(i);
      // int matchPos = 0;
      if (large.charAt(i) == small.charAt(matchPos)) {
        if (matchPos == small.length() - 1) {
          return i - matchPos;
        } else {
          i++;
          matchPos++;
        }
      } else {
        if (matchPos == 0) {
          i++;
        } else {
          matchPos = table[matchPos - 1];
        }
      }
      if (matchPos == small.length()) {
        return i - matchPos + 1;
      }
    }
    return -1;
  }

  private int[] createTable(String needle) {
    int[] helper = new int[needle.length()];
    for (int i = 1, j = 0; i < helper.length - 1;) {
      // if needle.charAt(i) == needle.charAt(j) i++, j++
      if (needle.charAt(i) != needle.charAt(j)) {
        if (j == 0) {
          i++; // default 0
        } else {
          j = helper[j - 1];
        }
      } else {
        // if needle.charAt(i) == needle.charAt(j)
        helper[i] = j + 1;
        i++;
        j++;
      }
    }
    return helper;
  }
}
