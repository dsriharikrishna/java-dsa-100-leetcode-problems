/**
 * LeetCode 45: Jump Game II
 * 
 * Problem: Given an array of non-negative integers nums, you are initially positioned at the first index.
 * Each element represents your maximum jump length. Return the minimum number of jumps to reach the last index.
 * 
 * Approach: Greedy BFS-like approach. Track current jump range and next jump range.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class JumpGameII {
    public int jump(int[] nums) {
        if (nums.length <= 1) return 0;
        
        int jumps = 0;
        int currentEnd = 0;
        int farthest = 0;
        
        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            
            // Reached end of current jump range
            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;
                
                if (currentEnd >= nums.length - 1) {
                    break;
                }
            }
        }
        
        return jumps;
    }
    
    // Test method
    public static void main(String[] args) {
        JumpGameII solution = new JumpGameII();
        
        int[] nums1 = {2, 3, 1, 1, 4};
        System.out.println("Test 1: " + solution.jump(nums1)); // Expected: 2
        
        int[] nums2 = {2, 3, 0, 1, 4};
        System.out.println("Test 2: " + solution.jump(nums2)); // Expected: 2
    }
}
