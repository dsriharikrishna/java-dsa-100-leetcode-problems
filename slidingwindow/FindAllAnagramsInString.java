import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 438: Find All Anagrams in a String
 * 
 * Problem: Given two strings s and p, return an array of all the start indices of p's anagrams in s.
 * 
 * Approach: Fixed-size sliding window (size = p.length()).
 * Similar to LC 567 but collect all matching positions.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1) - fixed 26 letters
 */
public class FindAllAnagramsInString {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (p.length() > s.length()) return result;
        
        int[] pCount = new int[26];
        int[] sCount = new int[26];
        
        // Initialize frequency arrays
        for (int i = 0; i < p.length(); i++) {
            pCount[p.charAt(i) - 'a']++;
            sCount[s.charAt(i) - 'a']++;
        }
        
        // Check initial window
        if (matches(pCount, sCount)) {
            result.add(0);
        }
        
        // Slide the window
        for (int i = p.length(); i < s.length(); i++) {
            sCount[s.charAt(i) - 'a']++;
            sCount[s.charAt(i - p.length()) - 'a']--;
            
            if (matches(pCount, sCount)) {
                result.add(i - p.length() + 1);
            }
        }
        
        return result;
    }
    
    private boolean matches(int[] pCount, int[] sCount) {
        for (int i = 0; i < 26; i++) {
            if (pCount[i] != sCount[i]) return false;
        }
        return true;
    }
    
    // Test method
    public static void main(String[] args) {
        FindAllAnagramsInString solution = new FindAllAnagramsInString();
        
        System.out.println("Test 1: " + solution.findAnagrams("cbaebabacd", "abc")); // Expected: [0, 6]
        System.out.println("Test 2: " + solution.findAnagrams("abab", "ab")); // Expected: [0, 1, 2]
    }
}
