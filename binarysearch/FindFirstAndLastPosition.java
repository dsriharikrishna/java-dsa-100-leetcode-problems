/**
 * LeetCode 34: Find First and Last Position of Element in Sorted Array
 * 
 * Problem: Given an array of integers nums sorted in non-decreasing order,
 * find the starting and ending position of a given target value.
 * 
 * Approach: Two binary searches - one for first position, one for last.
 * 
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */
public class FindFirstAndLastPosition {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        
        // Find first position
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            if (nums[mid] == target) {
                result[0] = mid;
            }
        }
        
        // Find last position
        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            if (nums[mid] == target) {
                result[1] = mid;
            }
        }
        
        return result;
    }
    
    // Test method
    public static void main(String[] args) {
        FindFirstAndLastPosition solution = new FindFirstAndLastPosition();
        
        int[] nums = {5, 7, 7, 8, 8, 10};
        int[] result = solution.searchRange(nums, 8);
        System.out.println("Result: [" + result[0] + ", " + result[1] + "]"); // Expected: [3, 4]
    }
}
