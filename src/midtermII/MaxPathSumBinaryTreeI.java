package midtermII;

import tools.TreeNode;

public class MaxPathSumBinaryTreeI {
  public int maxPathSum(TreeNode root) {
    // we can wrap a global variable into an array so
    // we can change the value during recursion.
    int[] max = new int[] { Integer.MIN_VALUE };
    maxSumHelper(root, max);
    return max[0];
  }

  // the returned value is the max path sum from
  // root to any leaf node in its subtree.
  private int maxSumHelper(TreeNode root, int[] max) {
    if (root == null) {
      return 0;
    }
    int left = maxSumHelper(root.left, max);
    int right = maxSumHelper(root.right, max);
    // only when root node has both left and right child,
    // we need to possibly update the max path sum
    if (root.left != null && root.right != null) {
      max[0] = Math.max(max[0], left + right + root.value);
      return Math.max(left, right) + root.value;
    }

    if (root.left == null) {
      return right + root.value;
    }
    return left + root.value;
  }
}
