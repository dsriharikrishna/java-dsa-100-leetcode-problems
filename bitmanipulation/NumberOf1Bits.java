/**
 * LeetCode 191: Number of 1 Bits
 * 
 * Problem: Write a function that takes an unsigned integer and returns the number of '1' bits it has
 * (also known as the Hamming weight).
 * 
 * Approach: Count set bits by masking and shifting.
 * 
 * Time Complexity: O(1) - fixed 32 iterations
 * Space Complexity: O(1)
 */
public class NumberOf1Bits {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count += n & 1;
            n >>>= 1; // Unsigned right shift
        }
        return count;
    }
    
    // Test method
    public static void main(String[] args) {
        NumberOf1Bits solution = new NumberOf1Bits();
        
        System.out.println("Test 1: " + solution.hammingWeight(11)); // Expected: 3 (1011)
        System.out.println("Test 2: " + solution.hammingWeight(128)); // Expected: 1 (10000000)
        System.out.println("Test 3: " + solution.hammingWeight(4294967293)); // Expected: 31
    }
}
