/**
 * LeetCode 53: Maximum Subarray
 * 
 * Problem: Given an integer array nums, find the contiguous subarray 
 * (containing at least one number) which has the largest sum and return its sum.
 * 
 * Approach: Kadane's Algorithm - keep track of current sum and maximum sum.
 * At each position, decide whether to extend the current subarray or start a new one.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currentSum = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            // Either extend the current subarray or start a new one
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        
        return maxSum;
    }
    
    // Test method
    public static void main(String[] args) {
        MaximumSubarray solution = new MaximumSubarray();
        
        // Test case 1: [-2,1,-3,4,-1,2,1,-5,4]
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Test 1: " + solution.maxSubArray(nums1)); // Expected: 6
        
        // Test case 2: [1]
        int[] nums2 = {1};
        System.out.println("Test 2: " + solution.maxSubArray(nums2)); // Expected: 1
        
        // Test case 3: [5,4,-1,7,8]
        int[] nums3 = {5, 4, -1, 7, 8};
        System.out.println("Test 3: " + solution.maxSubArray(nums3)); // Expected: 23
    }
}
