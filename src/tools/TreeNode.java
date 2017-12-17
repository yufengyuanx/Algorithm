package tools;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
	public int value;
	public TreeNode left;
	public TreeNode right;
	public TreeNode (int value) {
		this.value = value;
	}
	
//	public TreeNode(String data) {
//		return deserialize(data);
//	}
	
	
	public TreeNode deserialize(String data) {
        if (data == "") return null;
        Queue<TreeNode> q = new LinkedList<>();
        String[] values = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        q.add(root);
        for (int i = 1; i < values.length; i++) {
            TreeNode parent = q.poll();
            if (!values[i].equals("n")) {
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                parent.left = left;
                q.add(left);
            }
            if (!values[++i].equals("n")) {
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                parent.right = right;
                q.add(right);
            }
        }
        return root;
    }
}
