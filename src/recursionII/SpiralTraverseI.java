package recursionII;

import java.util.ArrayList;
import java.util.List;

public class SpiralTraverseI {
  // Method 1: Recursive traversal
  public List<Integer> spiral(int[][] matrix) {
    // Assumptions: matrix is N * N, N >= 0, matrix is not null.
    List<Integer> list = new ArrayList<Integer>();
    recursiveTraverse(matrix, 0, matrix.length, list);
    return list;
  }
  
  private void recursiveTraverse(int[][] matrix, int offset, int size, List<Integer> result) {
    // base case when there is only 0 or 1 element left.
    if (size == 0) {
      return;
    }
    if (size == 1) {
      result.add(matrix[offset][offset]);
      return;
    }
    for (int i = 0; i < size - 1; i++) {
      result.add(matrix[offset][offset + i]);
      result.add(matrix[offset + i][offset + size - 1]);
    }
    
    
    for (int i = size - 1; i >= 1; i--) {
      result.add(matrix[offset + size - 1][offset + i]);
      result.add(matrix[offset + i][offset]);
    }
  }
  
  // Method 1: Iterative traversal
  public List<Integer> spiralII(int[][] matrix) {
    List<Integer> list = new ArrayList<>();
    int n = matrix.length;
    int start = 0;
    int end = n - 1;
    
    while (start < end) {
      for (int i = start; i <= end; i++) {
        list.add(matrix[start][i]);
      }
      for (int i = start + 1; i <= end - 1; i++) {
        list.add(matrix[i][end]);
      }
      
      for (int i = end; i >= start; i--) {
        list.add(matrix[end][i]);
      }
      for (int i = end - 1; i >= start + 1; i--) {
        list.add(matrix[i][start]);
      }
      
      start++;
      end--;
    }
    
    if (start == end) {
      list.add(matrix[start][end]);
    }
    return list;
    
  }
  
  
}
