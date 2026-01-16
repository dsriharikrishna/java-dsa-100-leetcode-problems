import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 39: Combination Sum
 * 
 * Problem: Given an array of distinct integers candidates and a target integer target,
 * return a list of all unique combinations of candidates where the chosen numbers sum to target.
 * 
 * Approach: Backtracking with recursion.
 * 
 * Time Complexity: O(2^n)
 * Space Complexity: O(target/min)
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }
    
    private void backtrack(int[] candidates, int target, int start, List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > target) continue;
            current.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i, current, result);
            current.remove(current.size() - 1);
        }
    }
    
    // Test method
    public static void main(String[] args) {
        CombinationSum solution = new CombinationSum();
        int[] candidates = {2, 3, 6, 7};
        System.out.println("Result: " + solution.combinationSum(candidates, 7));
        // Expected: [[2,2,3],[7]]
    }
}
