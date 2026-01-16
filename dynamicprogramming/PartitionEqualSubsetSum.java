/**
 * LeetCode 416: Partition Equal Subset Sum
 * 
 * Problem: Given a non-empty array nums containing only positive integers,
 * find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.
 * 
 * Approach: Subset sum DP.
 * 
 * Time Complexity: O(n * sum)
 * Space Complexity: O(sum)
 */
public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;
        
        if (sum % 2 != 0) return false;
        
        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        
        for (int num : nums) {
            for (int j = target; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }
        
        return dp[target];
    }
    
    // Test method
    public static void main(String[] args) {
        PartitionEqualSubsetSum solution = new PartitionEqualSubsetSum();
        int[] nums1 = {1, 5, 11, 5};
        System.out.println("Test 1: " + solution.canPartition(nums1)); // Expected: true
    }
}
