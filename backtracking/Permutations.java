import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 46: Permutations
 * 
 * Problem: Given an array nums of distinct integers, return all the possible permutations.
 * 
 * Approach: Backtracking with swapping.
 * 
 * Time Complexity: O(n!)
 * Space Complexity: O(n)
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permuteHelper(nums, 0, result);
        return result;
    }
    
    private void permuteHelper(int[] nums, int start, List<List<Integer>> result) {
        if (start == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int num : nums) {
                list.add(num);
            }
            result.add(list);
            return;
        }
        
        for (int i = start; i < nums.length; i++) {
            swap(nums, start, i);
            permuteHelper(nums, start + 1, result);
            swap(nums, start, i);
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    // Test method
    public static void main(String[] args) {
        Permutations solution = new Permutations();
        int[] nums = {1, 2, 3};
        System.out.println("Result: " + solution.permute(nums));
        // Expected: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
    }
}
