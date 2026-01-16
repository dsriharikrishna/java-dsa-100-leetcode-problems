/**
 * LeetCode 300: Longest Increasing Subsequence
 * 
 * Problem: Given an integer array nums, return the length of the longest strictly increasing subsequence.
 * 
 * Approach: DP with O(n²) solution.
 * 
 * Time Complexity: O(n²)
 * Space Complexity: O(n)
 */
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int maxLength = 1;
        
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }
        
        return maxLength;
    }
    
    // Test method
    public static void main(String[] args) {
        LongestIncreasingSubsequence solution = new LongestIncreasingSubsequence();
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println("Test 1: " + solution.lengthOfLIS(nums)); // Expected: 4
    }
}
