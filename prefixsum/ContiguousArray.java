import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 525: Contiguous Array
 * 
 * Problem: Given a binary array nums, return the maximum length of a contiguous
 * subarray with an equal number of 0 and 1.
 * 
 * Approach: Prefix sum with HashMap. Treat 0 as -1, find subarrays with sum 0.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class ContiguousArray {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> sumIndexMap = new HashMap<>();
        sumIndexMap.put(0, -1); // Base case
        
        int sum = 0;
        int maxLength = 0;
        
        for (int i = 0; i < nums.length; i++) {
            // Treat 0 as -1
            sum += (nums[i] == 1) ? 1 : -1;
            
            if (sumIndexMap.containsKey(sum)) {
                maxLength = Math.max(maxLength, i - sumIndexMap.get(sum));
            } else {
                sumIndexMap.put(sum, i);
            }
        }
        
        return maxLength;
    }
    
    // Test method
    public static void main(String[] args) {
        ContiguousArray solution = new ContiguousArray();
        
        int[] nums1 = {0, 1};
        System.out.println("Test 1: " + solution.findMaxLength(nums1)); // Expected: 2
        
        int[] nums2 = {0, 1, 0};
        System.out.println("Test 2: " + solution.findMaxLength(nums2)); // Expected: 2
    }
}
