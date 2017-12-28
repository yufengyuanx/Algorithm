package binaryTree;

import tools.TreeNode;

public class DeleteInBST {
  public TreeNode delete(TreeNode root, int target) {
    if (root == null) {
      return null;
    }
    // find target node
    if (root.value > target) {
      root.left = delete(root.left, target);
      return root;
    } else if (root.value < target) {
      root.right = delete(root.right, target);
      return root;
    }
    // guarantee root != null && root.value == target
    if (root.left == null) {
      return root.right;
    } else if (root.right == null) {
      return root.left;
    }
    // guarantee root.left != null && root.right != null
    if (root.right.left == null) {
      root.right.left = root.left;
      return root.right;
    }
    // 1. find and delete smallest node in root.right.
    TreeNode smallest = deleteSmallest(root.right);
    // 2. connect the smallest node with root.left and root.right
    smallest.left = root.left;
    smallest.right = root.right;
    // 3. return the smallest node
    return smallest;
  }

  private TreeNode deleteSmallest(TreeNode cur) {
    TreeNode prev = cur;
    cur = cur.left;
    while (cur.left != null) {
      prev = cur;
      cur = cur.left;
    }
    // cur.left == null
    // cur is the smallest one, and prev is its parent
    // Invariance: curr (prev.left) does not have left child
    prev.left = prev.left.right;
    return cur;
  }
}
