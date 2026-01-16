import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 128: Longest Consecutive Sequence
 * 
 * Problem: Given an unsorted array of integers nums, return the length of the
 * longest consecutive elements sequence.
 * 
 * Approach: Union-Find to group consecutive numbers.
 * Alternative: HashSet approach is simpler for this problem.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class LongestConsecutiveSequence {
    private Map<Integer, Integer> parent;
    private Map<Integer, Integer> size;
    
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        
        parent = new HashMap<>();
        size = new HashMap<>();
        
        // Initialize
        for (int num : nums) {
            if (!parent.containsKey(num)) {
                parent.put(num, num);
                size.put(num, 1);
                
                // Union with num-1 if exists
                if (parent.containsKey(num - 1)) {
                    union(num, num - 1);
                }
                
                // Union with num+1 if exists
                if (parent.containsKey(num + 1)) {
                    union(num, num + 1);
                }
            }
        }
        
        int maxLength = 0;
        for (int s : size.values()) {
            maxLength = Math.max(maxLength, s);
        }
        
        return maxLength;
    }
    
    private int find(int x) {
        if (parent.get(x) != x) {
            parent.put(x, find(parent.get(x)));
        }
        return parent.get(x);
    }
    
    private void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        
        if (rootX != rootY) {
            parent.put(rootX, rootY);
            size.put(rootY, size.get(rootX) + size.get(rootY));
        }
    }
    
    // Test method
    public static void main(String[] args) {
        LongestConsecutiveSequence solution = new LongestConsecutiveSequence();
        
        int[] nums1 = {100, 4, 200, 1, 3, 2};
        System.out.println("Test 1: " + solution.longestConsecutive(nums1)); // Expected: 4 (1,2,3,4)
        
        int[] nums2 = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println("Test 2: " + solution.longestConsecutive(nums2)); // Expected: 9
    }
}
