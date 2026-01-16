import java.util.Arrays;
import java.util.Stack;

/**
 * LeetCode 503: Next Greater Element II
 * 
 * Problem: Given a circular integer array nums, return the next greater number
 * for every element in nums (circular).
 * 
 * Approach: Monotonic stack with circular array (iterate twice).
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        Stack<Integer> stack = new Stack<>();
        
        // Iterate twice to handle circular nature
        for (int i = 0; i < 2 * n; i++) {
            int num = nums[i % n];
            
            while (!stack.isEmpty() && nums[stack.peek()] < num) {
                result[stack.pop()] = num;
            }
            
            if (i < n) {
                stack.push(i);
            }
        }
        
        return result;
    }
    
    // Test method
    public static void main(String[] args) {
        NextGreaterElementII solution = new NextGreaterElementII();
        
        int[] nums1 = {1, 2, 1};
        int[] result1 = solution.nextGreaterElements(nums1);
        System.out.print("Test 1: ");
        for (int num : result1) System.out.print(num + " ");
        System.out.println(); // Expected: 2 -1 2
        
        int[] nums2 = {1, 2, 3, 4, 3};
        int[] result2 = solution.nextGreaterElements(nums2);
        System.out.print("Test 2: ");
        for (int num : result2) System.out.print(num + " ");
        System.out.println(); // Expected: 2 3 4 -1 4
    }
}
