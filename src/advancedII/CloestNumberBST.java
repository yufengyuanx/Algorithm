package advancedII;

import tools.TreeNode;

public class CloestNumberBST {
  public int closest(TreeNode root, int target) {
    // Assumptions: the given binary search tree is not null.
    int result = root.value;
    // The closest number has to be on the path of finding
    // the target value in the binary search tree.
    while (root != null) {
      if (root.value == target) {
        return root.value;
      } else {
        if (Math.abs(root.value - target) < Math.abs(result - target)) {
          result = root.value;
        }
        if (root.value < target) {
          root = root.right;
        } else {
          root = root.left;
        }
      }
    }
    return result;
  }
}
