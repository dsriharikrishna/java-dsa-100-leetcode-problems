/**
 * LeetCode 459: Repeated Substring Pattern
 * 
 * Problem: Given a string s, check if it can be constructed by taking a substring of it 
 * and appending multiple copies of the substring together.
 * 
 * Approach: Concatenate the string with itself and check if the original string 
 * appears in the middle (excluding first and last character).
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        String doubled = s + s;
        String sub = doubled.substring(1, doubled.length() - 1);
        return sub.contains(s);
    }
    
    // Test method
    public static void main(String[] args) {
        RepeatedSubstringPattern solution = new RepeatedSubstringPattern();
        
        System.out.println("Test 1: " + solution.repeatedSubstringPattern("abab")); // Expected: true
        System.out.println("Test 2: " + solution.repeatedSubstringPattern("aba")); // Expected: false
        System.out.println("Test 3: " + solution.repeatedSubstringPattern("abcabcabcabc")); // Expected: true
    }
}
