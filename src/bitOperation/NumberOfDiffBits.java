package bitOperation;

public class NumberOfDiffBits {
  public int diffBits(int a, int b) {
    // after exclusive or, and the bits where a and b
    // are different will be 1.
    
    a ^= b;
    int count = 0;
    // In Java, notice that we are using logical right shift >>>.
    // a != 0 as the terminate condition.
    while (a != 0) {
      count += a & 1;
      a >>>= 1;
    }
    return count;
  }
}
