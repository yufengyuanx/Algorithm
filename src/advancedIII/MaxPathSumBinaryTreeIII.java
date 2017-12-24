package advancedIII;

import tools.TreeNode;

public class MaxPathSumBinaryTreeIII {
  public int maxPathSum(TreeNode root) {
    int[] max = new int[] {Integer.MIN_VALUE};
    helper(root, max);
    return max[0];
  }
  
  private int helper(TreeNode root, int[] max) {
    if (root == null) {
      return 0;
    }
    
    int left = helper(root.left, max);
    int right = helper(root.right, max);
    
    int cur = Math.max(Math.max(left, right), 0) + root.value;
    max[0] = Math.max(cur, max[0]);
    
    return cur;
  }
}
