/**
 * LeetCode 5: Longest Palindromic Substring (DP Version)
 * 
 * Problem: Given a string s, return the longest palindromic substring in s.
 * 
 * Approach: 2D DP for palindromes.
 * 
 * Time Complexity: O(n²)
 * Space Complexity: O(n²)
 */
public class LongestPalindromicSubstringDP {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new int[n][n];
        int maxLength = 1, start = 0;
        
        for (int i = 0; i < n; i++) dp[i][i] = true;
        
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j) && (len == 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    if (len > maxLength) {
                        maxLength = len;
                        start = i;
                    }
                }
            }
        }
        
        return s.substring(start, start + maxLength);
    }
    
    // Test method
    public static void main(String[] args) {
        LongestPalindromicSubstringDP solution = new LongestPalindromicSubstringDP();
        System.out.println("Test 1: " + solution.longestPalindrome("babad")); // Expected: "bab" or "aba"
    }
}
