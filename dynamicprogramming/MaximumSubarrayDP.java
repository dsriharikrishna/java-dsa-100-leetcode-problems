/**
 * LeetCode 53: Maximum Subarray (DP Version)
 * 
 * Problem: Given an integer array nums, find the contiguous subarray
 * which has the largest sum and return its sum.
 * 
 * Approach: Kadane's Algorithm (DP).
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class MaximumSubarrayDP {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currentSum = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        
        return maxSum;
    }
    
    // Test method
    public static void main(String[] args) {
        MaximumSubarrayDP solution = new MaximumSubarrayDP();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Test 1: " + solution.maxSubArray(nums)); // Expected: 6
    }
}
