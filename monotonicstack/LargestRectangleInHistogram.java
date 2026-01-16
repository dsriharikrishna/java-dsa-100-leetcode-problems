import java.util.Stack;

/**
 * LeetCode 84: Largest Rectangle in Histogram
 * 
 * Problem: Given an array of integers heights representing the histogram's bar height,
 * find the area of the largest rectangle in the histogram.
 * 
 * Approach: Monotonic increasing stack. For each bar, find left and right boundaries
 * where heights are smaller.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }
        
        while (!stack.isEmpty()) {
            int height = heights[stack.pop()];
            int width = stack.isEmpty() ? heights.length : heights.length - stack.peek() - 1;
            maxArea = Math.max(maxArea, height * width);
        }
        
        return maxArea;
    }
    
    // Test method
    public static void main(String[] args) {
        LargestRectangleInHistogram solution = new LargestRectangleInHistogram();
        
        int[] heights1 = {2, 1, 5, 6, 2, 3};
        System.out.println("Test 1: " + solution.largestRectangleArea(heights1)); // Expected: 10
        
        int[] heights2 = {2, 4};
        System.out.println("Test 2: " + solution.largestRectangleArea(heights2)); // Expected: 4
    }
}
