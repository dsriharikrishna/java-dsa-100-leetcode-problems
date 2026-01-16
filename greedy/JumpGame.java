/**
 * LeetCode 55: Jump Game
 * 
 * Problem: Given an array of non-negative integers nums, you are initially positioned at the first index.
 * Each element represents your maximum jump length. Determine if you can reach the last index.
 * 
 * Approach: Greedy - track the furthest position reachable.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class JumpGame {
    public boolean canJump(int[] nums) {
        int maxReach = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) {
                return false; // Can't reach this position
            }
            maxReach = Math.max(maxReach, i + nums[i]);
            
            if (maxReach >= nums.length - 1) {
                return true; // Can reach the end
            }
        }
        
        return true;
    }
    
    // Test method
    public static void main(String[] args) {
        JumpGame solution = new JumpGame();
        
        int[] nums1 = {2, 3, 1, 1, 4};
        System.out.println("Test 1: " + solution.canJump(nums1)); // Expected: true
        
        int[] nums2 = {3, 2, 1, 0, 4};
        System.out.println("Test 2: " + solution.canJump(nums2)); // Expected: false
    }
}
