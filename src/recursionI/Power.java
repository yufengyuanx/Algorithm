package recursionI;

public class Power {
  // Assumption: b >= 0
  public long power(int a, int b) {
    if (b == 0) {
      return 1;
    }
    if (a == 0) {
      return 0;
    }
    long half = power(a, b / 2);
    return b % 2 == 0 ? half * half : half * half * a;
  }
}
