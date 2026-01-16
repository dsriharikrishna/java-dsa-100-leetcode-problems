/**
 * LeetCode 125: Valid Palindrome
 * 
 * Problem: A phrase is a palindrome if, after converting all uppercase letters into lowercase letters
 * and removing all non-alphanumeric characters, it reads the same forward and backward.
 * 
 * Approach: Use two pointers from both ends, skip non-alphanumeric characters.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        
        while (left < right) {
            // Skip non-alphanumeric characters from left
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            
            // Skip non-alphanumeric characters from right
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            
            // Compare characters (case-insensitive)
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            
            left++;
            right--;
        }
        
        return true;
    }
    
    // Test method
    public static void main(String[] args) {
        ValidPalindrome solution = new ValidPalindrome();
        
        System.out.println("Test 1: " + solution.isPalindrome("A man, a plan, a canal: Panama")); // Expected: true
        System.out.println("Test 2: " + solution.isPalindrome("race a car")); // Expected: false
    }
}
