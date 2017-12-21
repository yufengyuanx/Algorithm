package recursionII;

import tools.TreeNode;

public class MaxDiffNode {
  
  public TreeNode maxDiffNode(TreeNode root) {
    if (root == null) {
      return null;
    }
    
    TreeNode[] maxNode = new TreeNode[1];
    int[] diff = new int[1];
    diff[0] = -1;
    numNode(root, maxNode, diff);
    return maxNode[0];
    
  }
  
  private int numNode(TreeNode root, TreeNode[] maxNode, int[] diff) {
    // base case
    if (root == null) {
      return 0;
    }
    
    int left = numNode(root.left, maxNode, diff);
    int right = numNode(root.right, maxNode, diff);
    
    int curDiff = Math.abs(left - right);
    diff[0] = curDiff > diff[0] ? curDiff : diff[0];
    maxNode[0] = root;
    
    return left + right + 1;
    
  }

}
