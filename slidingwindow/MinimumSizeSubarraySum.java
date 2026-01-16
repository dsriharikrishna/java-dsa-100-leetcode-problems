/**
 * LeetCode 209: Minimum Size Subarray Sum
 * 
 * Problem: Given an array of positive integers nums and a positive integer target,
 * return the minimal length of a contiguous subarray of which the sum is >= target.
 * 
 * Approach: Variable-size sliding window. Expand window until sum >= target,
 * then shrink from left to find minimum length.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;
        
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            
            // Shrink window while sum >= target
            while (sum >= target) {
                minLength = Math.min(minLength, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }
        
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
    
    // Test method
    public static void main(String[] args) {
        MinimumSizeSubarraySum solution = new MinimumSizeSubarraySum();
        
        int[] nums1 = {2, 3, 1, 2, 4, 3};
        System.out.println("Test 1: " + solution.minSubArrayLen(7, nums1)); // Expected: 2 ([4,3])
        
        int[] nums2 = {1, 4, 4};
        System.out.println("Test 2: " + solution.minSubArrayLen(4, nums2)); // Expected: 1
        
        int[] nums3 = {1, 1, 1, 1, 1, 1, 1, 1};
        System.out.println("Test 3: " + solution.minSubArrayLen(11, nums3)); // Expected: 0
    }
}
