/**
 * LeetCode 198: House Robber
 * 
 * Problem: You are a professional robber planning to rob houses along a street.
 * You cannot rob two adjacent houses. Return the maximum amount of money you can rob.
 * 
 * Approach: DP with state transitions.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class HouseRobber {
    public int rob(int[] nums) {
        int prev1 = 0, prev2 = 0;
        
        for (int num : nums) {
            int temp = Math.max(prev1, prev2 + num);
            prev2 = prev1;
            prev1 = temp;
        }
        
        return prev1;
    }
    
    // Test method
    public static void main(String[] args) {
        HouseRobber solution = new HouseRobber();
        int[] nums1 = {1, 2, 3, 1};
        System.out.println("Test 1: " + solution.rob(nums1)); // Expected: 4
        
        int[] nums2 = {2, 7, 9, 3, 1};
        System.out.println("Test 2: " + solution.rob(nums2)); // Expected: 12
    }
}
