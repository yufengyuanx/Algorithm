package advancedI;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import tools.TreeNode;

public class LCAIV {
	public TreeNode loswestCommonAncestor(TreeNode root, List<TreeNode> nodes) {
		// Assumptions: the list of nods is not null or not empty,
		// all the nodes in the list are guaranteed to be in the tree.
		
		Set<TreeNode> set = new HashSet<>(nodes);
		return helper(root, set);
	}
	
	private TreeNode helper(TreeNode root, Set<TreeNode> set) {
		if (root == null) {
			return null;
		}
		if (set.contains(root)) {
			return root;
		}
		
		TreeNode l = helper(root.left, set);
		TreeNode r = helper(root.right, set);
		if (l != null && r != null) {
			return root;
		}
		return l != null ? l : r;
		
	}
}
