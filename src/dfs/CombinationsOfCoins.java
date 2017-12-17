package dfs;

import java.util.ArrayList;
import java.util.List;

public class CombinationsOfCoins {
	public List<List<Integer>> combinations(int target, int[] coins) {
		// each combination is represented as a List<Integer> cur,
		// and cur.get(i) = the number of coins of coins[i]
		// all the combinations are stored in the result as List of 
		// List<Integer>.
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> cur = new ArrayList<>();
		helper(target, coins, 0, cur, result);
		return result;
	}
	
	// remain: remaining cents we need to complete.
	// coins: all the possible different coins.
	// index: we want to see how many coisn we need for coins[index]
	private void helper(int remain, int[] coins, int index, 
			List<Integer> cur, List<List<Integer>> result) {
		/**
		 * terminate condition:
		 * NOTICE: this can also be done at index == coins.length where all the 
		 * coins have been picked. But a probably better one is at a previous level to reduce the 
		 * number of unnecessary branches in the DFS. 
		 */
		
		if (index == coins.length - 1) {
			if (remain % coins[coins.length - 1] == 0) {
				cur.add(remain / coins[coins.length - 1]);
				result.add(new ArrayList<Integer>(cur));
				cur.remove(cur.size() - 1);
			}
			return;
		}
		// for coins[index], we can pick 0, 1, 2, ..., target / coins[index] coins
		for (int i = 0; i * coins[index] <= remain; i++) {
			cur.add(i);
			helper(remain - i * coins[index], coins, index + 1, cur, result);
			cur.remove(cur.size() - 1);
		}
	}
}
