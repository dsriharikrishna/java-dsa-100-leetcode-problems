/**
 * LeetCode 121: Best Time to Buy and Sell Stock
 * 
 * Problem: You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a 
 * different day in the future to sell that stock.
 * 
 * Approach: Track minimum price seen so far and calculate max profit at each step.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        
        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }
        
        return maxProfit;
    }
    
    // Test method
    public static void main(String[] args) {
        BestTimeToBuyAndSellStock solution = new BestTimeToBuyAndSellStock();
        
        // Test case 1: [7,1,5,3,6,4]
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        System.out.println("Test 1: " + solution.maxProfit(prices1)); // Expected: 5
        
        // Test case 2: [7,6,4,3,1]
        int[] prices2 = {7, 6, 4, 3, 1};
        System.out.println("Test 2: " + solution.maxProfit(prices2)); // Expected: 0
    }
}
