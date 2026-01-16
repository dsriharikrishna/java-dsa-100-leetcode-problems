/**
 * LeetCode 443: String Compression
 * 
 * Problem: Given an array of characters chars, compress it using the following algorithm:
 * Begin with an empty string s. For each group of consecutive repeating characters in chars,
 * if the group's length is 1, append the character to s. Otherwise, append the character 
 * followed by the group's length.
 * 
 * Approach: Two pointers - one for reading, one for writing.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class StringCompression {
    public int compress(char[] chars) {
        int index = 0;
        int n = chars.length;
        
        for (int i = 0; i < n;) {
            char c = chars[i];
            int count = 0;
            
            // Count consecutive characters
            while (i < n && chars[i] == c) {
                i++;
                count++;
            }
            
            // Write character
            chars[index++] = c;
            
            // Write count if greater than 1
            if (count > 1) {
                for (char digit : String.valueOf(count).toCharArray()) {
                    chars[index++] = digit;
                }
            }
        }
        
        return index;
    }
    
    // Test method
    public static void main(String[] args) {
        StringCompression solution = new StringCompression();
        
        char[] chars1 = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        int len1 = solution.compress(chars1);
        System.out.print("Test 1: ");
        for (int i = 0; i < len1; i++) {
            System.out.print(chars1[i]);
        }
        System.out.println(); // Expected: a2b2c3
    }
}
