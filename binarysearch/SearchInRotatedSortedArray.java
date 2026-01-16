/**
 * LeetCode 33: Search in Rotated Sorted Array
 * 
 * Problem: There is an integer array nums sorted in ascending order (with distinct values).
 * Prior to being passed to your function, nums is possibly rotated at an unknown pivot index.
 * 
 * Approach: Modified binary search - determine which half is sorted.
 * 
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */
public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                return mid;
            }
            
            // Check which side is sorted
            if (nums[left] <= nums[mid]) {
                // Left side is sorted
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                // Right side is sorted
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        
        return -1;
    }
    
    // Test method
    public static void main(String[] args) {
        SearchInRotatedSortedArray solution = new SearchInRotatedSortedArray();
        
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        System.out.println("Test 1: " + solution.search(nums, 0)); // Expected: 4
        System.out.println("Test 2: " + solution.search(nums, 3)); // Expected: -1
    }
}
