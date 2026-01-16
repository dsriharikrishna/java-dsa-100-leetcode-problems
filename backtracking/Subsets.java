import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 78: Subsets
 * 
 * Problem: Given an integer array nums of unique elements, return all possible subsets (the power set).
 * 
 * Approach: Backtracking.
 * 
 * Time Complexity: O(2^n)
 * Space Complexity: O(n)
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }
    
    private void backtrack(int[] nums, int start, List<Integer> current, List<List<Integer>> result) {
        result.add(new ArrayList<>(current));
        
        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);
            backtrack(nums, i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }
    
    // Test method
    public static void main(String[] args) {
        Subsets solution = new Subsets();
        int[] nums = {1, 2, 3};
        System.out.println("Result: " + solution.subsets(nums));
        // Expected: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
    }
}
