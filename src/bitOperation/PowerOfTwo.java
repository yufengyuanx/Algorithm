package bitOperation;

public class PowerOfTwo {
  // Method 1.
  public boolean isPowerOfTwoI(int number) {
    if (number <= 0) {
      return false;
    }
    
    // ignore all the trailing 0's
    while ((number & 1) == 0) {
      number >>>= 1;
    }
    
    // check if the number is 1 at the end.
    return number == 1;
  }
  
  // Method 1.
  public boolean isPowerOfTwoII(int number) {
    if (number <= 0) {
      return false;
    }
    
    // count the number of 1's.
    int count = 0;
    while (number > 0) {
      count += number & 1;
      number >>>= 1;
    }
    
    return count == 1;
  }
  
  // Method 3
  public boolean isPowerOfTwoIII(int number) {
    return number > 0 && (number & (number - 1)) == 0;
  }
}   
