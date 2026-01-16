import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode 15: 3Sum
 * 
 * Problem: Given an integer array nums, return all the triplets 
 * [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, 
 * and nums[i] + nums[j] + nums[k] == 0.
 * 
 * Approach: Sort the array, then use two pointers for each fixed element.
 * Skip duplicates to avoid duplicate triplets.
 * 
 * Time Complexity: O(n²)
 * Space Complexity: O(1) - excluding the output list
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        
        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicates for the first element
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            
            int left = i + 1;
            int right = nums.length - 1;
            
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    
                    // Skip duplicates for the second element
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    // Skip duplicates for the third element
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        
        return res;
    }
    
    // Test method
    public static void main(String[] args) {
        ThreeSum solution = new ThreeSum();
        
        // Test case 1: [-1,0,1,2,-1,-4]
        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        System.out.println("Test 1: " + solution.threeSum(nums1)); 
        // Expected: [[-1,-1,2],[-1,0,1]]
    }
}
