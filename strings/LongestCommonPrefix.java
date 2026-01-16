/**
 * LeetCode 14: Longest Common Prefix
 * 
 * Problem: Write a function to find the longest common prefix string amongst an array of strings.
 * 
 * Approach: Compare characters at each position across all strings.
 * 
 * Time Complexity: O(S) where S is the sum of all characters in all strings
 * Space Complexity: O(1)
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        
        String prefix = strs[0];
        
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        
        return prefix;
    }
    
    // Test method
    public static void main(String[] args) {
        LongestCommonPrefix solution = new LongestCommonPrefix();
        
        String[] strs1 = {"flower", "flow", "flight"};
        System.out.println("Test 1: " + solution.longestCommonPrefix(strs1)); // Expected: "fl"
        
        String[] strs2 = {"dog", "racecar", "car"};
        System.out.println("Test 2: " + solution.longestCommonPrefix(strs2)); // Expected: ""
    }
}
