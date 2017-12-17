package bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import tools.TreeNode;

public class LayerByLayer {
	public List<List<Integer>> layerByLayer(TreeNode root) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		if (root == null) {
			return list;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			// the list storing all the nodes on the current level.
			List<Integer> curLayer = new ArrayList<>();
			// the size of current level.
			int size  = queue.size();
			// traverse all the node on the current level and
			// prepare for the next level.
			for (int i = 0; i < size; i++) {
				TreeNode cur = queue.poll();
				curLayer.add(cur.value);
				if (cur.left != null) {
					queue.offer(cur.left);
				}
				if (cur.right != null) {
					queue.offer(cur.right);
				}	
			}
			list.add(curLayer);
		}
		return list;
	}
	
}
