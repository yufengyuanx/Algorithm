package advancedIII;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import tools.TreeNode;

public class BinaryTreePathSumToTarget {
  public boolean exist(TreeNode root, int sum) {
    if (root == null) {
      return false;
    }
    // pass down the prefix of the path.
    List<TreeNode> path = new ArrayList<>();
    return helper(root, path, sum);
  }
  
  private boolean helper(TreeNode root, List<TreeNode> path, int sum) {
    path.add(root);
    // check if can find a subpath ended at root node,
    // the sum of the subpath is target.
    int tmp = 0;
    for (int i = path.size() - 1; i >= 0; i--) {
      tmp += path.get(i).value;
      if (tmp == sum) {
        return true;
      }
    }
    
    if (root.left != null && helper(root.left, path, sum)) {
      return true;
    }
    
    if (root.right != null && helper(root.right, path, sum)) {
      return true;
    }
    
    path.remove(path.size() - 1);
    return false;
  }
  
  
  
  // Method 2 : O(n) solution
  public boolean existII(TreeNode root, int sum) {
    if (root == null) {
      return false;
    }
    Set<Integer> prefixSums = new HashSet<>();
    prefixSums.add(0);
    return helperII(root, prefixSums, 0, sum);
  }
  
  private boolean helperII(TreeNode root, Set<Integer> prefixSums, int prevSum, int sum) {
    prevSum += root.value;
    
    // prefixSums store all possible prefixSum from root to current node
    //   1
    //  2
    // 3
    // e.g. prefixSums {0, 1, 3}
    
    // and prevSum = from root to current node (include itself)
    
    // what we do is to check if there is a subpath makes
    // prevSum - one sub path = sum
    
    // e.g. prveSum = 6 now
    // we can find 6 (from 1 to 3)
    // we can find 5 (from 2 to 3)
    // we can find 3 (from 3 to 3)
    
    if (prefixSums.contains(prevSum - sum)) {
      return true;
    }
    
    // here is very interesting
    // e.g. if our prefix sum set is 0, 1, 3
    // and the new node value is 0
    // then the new prevSum will also be 3
    // so we won't add it to set
    // and needRemove will = false;
    // because we can't remove 3.
    
    boolean needRemove = prefixSums.add(prevSum);
    if (root.left != null && helperII(root.left, prefixSums, prevSum, sum)) {
      return true;
    }
    
    if (root.right != null && helperII(root.right, prefixSums, prevSum, sum)) {
      return true;
    }
    
    if (needRemove) {
      prefixSums.remove(prevSum);
    }
    return false;
  }
}
