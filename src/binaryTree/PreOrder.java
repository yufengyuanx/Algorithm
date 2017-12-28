package binaryTree;

import java.util.*;

import tools.TreeNode;

public class PreOrder {
  public List<Integer> preOder(TreeNode root) {
    List<Integer> preorder = new ArrayList<>();
    if (root == null) {
      return preorder;
    }
    Deque<TreeNode> stack = new ArrayDeque<>();
    stack.offerFirst(root);
    while (!stack.isEmpty()) {
      TreeNode cur = stack.pollFirst();
      // the left subtree should be traversed before right subtree
      // since stack is LIFO, we should push right into the stack first,
      // so for the next step the top element of the stack is the left subtree.
      if (cur.right != null) {
        stack.offerFirst(cur.right);
      }
      if (cur.left != null) {
        stack.offerFirst(cur.left);
      }
      preorder.add(cur.value);
    }
    return preorder;

  }

  public List<Integer> preOrderI(TreeNode root) {
    List<Integer> preorder = new ArrayList<>();
    dfs(root, preorder);
    return preorder;
  }

  private void dfs(TreeNode root, List<Integer> preorder) {
    if (root == null) {
      return;
    }
    preorder.add(root.value);
    preOrderI(root.left);
    preOrderI(root.right);
  }
}
