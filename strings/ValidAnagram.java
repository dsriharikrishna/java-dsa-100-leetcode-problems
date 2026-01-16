/**
 * LeetCode 242: Valid Anagram
 * 
 * Problem: Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 * 
 * Approach: Use character frequency counting with an array.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1) - fixed size array of 26
 */
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        
        int[] count = new int[26];
        
        // Count characters in s
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        
        // Subtract characters in t
        for (char c : t.toCharArray()) {
            count[c - 'a']--;
            if (count[c - 'a'] < 0) {
                return false;
            }
        }
        
        return true;
    }
    
    // Test method
    public static void main(String[] args) {
        ValidAnagram solution = new ValidAnagram();
        
        System.out.println("Test 1: " + solution.isAnagram("anagram", "nagaram")); // Expected: true
        System.out.println("Test 2: " + solution.isAnagram("rat", "car")); // Expected: false
    }
}
