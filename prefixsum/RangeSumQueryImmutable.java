/**
 * LeetCode 303: Range Sum Query - Immutable
 * 
 * Problem: Given an integer array nums, handle multiple queries to calculate
 * the sum of elements between indices left and right.
 * 
 * Approach: Prefix sum array. Precompute cumulative sums.
 * Range sum = prefixSum[right+1] - prefixSum[left].
 * 
 * Time Complexity: O(1) per query, O(n) preprocessing
 * Space Complexity: O(n)
 */
public class RangeSumQueryImmutable {
    private int[] prefixSum;
    
    public RangeSumQueryImmutable(int[] nums) {
        prefixSum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
    }
    
    public int sumRange(int left, int right) {
        return prefixSum[right + 1] - prefixSum[left];
    }
    
    // Test method
    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        RangeSumQueryImmutable obj = new RangeSumQueryImmutable(nums);
        
        System.out.println("Test 1: " + obj.sumRange(0, 2)); // Expected: 1
        System.out.println("Test 2: " + obj.sumRange(2, 5)); // Expected: -1
        System.out.println("Test 3: " + obj.sumRange(0, 5)); // Expected: -3
    }
}
