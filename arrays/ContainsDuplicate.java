import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode 217: Contains Duplicate
 * 
 * Problem: Given an integer array nums, return true if any value appears 
 * at least twice in the array, and return false if every element is distinct.
 * 
 * Approach: Use a HashSet to track seen elements.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        
        return false;
    }
    
    // Test method
    public static void main(String[] args) {
        ContainsDuplicate solution = new ContainsDuplicate();
        
        // Test case 1: [1,2,3,1]
        int[] nums1 = {1, 2, 3, 1};
        System.out.println("Test 1: " + solution.containsDuplicate(nums1)); // Expected: true
        
        // Test case 2: [1,2,3,4]
        int[] nums2 = {1, 2, 3, 4};
        System.out.println("Test 2: " + solution.containsDuplicate(nums2)); // Expected: false
    }
}
