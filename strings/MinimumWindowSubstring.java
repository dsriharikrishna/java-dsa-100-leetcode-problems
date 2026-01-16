import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 76: Minimum Window Substring
 * 
 * Problem: Given two strings s and t, return the minimum window substring of s 
 * such that every character in t is included in the window.
 * 
 * Approach: Sliding window with character frequency map.
 * 
 * Time Complexity: O(m + n) where m and n are lengths of s and t
 * Space Complexity: O(k) where k is number of unique characters in t
 */
public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) return "";
        
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : t.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        
        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int count = 0;
        int start = 0;
        
        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            
            if (freq.containsKey(rightChar)) {
                freq.put(rightChar, freq.get(rightChar) - 1);
                if (freq.get(rightChar) >= 0) {
                    count++;
                }
            }
            
            while (count == t.length()) {
                if (minLen > right - left + 1) {
                    minLen = right - left + 1;
                    start = left;
                }
                
                char leftChar = s.charAt(left);
                if (freq.containsKey(leftChar)) {
                    freq.put(leftChar, freq.get(leftChar) + 1);
                    if (freq.get(leftChar) > 0) {
                        count--;
                    }
                }
                left++;
            }
        }
        
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
    
    // Test method
    public static void main(String[] args) {
        MinimumWindowSubstring solution = new MinimumWindowSubstring();
        
        System.out.println("Test 1: " + solution.minWindow("ADOBECODEBANC", "ABC")); // Expected: "BANC"
        System.out.println("Test 2: " + solution.minWindow("a", "a")); // Expected: "a"
    }
}
