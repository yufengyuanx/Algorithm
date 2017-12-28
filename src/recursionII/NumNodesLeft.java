package recursionII;

public class NumNodesLeft {
  static class TreeNode {
    TreeNode left;
    TreeNode right;
    int value;
    int numNodeLeft;

    public TreeNode(int value) {
      this.value = value;
    }
  }

  public void numNodesLeft(TreeNode root) {
    numNodes(root);
  }

  public int numNodes(TreeNode root) {
    // base case: leaf node return 0
    if (root == null) {
      return 0;
    }

    // what we do in this level
    // record left node
    // but only report both nodes to the parent node

    int left = numNodes(root.left);
    int right = numNodes(root.right);

    root.numNodeLeft = left;

    return left + right + 1;
  }

}
