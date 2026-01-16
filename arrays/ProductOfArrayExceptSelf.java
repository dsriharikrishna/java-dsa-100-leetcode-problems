/**
 * LeetCode 238: Product of Array Except Self
 * 
 * Problem: Given an integer array nums, return an array answer such that 
 * answer[i] is equal to the product of all the elements of nums except nums[i].
 * 
 * Approach: Calculate left and right products in a single pass.
 * Use the result array to store left products, then multiply with right products.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1) - excluding the output array
 */
public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        
        // Initialize result array with 1s
        for (int i = 0; i < n; i++) {
            res[i] = 1;
        }
        
        int left = 1, right = 1;
        
        // Calculate products in one pass
        for (int i = 0; i < n; i++) {
            res[i] *= left;
            left *= nums[i];
            
            res[n - 1 - i] *= right;
            right *= nums[n - 1 - i];
        }
        
        return res;
    }
    
    // Test method
    public static void main(String[] args) {
        ProductOfArrayExceptSelf solution = new ProductOfArrayExceptSelf();
        
        // Test case 1: [1,2,3,4]
        int[] nums1 = {1, 2, 3, 4};
        int[] result1 = solution.productExceptSelf(nums1);
        System.out.print("Test 1: ");
        for (int num : result1) System.out.print(num + " ");
        System.out.println(); // Expected: 24 12 8 6
    }
}
