package advancedII;

import tools.TreeNode;

public class LargestNumberSmallerBST {
  public int largestSmaller(TreeNode root, int target) {
    // Assumptions: the bianry search tree is not null.
    int result = Integer.MIN_VALUE;
    while (root != null) {
      if (root.value >= target) {
        root = root.left;
      } else {
        // the candidates are all the ndoes on the path of
        // searching for target, which is smaller than target.
        // and notice that, the later searched node has larger
        // value than the earlier searched ones.
        result = root.value;
        root = root.right;
      }
    }
    return result;
  }
}
