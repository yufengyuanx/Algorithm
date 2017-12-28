package tools;

import java.util.List;

import bfs.LayerByLayer;

public class TreeNode {
  public int value;
  public TreeNode left;
  public TreeNode right;

  public TreeNode(int value) {
    this.value = value;
  }

  public static TreeNode fromLevelOrderSpecial(String[] str) {
    if (str == null || str.length == 0) {
      return null;
    }
    TreeNode root = null;
    return helper(root, str, 0);
  }

  private static TreeNode helper(TreeNode root, String[] str, int index) {
    if (index > str.length - 1) {
      return root;
    }
    char ch = str[index].charAt(0);
    if (ch != '#') {
      root = new TreeNode(ch - '0');
      root.left = helper(root.left, str, index * 2 + 1);
      root.right = helper(root.right, str, index * 2 + 2);
    }
    return root;

  }

  public static void main(String[] args) {
    TreeNode root = TreeNode.fromLevelOrderSpecial(new String[] { "1", "2", "#", "3", "#", "#", "#", "4" });
    // System.out.println(root.left.right.value);

    LayerByLayer test1 = new LayerByLayer();
    List<List<Integer>> res = test1.layerByLayer(root);
    System.out.println(res.toString());

  }
}
