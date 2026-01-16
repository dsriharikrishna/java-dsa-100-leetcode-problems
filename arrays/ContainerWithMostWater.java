/**
 * LeetCode 11: Container With Most Water
 * 
 * Problem: Given n non-negative integers representing an elevation map where 
 * the width of each bar is 1, find two lines that together with the x-axis 
 * form a container that contains the most water.
 * 
 * Approach: Use two pointers starting from both ends.
 * Move the pointer with the smaller height inward.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxWater = 0;
        
        while (left < right) {
            // Calculate current area
            int width = right - left;
            int currentHeight = Math.min(height[left], height[right]);
            int currentArea = width * currentHeight;
            
            maxWater = Math.max(maxWater, currentArea);
            
            // Move the pointer with smaller height
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        
        return maxWater;
    }
    
    // Test method
    public static void main(String[] args) {
        ContainerWithMostWater solution = new ContainerWithMostWater();
        
        // Test case 1: [1,8,6,2,5,4,8,3,7]
        int[] height1 = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println("Test 1: " + solution.maxArea(height1)); // Expected: 49
        
        // Test case 2: [1,1]
        int[] height2 = {1, 1};
        System.out.println("Test 2: " + solution.maxArea(height2)); // Expected: 1
    }
}
