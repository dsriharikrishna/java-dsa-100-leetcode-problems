/**
 * LeetCode 718: Maximum Length of Repeated Subarray
 * 
 * Problem: Given two integer arrays nums1 and nums2, return the maximum length of a subarray
 * that appears in both arrays.
 * 
 * Approach: 2D DP for subarray matching.
 * 
 * Time Complexity: O(m * n)
 * Space Complexity: O(m * n)
 */
public class MaximumLengthOfRepeatedSubarray {
    public int findLength(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[][] dp = new int[m + 1][n + 1];
        int maxLength = 0;
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    maxLength = Math.max(maxLength, dp[i][j]);
                }
            }
        }
        
        return maxLength;
    }
    
    // Test method
    public static void main(String[] args) {
        MaximumLengthOfRepeatedSubarray solution = new MaximumLengthOfRepeatedSubarray();
        int[] nums1 = {1, 2, 3, 2, 1};
        int[] nums2 = {3, 2, 1, 4, 7};
        System.out.println("Test 1: " + solution.findLength(nums1, nums2)); // Expected: 3
    }
}
