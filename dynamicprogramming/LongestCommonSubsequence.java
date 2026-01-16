/**
 * LeetCode 1143: Longest Common Subsequence
 * 
 * Problem: Given two strings text1 and text2, return the length of their longest common subsequence.
 * 
 * Approach: 2D DP table.
 * 
 * Time Complexity: O(m * n)
 * Space Complexity: O(m * n)
 */
public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        
        return dp[m][n];
    }
    
    // Test method
    public static void main(String[] args) {
        LongestCommonSubsequence solution = new LongestCommonSubsequence();
        System.out.println("Test 1: " + solution.longestCommonSubsequence("abcde", "ace")); // Expected: 3
    }
}
