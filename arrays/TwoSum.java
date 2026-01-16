import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 1: Two Sum
 * 
 * Problem: Given an array of integers nums and an integer target, 
 * return indices of the two numbers such that they add up to target.
 * 
 * Approach: Use a HashMap to store value -> index mapping.
 * For each number, check if (target - current number) exists in the map.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(); // Value to index map
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            
            if (map.containsKey(complement)) {
                return new int[] {map.get(complement), i};
            }
            
            map.put(nums[i], i);
        }
        
        return new int[] {}; // No solution found
    }
    
    // Test method
    public static void main(String[] args) {
        TwoSum solution = new TwoSum();
        
        // Test case 1: [2,7,11,15], target = 9
        int[] nums1 = {2, 7, 11, 15};
        int[] result1 = solution.twoSum(nums1, 9);
        System.out.println("Test 1: [" + result1[0] + ", " + result1[1] + "]"); // Expected: [0, 1]
        
        // Test case 2: [3,2,4], target = 6
        int[] nums2 = {3, 2, 4};
        int[] result2 = solution.twoSum(nums2, 6);
        System.out.println("Test 2: [" + result2[0] + ", " + result2[1] + "]"); // Expected: [1, 2]
    }
}
