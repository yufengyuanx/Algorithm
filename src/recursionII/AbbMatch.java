package recursionII;

public class AbbMatch {
  public boolean match(String input, String pattern) {
    return match(input, pattern, 0, 0);
  }

  private boolean match(String s, String t, int si, int ti) {
    if (si == s.length() && ti == t.length()) {
      return true;
    }

    if (si >= s.length() || ti >= t.length()) {
      return false;
    }

    if (t.charAt(ti) < '0' || t.charAt(ti) > '9') {
      if (s.charAt(si) == t.charAt(ti)) {
        return match(s, t, si + 1, ti + 1);
      }
      return false;
    }

    int count = 0;
    while (ti < t.length() && t.charAt(ti) >= '0' && t.charAt(ti) <= '9') {
      count = count * 10 + (t.charAt(ti) - '0');
      ti++;
    }
    return match(s, t, si + count, ti);
  }

  public boolean matchI(String input, String pattern) {
    int si = 0;
    int ti = 0;
    while (si < input.length() && ti < pattern.length()) {
      if (pattern.charAt(ti) < '0' || pattern.charAt(ti) > '9') {
        if (input.charAt(si) != pattern.charAt(ti)) {
          return false;
        }
        si++;
        ti++;
      } else {
        int count = 0;
        while (ti < pattern.length() && pattern.charAt(ti) >= '0' && pattern.charAt(ti) <= '9') {
          count = count * 10 + (pattern.charAt(ti) - '0');
          ti++;
        }
        si += count;
      }
    }
    return si == input.length() && ti == pattern.length();
  }

}
