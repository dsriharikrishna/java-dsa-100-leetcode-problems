import java.util.Stack;

/**
 * LeetCode 42: Trapping Rain Water
 * 
 * Problem: Given n non-negative integers representing an elevation map,
 * compute how much water it can trap after raining.
 * 
 * Approach: Monotonic decreasing stack. Calculate water trapped between bars.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int water = 0;
        
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int bottom = stack.pop();
                
                if (stack.isEmpty()) break;
                
                int distance = i - stack.peek() - 1;
                int boundedHeight = Math.min(height[i], height[stack.peek()]) - height[bottom];
                water += distance * boundedHeight;
            }
            stack.push(i);
        }
        
        return water;
    }
    
    // Test method
    public static void main(String[] args) {
        TrappingRainWater solution = new TrappingRainWater();
        
        int[] height1 = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println("Test 1: " + solution.trap(height1)); // Expected: 6
        
        int[] height2 = {4, 2, 0, 3, 2, 5};
        System.out.println("Test 2: " + solution.trap(height2)); // Expected: 9
    }
}
