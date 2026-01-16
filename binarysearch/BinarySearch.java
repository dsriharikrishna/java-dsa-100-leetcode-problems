/**
 * LeetCode 704: Binary Search
 * 
 * Problem: Given an array of integers nums which is sorted in ascending order,
 * and an integer target, write a function to search target in nums.
 * 
 * Approach: Classic binary search.
 * 
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */
public class BinarySearch {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return -1;
    }
    
    // Test method
    public static void main(String[] args) {
        BinarySearch solution = new BinarySearch();
        
        int[] nums = {-1, 0, 3, 5, 9, 12};
        System.out.println("Test 1: " + solution.search(nums, 9));  // Expected: 4
        System.out.println("Test 2: " + solution.search(nums, 2));  // Expected: -1
    }
}
