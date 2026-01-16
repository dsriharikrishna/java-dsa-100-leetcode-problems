import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 560: Subarray Sum Equals K
 * 
 * Problem: Given an array of integers nums and an integer k,
 * return the total number of continuous subarrays whose sum equals to k.
 * 
 * Approach: Prefix sum with HashMap. Track cumulative sums and their frequencies.
 * If (currentSum - k) exists in map, we found subarrays.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1); // Base case: sum 0 appears once
        
        int currentSum = 0;
        int count = 0;
        
        for (int num : nums) {
            currentSum += num;
            
            // Check if (currentSum - k) exists
            if (prefixSumCount.containsKey(currentSum - k)) {
                count += prefixSumCount.get(currentSum - k);
            }
            
            // Update prefix sum count
            prefixSumCount.put(currentSum, prefixSumCount.getOrDefault(currentSum, 0) + 1);
        }
        
        return count;
    }
    
    // Test method
    public static void main(String[] args) {
        SubarraySumEqualsK solution = new SubarraySumEqualsK();
        
        int[] nums1 = {1, 1, 1};
        System.out.println("Test 1: " + solution.subarraySum(nums1, 2)); // Expected: 2
        
        int[] nums2 = {1, 2, 3};
        System.out.println("Test 2: " + solution.subarraySum(nums2, 3)); // Expected: 2
    }
}
