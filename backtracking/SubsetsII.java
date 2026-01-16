import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode 90: Subsets II
 * 
 * Problem: Given an integer array nums that may contain duplicates, return all possible subsets.
 * 
 * Approach: Backtracking with duplicate handling.
 * 
 * Time Complexity: O(2^n)
 * Space Complexity: O(n)
 */
public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }
    
    private void backtrack(int[] nums, int start, List<Integer> current, List<List<Integer>> result) {
        result.add(new ArrayList<>(current));
        
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;
            current.add(nums[i]);
            backtrack(nums, i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }
    
    // Test method
    public static void main(String[] args) {
        SubsetsII solution = new SubsetsII();
        int[] nums = {1, 2, 2};
        System.out.println("Result: " + solution.subsetsWithDup(nums));
        // Expected: [[],[1],[1,2],[1,2,2],[2],[2,2]]
    }
}
