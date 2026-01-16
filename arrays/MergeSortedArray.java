/**
 * LeetCode 88: Merge Sorted Array
 * 
 * Problem: You are given two integer arrays nums1 and nums2, sorted in non-decreasing order,
 * and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 * 
 * Approach: Start from the end of both arrays and fill nums1 from the back.
 * This avoids overwriting elements in nums1.
 * 
 * Time Complexity: O(m + n)
 * Space Complexity: O(1)
 */
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;      // Last element in nums1's initial elements
        int j = n - 1;      // Last element in nums2
        int k = m + n - 1;  // Last position in nums1
        
        // Merge from the back
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
        
        // Copy remaining elements from nums2 (if any)
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
    
    // Test method
    public static void main(String[] args) {
        MergeSortedArray solution = new MergeSortedArray();
        
        // Test case 1
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        solution.merge(nums1, 3, nums2, 3);
        System.out.print("Test 1: ");
        for (int num : nums1) System.out.print(num + " ");
        System.out.println(); // Expected: 1 2 2 3 5 6
    }
}
