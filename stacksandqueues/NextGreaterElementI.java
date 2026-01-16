import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * LeetCode 496: Next Greater Element I
 * 
 * Problem: Find the next greater element for each element in nums1 from nums2.
 * 
 * Approach: Use monotonic stack to find next greater elements in nums2,
 * then map them for nums1.
 * 
 * Time Complexity: O(m + n)
 * Space Complexity: O(n)
 */
public class NextGreaterElementI {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        
        // Find next greater element for each element in nums2
        for (int num : nums2) {
            while (!stack.isEmpty() && stack.peek() < num) {
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }
        
        // Build result for nums1
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.getOrDefault(nums1[i], -1);
        }
        
        return res;
    }
    
    // Test method
    public static void main(String[] args) {
        NextGreaterElementI solution = new NextGreaterElementI();
        
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        int[] result = solution.nextGreaterElement(nums1, nums2);
        
        System.out.print("Result: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
        System.out.println(); // Expected: -1 3 -1
    }
}
