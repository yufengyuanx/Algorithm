package dpIII;

//TODO
public class LargestCrossOfOnes {
  public int largest(int[][] matrix) {
    // Write your solution here.
    if (matrix.length <= 2 || matrix[0].length <= 2) {
      return 0;
    }

    int[][][] dp = new int[4][matrix.length][matrix[0].length];

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (matrix[i][j] == 1) {
          dp[0][i][j] = j > 0 ? dp[0][i][j - 1] + 1 : 1; // left
          dp[1][i][j] = i > 0 ? dp[1][i - 1][j] + 1 : 1; // top
        }
      }
    }

    for (int i = matrix.length - 1; i >= 0; i--) {
      for (int j = matrix[0].length - 1; j >= 0; j--) {
        if (matrix[i][j] == 1) {
          dp[2][i][j] = j < matrix[0].length - 1 ? dp[2][i][j + 1] + 1 : 1; // right
          dp[3][i][j] = i < matrix.length - 1 ? dp[3][i + 1][j] + 1 : 1; // down
        }
      }
    }

    int max = 0;
    for (int i = 1; i < matrix.length - 1; i++) {
      for (int j = 1; j < matrix[0].length - 1; j++) {
        if (matrix[i][j] == 1) {
          int cur = Math.min(dp[0][i][j], dp[1][i][j]);
          cur = Math.min(cur, dp[2][i][j]);
          cur = Math.min(cur, dp[3][i][j]);
          max = Math.max(max, cur);
        }
      }
    }
    return max;
  }

}
