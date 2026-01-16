import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode 3: Longest Substring Without Repeating Characters
 * 
 * Problem: Given a string s, find the length of the longest substring without repeating characters.
 * 
 * Approach: Sliding window with HashSet to track characters in current window.
 * Expand window by moving right pointer, shrink when duplicate found.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(min(n, m)) where m is charset size
 */
public class LongestSubstringWithoutRepeating {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0;
        int maxLength = 0;
        
        for (int right = 0; right < s.length(); right++) {
            // Shrink window until no duplicate
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            
            set.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
    
    // Test method
    public static void main(String[] args) {
        LongestSubstringWithoutRepeating solution = new LongestSubstringWithoutRepeating();
        
        System.out.println("Test 1: " + solution.lengthOfLongestSubstring("abcabcbb")); // Expected: 3 (abc)
        System.out.println("Test 2: " + solution.lengthOfLongestSubstring("bbbbb")); // Expected: 1 (b)
        System.out.println("Test 3: " + solution.lengthOfLongestSubstring("pwwkew")); // Expected: 3 (wke)
    }
}
