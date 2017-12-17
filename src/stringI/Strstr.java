package stringI;

public class Strstr {
	public int strstr(String large, String small) {
		if (large == null || small == null) {
			return -1;
		}
		if (large.length() < small.length()) {
			return -1;
		}
		if (small.length() == 0) {
			return 0;
		}
		for (int i = 0; i <= large.length() - small.length(); i++) {
			int j = 0;
			while (j < small.length() && large.charAt(i + j) == small.charAt(j)) {
				j++;
			}
			if (j == small.length()) {
				return i;
			}
		}
		return -1;
	}
}
