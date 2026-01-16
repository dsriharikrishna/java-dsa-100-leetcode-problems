/**
 * LeetCode 81: Search in Rotated Sorted Array II
 * 
 * Problem: Same as LC 33 but the array may contain duplicates.
 * 
 * Approach: Modified binary search with duplicate handling.
 * 
 * Time Complexity: O(log n) average, O(n) worst case
 * Space Complexity: O(1)
 */
public class SearchInRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                return true;
            }
            
            // Handle duplicates
            if (nums[left] == nums[mid] && nums[right] == nums[mid]) {
                left++;
                right--;
            } else if (nums[left] <= nums[mid]) {
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
        
        return false;
    }
    
    // Test method
    public static void main(String[] args) {
        SearchInRotatedSortedArrayII solution = new SearchInRotatedSortedArrayII();
        
        int[] nums = {2, 5, 6, 0, 0, 1, 2};
        System.out.println("Test 1: " + solution.search(nums, 0)); // Expected: true
        System.out.println("Test 2: " + solution.search(nums, 3)); // Expected: false
    }
}
