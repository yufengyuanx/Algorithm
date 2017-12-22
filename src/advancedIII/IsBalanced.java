package advancedIII;

import tools.TreeNode;

public class IsBalanced {
  public boolean isBalanced(TreeNode root) {
    int result = getHeight(root);
    return result > 0 ? true : false;
  }
  
  private int getHeight(TreeNode root) {
    // base case
    if (root == null) {
      return 0;
    }
    
    int left = getHeight(root.left);        // step 1
    int right = getHeight(root.right);
    
    if (left == -1 || right == -1 || Math.abs(left - right) > 1) {  // step 2
      return -1;
    }
    
    return Math.max(left, right) + 1;   // step 3
  }
}


// Time: O(n)
// Space: O(height)