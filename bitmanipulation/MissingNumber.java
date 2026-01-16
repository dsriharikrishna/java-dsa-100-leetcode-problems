/**
 * LeetCode 268: Missing Number
 * 
 * Problem: Given an array nums containing n distinct numbers in the range [0, n],
 * return the only number in the range that is missing from the array.
 * 
 * Approach: XOR-based solution - XOR all indices and values.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int totalXOR = 0, arrayXOR = 0;
        
        for (int i = 0; i <= n; i++) {
            totalXOR ^= i;
        }
        
        for (int num : nums) {
            arrayXOR ^= num;
        }
        
        return totalXOR ^ arrayXOR;
    }
    
    // Test method
    public static void main(String[] args) {
        MissingNumber solution = new MissingNumber();
        
        int[] nums1 = {3, 0, 1};
        System.out.println("Test 1: " + solution.missingNumber(nums1)); // Expected: 2
        
        int[] nums2 = {0, 1};
        System.out.println("Test 2: " + solution.missingNumber(nums2)); // Expected: 2
        
        int[] nums3 = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        System.out.println("Test 3: " + solution.missingNumber(nums3)); // Expected: 8
    }
}
