package advancedI;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import tools.TreeNode;

public class ZigZagLayerByLayer {
  public List<Integer> zigZag(TreeNode root) {
    if (root == null) {
      return new LinkedList<Integer>();
    }

    Deque<TreeNode> deque = new LinkedList<>();
    List<Integer> list = new LinkedList<>();

    deque.offerFirst(root);
    int layer = 0;

    while (!deque.isEmpty()) {
      int size = deque.size();
      for (int i = 0; i < size; i++) {
        if (layer == 0) {
          // at even layer, from right to left
          TreeNode tmp = deque.pollLast();
          list.add(tmp.value);
          if (tmp.right != null) {
            deque.offerFirst(tmp.right);
          }
          if (tmp.left != null) {
            deque.offerFirst(tmp.left);
          }
        } else {
          // at odd layer, from left to right
          TreeNode tmp = deque.pollFirst();
          list.add(tmp.value);
          if (tmp.right != null) {
            deque.offerLast(tmp.right);
          }
          if (tmp.left != null) {
            deque.offerLast(tmp.left);
          }
        }
      }
      layer = 1 - layer;
    }
    return list;
  }
}
