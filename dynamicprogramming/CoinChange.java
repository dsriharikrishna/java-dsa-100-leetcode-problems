import java.util.Arrays;

/**
 * LeetCode 322: Coin Change
 * 
 * Problem: You are given an integer array coins representing coins of different denominations
 * and an integer amount representing a total amount of money. Return the fewest number of coins.
 * 
 * Approach: Unbounded knapsack DP.
 * 
 * Time Complexity: O(amount * n)
 * Space Complexity: O(amount)
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        
        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                dp[j] = Math.min(dp[j], dp[j - coin] + 1);
            }
        }
        
        return dp[amount] > amount ? -1 : dp[amount];
    }
    
    // Test method
    public static void main(String[] args) {
        CoinChange solution = new CoinChange();
        int[] coins = {1, 2, 5};
        System.out.println("Test 1: " + solution.coinChange(coins, 11)); // Expected: 3
    }
}
