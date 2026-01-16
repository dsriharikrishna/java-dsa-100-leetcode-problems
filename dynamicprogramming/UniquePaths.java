/**
 * LeetCode 62: Unique Paths
 * 
 * Problem: A robot is located at the top-left corner of a m x n grid.
 * The robot can only move either down or right at any point in time.
 * How many possible unique paths are there?
 * 
 * Approach: 2D DP grid path counting.
 * 
 * Time Complexity: O(m * n)
 * Space Complexity: O(m * n)
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        
        // Initialize first row and column
        for (int i = 0; i < m; i++) dp[i][0] = 1;
        for (int j = 0; j < n; j++) dp[0][j] = 1;
        
        // Fill the DP table
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        
        return dp[m - 1][n - 1];
    }
    
    // Test method
    public static void main(String[] args) {
        UniquePaths solution = new UniquePaths();
        System.out.println("Test 1: " + solution.uniquePaths(3, 7)); // Expected: 28
        System.out.println("Test 2: " + solution.uniquePaths(3, 2)); // Expected: 3
    }
}
