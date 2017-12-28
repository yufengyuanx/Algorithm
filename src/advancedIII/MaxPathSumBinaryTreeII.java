package advancedIII;

import tools.TreeNode;

public class MaxPathSumBinaryTreeII {
  public int maxPathSumBinaryTreeII(TreeNode root) {
    int[] globalMax = { Integer.MIN_VALUE };
    helper(root, globalMax);
    return globalMax[0];
  }

  private int helper(TreeNode root, int[] globalMax) {
    // base case
    if (root == null) {
      return 0;
    }

    int left = helper(root.left, globalMax);
    int right = helper(root.right, globalMax);

    // update globalMax
    if (left < 0) {
      left = 0;
    }
    if (right < 0) {
      right = 0;
    }

    int currentSumPath = root.value + left + right;

    globalMax[0] = currentSumPath > globalMax[0] ? currentSumPath : globalMax[0];

    return Math.max(left, right) + root.value;

  }
}
