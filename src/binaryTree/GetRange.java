package binaryTree;

import java.util.ArrayList;
import java.util.List;

import tools.TreeNode;

public class GetRange {
	public List<Integer> getRange(TreeNode root, int min, int max) {
		List<Integer> list = new ArrayList<Integer>();
		getRange(root, min, max, list);
		return list;
	}
	
	private void getRange(TreeNode root, int min, int max, List<Integer> list) {
		if (root == null) {
			return;
		}
		// 1. determine if left subtree should be traversed, only when root.value > min
		// we should traverse the left subtree.
		if (root.value > min) {
			getRange(root.left, min, max, list);
		}
		// 2. determine if root should be traversed
		if (root.value >= min && root.value <= max) {
			list.add(root.value);
		}
		// 3. determine if right subtree should be traversed, only when
		// root.value < max, we should traverse the right subtree.
		if (root.value < max) {
			getRange(root.right, min, max, list);
		}
	}
}
