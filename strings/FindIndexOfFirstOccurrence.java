/**
 * LeetCode 28: Find the Index of the First Occurrence in a String
 * 
 * Problem: Given two strings needle and haystack, return the index of the first occurrence 
 * of needle in haystack, or -1 if needle is not part of haystack.
 * 
 * Approach: Use Java's built-in indexOf or implement simple string matching.
 * 
 * Time Complexity: O(m * n) where m and n are lengths of haystack and needle
 * Space Complexity: O(1)
 */
public class FindIndexOfFirstOccurrence {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        
        if (n == 0) return 0;
        
        for (int i = 0; i <= m - n; i++) {
            if (haystack.substring(i, i + n).equals(needle)) {
                return i;
            }
        }
        
        return -1;
    }
    
    // Test method
    public static void main(String[] args) {
        FindIndexOfFirstOccurrence solution = new FindIndexOfFirstOccurrence();
        
        System.out.println("Test 1: " + solution.strStr("sadbutsad", "sad")); // Expected: 0
        System.out.println("Test 2: " + solution.strStr("leetcode", "leeto")); // Expected: -1
    }
}
