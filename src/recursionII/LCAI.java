package recursionII;

import tools.TreeNode;

public class LCAI {
  /**
   * return: null - there is no one or two in the subtree. not null - 1. if there
   * is only one node of one/two in the subtree, just return the one/two itself.
   * 2. if there both one/two are in the subtree, return the LCA. a. one is two's
   * descendant, return one. b. two is one's descendant, return two. c. otherwise,
   * return the lowest node with one and two in the two different subtree.
   */
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode one, TreeNode two) {
    // Assumptions: root is not null,
    // one and two guaranteed to be in the tree and not null.
    // if root is one or two, we can ignore the later recursions.
    if (root == null || root == one || root == two) {
      return root;
    }
    TreeNode left = lowestCommonAncestor(root.left, one, two);
    TreeNode right = lowestCommonAncestor(root.right, one, two);
    if (left != null && right != null) {
      return root;
    }
    return left == null ? left : right;
  }

  /**
   * My understand
   * 
   * for each node, tell your parent if you find any of target node if you find
   * two node, return yourself. if you find one of them, return that one. if you
   * find nothing, tell your parent "null" means find nothing.
   * 
   */

}
