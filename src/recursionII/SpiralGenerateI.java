package recursionII;

public class SpiralGenerateI {
  // Method 1: Recursive Generate
  public int[][] spiralGenerate(int n) {
    // Assumption: n > 0.
    int[][] matrix = new int[n][n];
    if (n == 0) {
      return matrix;
    }
    recursiveGenerate(matrix, 0, n, 1);
    return matrix;
  }
  
  private void recursiveGenerate(int[][] matrix, int offset, int size, int num) {
    // the base case if when there is only 0 or 1 element left.
    if (size == 0) {
      return;
    }
    if (size == 1) {
      matrix[offset][offset] = num;
      return;
    }
    for (int i = 0; i < size - 1; i++) {
      matrix[offset][offset + i] = num++;
      matrix[offset + i][offset + size - 1] = num++;
      matrix[offset + size - 1][offset + i] = num++;
      matrix[offset + i][offset] = num++;
    }
    recursiveGenerate(matrix, offset + 1, size - 2, num);
  }
  
  // Method 2: Iterative Generate.
  public int[][] spiralGeneateII(int n) {
    int[][] matrix = new int[0][0];
    if (n == 0) {
      return matrix;
    }
    int start = 0;
    int end = n - 1;
    int num = 1;
    
    while (start < end) {
      for (int i = start; i <= end; i++) {
        matrix[start][i] = num++;
      }
      for (int i = start + 1; i <= end; i++) {
        matrix[i][start] = num++;
      }
      for (int i = end; i >= start; i--) {
        matrix[end][i] = num++;
      }
      for (int i = end - 1; i >= start + 1; i--) {
        matrix[i][start] = num++;
      }
      start++;
      end--;
    }
    if (start == end) {
      matrix[start][end] = num++;
    }
    return matrix;
  }
  
}
