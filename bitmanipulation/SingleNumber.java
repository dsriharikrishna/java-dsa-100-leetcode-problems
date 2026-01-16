/**
 * LeetCode 136: Single Number
 * 
 * Problem: Given a non-empty array of integers nums, every element appears twice except for one.
 * Find that single one.
 * 
 * Approach: XOR properties - a ^ a = 0, a ^ 0 = a.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }
    
    // Test method
    public static void main(String[] args) {
        SingleNumber solution = new SingleNumber();
        int[] nums1 = {2, 2, 1};
        System.out.println("Test 1: " + solution.singleNumber(nums1)); // Expected: 1
        
        int[] nums2 = {4, 1, 2, 1, 2};
        System.out.println("Test 2: " + solution.singleNumber(nums2)); // Expected: 4
    }
}
