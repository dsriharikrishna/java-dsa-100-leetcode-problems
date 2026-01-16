/**
 * LeetCode 162: Find Peak Element
 * 
 * Problem: A peak element is an element that is strictly greater than its neighbors.
 * Find a peak element and return its index.
 * 
 * Approach: Binary search - move towards the higher neighbor.
 * 
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */
public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] > nums[mid + 1]) {
                // Peak is on the left side (including mid)
                right = mid;
            } else {
                // Peak is on the right side
                left = mid + 1;
            }
        }
        
        return left;
    }
    
    // Test method
    public static void main(String[] args) {
        FindPeakElement solution = new FindPeakElement();
        
        int[] nums1 = {1, 2, 3, 1};
        System.out.println("Test 1: " + solution.findPeakElement(nums1)); // Expected: 2
        
        int[] nums2 = {1, 2, 1, 3, 5, 6, 4};
        System.out.println("Test 2: " + solution.findPeakElement(nums2)); // Expected: 5 or 1
    }
}
