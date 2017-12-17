package midtermII;

import tools.TreeNode;

public class MaxPerfectTree {
	public int maxPerfectTree(TreeNode root) {
		int[] globalMax = {0};
		helper(root, globalMax);
		return globalMax[0];
	}
	
	private int helper(TreeNode root, int[] globalMax) {
		// base case
		if (root == null) {
			return 0;
		}
		int result = 1 + Math.min(helper(root.left, globalMax),
							helper(root.right, globalMax)) * 2;
		globalMax[0] = Math.max(globalMax[0], result);
		return result;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(2);
		root.left.left.left= new TreeNode(2);
		root.left.left.left.right= new TreeNode(2);
		root.left.left.left.left = new TreeNode(2);
		root.left.left.left.left.left = new TreeNode(2);
		
		
		MaxPerfectTree test = new MaxPerfectTree();
		int result = test.maxPerfectTree(root);
		System.out.println(result);
	}
}
