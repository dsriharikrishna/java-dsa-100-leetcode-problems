import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * LeetCode 20: Valid Parentheses
 * 
 * Problem: Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.
 * 
 * Approach: Use a stack to match opening and closing brackets.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                // Closing bracket
                if (stack.isEmpty() || stack.pop() != map.get(c)) {
                    return false;
                }
            } else {
                // Opening bracket
                stack.push(c);
            }
        }
        
        return stack.isEmpty();
    }
    
    // Test method
    public static void main(String[] args) {
        ValidParentheses solution = new ValidParentheses();
        
        System.out.println("Test 1: " + solution.isValid("()")); // Expected: true
        System.out.println("Test 2: " + solution.isValid("()[]{}")); // Expected: true
        System.out.println("Test 3: " + solution.isValid("(]")); // Expected: false
    }
}
