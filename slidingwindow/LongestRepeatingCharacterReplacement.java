/**
 * LeetCode 424: Longest Repeating Character Replacement
 * 
 * Problem: You can replace at most k characters. Find the length of the longest substring
 * containing the same letter you can get after performing the above operations.
 * 
 * Approach: Sliding window with frequency map. Track max frequency character.
 * Window is valid if (window_length - max_freq) <= k.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1) - fixed 26 letters
 */
public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int left = 0;
        int maxFreq = 0;
        int maxLength = 0;
        
        for (int right = 0; right < s.length(); right++) {
            count[s.charAt(right) - 'A']++;
            maxFreq = Math.max(maxFreq, count[s.charAt(right) - 'A']);
            
            // If window is invalid, shrink from left
            while (right - left + 1 - maxFreq > k) {
                count[s.charAt(left) - 'A']--;
                left++;
            }
            
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
    
    // Test method
    public static void main(String[] args) {
        LongestRepeatingCharacterReplacement solution = new LongestRepeatingCharacterReplacement();
        
        System.out.println("Test 1: " + solution.characterReplacement("ABAB", 2)); // Expected: 4
        System.out.println("Test 2: " + solution.characterReplacement("AABABBA", 1)); // Expected: 4
    }
}
