import java.util.Stack;

/**
 * LeetCode 150: Evaluate Reverse Polish Notation
 * 
 * Problem: Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * 
 * Approach: Use a stack to evaluate the expression.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        
        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int b = stack.pop();
                int a = stack.pop();
                
                if (token.equals("+")) {
                    stack.push(a + b);
                } else if (token.equals("-")) {
                    stack.push(a - b);
                } else if (token.equals("*")) {
                    stack.push(a * b);
                } else {
                    stack.push(a / b);
                }
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        
        return stack.pop();
    }
    
    // Test method
    public static void main(String[] args) {
        EvaluateReversePolishNotation solution = new EvaluateReversePolishNotation();
        
        String[] tokens1 = {"2", "1", "+", "3", "*"};
        System.out.println("Test 1: " + solution.evalRPN(tokens1)); // Expected: 9
        
        String[] tokens2 = {"4", "13", "5", "/", "+"};
        System.out.println("Test 2: " + solution.evalRPN(tokens2)); // Expected: 6
    }
}
