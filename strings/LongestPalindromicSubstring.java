/**
 * LeetCode 5: Longest Palindromic Substring
 * 
 * Problem: Given a string s, return the longest palindromic substring in s.
 * 
 * Approach: Dynamic Programming - build a 2D table to track palindromes.
 * 
 * Time Complexity: O(n²)
 * Space Complexity: O(n²)
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n == 0) return "";
        
        boolean[][] dp = new boolean[n][n];
        int start = 0;
        int maxLength = 1;
        
        // All single characters are palindromes
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        
        // Check for different lengths
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                
                if (s.charAt(i) == s.charAt(j)) {
                    if (len == 2 || dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                        if (len > maxLength) {
                            maxLength = len;
                            start = i;
                        }
                    }
                }
            }
        }
        
        return s.substring(start, start + maxLength);
    }
    
    // Test method
    public static void main(String[] args) {
        LongestPalindromicSubstring solution = new LongestPalindromicSubstring();
        
        System.out.println("Test 1: " + solution.longestPalindrome("babad")); // Expected: "bab" or "aba"
        System.out.println("Test 2: " + solution.longestPalindrome("cbbd")); // Expected: "bb"
    }
}
