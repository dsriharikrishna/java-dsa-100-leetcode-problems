/**
 * LeetCode 190: Reverse Bits
 * 
 * Problem: Reverse bits of a given 32 bits unsigned integer.
 * 
 * Approach: Bit manipulation with shifts.
 * 
 * Time Complexity: O(1) - fixed 32 iterations
 * Space Complexity: O(1)
 */
public class ReverseBits {
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result = (result << 1) | (n & 1);
            n >>= 1;
        }
        return result;
    }
    
    // Test method
    public static void main(String[] args) {
        ReverseBits solution = new ReverseBits();
        
        // Test with 43261596 (00000010100101000001111010011100)
        int n = 43261596;
        System.out.println("Test 1: " + solution.reverseBits(n)); 
        // Expected: 964176192 (00111001011110000010100101000000)
    }
}
