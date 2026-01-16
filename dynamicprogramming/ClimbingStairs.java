/**
 * LeetCode 70: Climbing Stairs
 * 
 * Problem: You are climbing a staircase. It takes n steps to reach the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * 
 * Approach: Fibonacci-based DP.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class ClimbingStairs {
    public int climbStairs(int n) {
        if (n <= 2) return n;
        
        int a = 1, b = 2;
        for (int i = 3; i <= n; i++) {
            int c = a + b;
            a = b;
            b = c;
        }
        return b;
    }
    
    // Test method
    public static void main(String[] args) {
        ClimbingStairs solution = new ClimbingStairs();
        System.out.println("Test 1: " + solution.climbStairs(2)); // Expected: 2
        System.out.println("Test 2: " + solution.climbStairs(3)); // Expected: 3
    }
}
