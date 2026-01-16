/**
 * LeetCode 567: Permutation in String
 * 
 * Problem: Given two strings s1 and s2, return true if s2 contains a permutation of s1.
 * 
 * Approach: Fixed-size sliding window with character frequency matching.
 * Window size = s1.length(), check if frequencies match.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1) - fixed 26 letters
 */
public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        
        int[] s1Count = new int[26];
        int[] s2Count = new int[26];
        
        // Initialize frequency arrays
        for (int i = 0; i < s1.length(); i++) {
            s1Count[s1.charAt(i) - 'a']++;
            s2Count[s2.charAt(i) - 'a']++;
        }
        
        // Check initial window
        if (matches(s1Count, s2Count)) return true;
        
        // Slide the window
        for (int i = s1.length(); i < s2.length(); i++) {
            s2Count[s2.charAt(i) - 'a']++;
            s2Count[s2.charAt(i - s1.length()) - 'a']--;
            
            if (matches(s1Count, s2Count)) return true;
        }
        
        return false;
    }
    
    private boolean matches(int[] s1Count, int[] s2Count) {
        for (int i = 0; i < 26; i++) {
            if (s1Count[i] != s2Count[i]) return false;
        }
        return true;
    }
    
    // Test method
    public static void main(String[] args) {
        PermutationInString solution = new PermutationInString();
        
        System.out.println("Test 1: " + solution.checkInclusion("ab", "eidbaooo")); // Expected: true
        System.out.println("Test 2: " + solution.checkInclusion("ab", "eidboaoo")); // Expected: false
    }
}
