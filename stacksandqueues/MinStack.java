import java.util.Stack;

/**
 * LeetCode 155: Min Stack
 * 
 * Problem: Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * 
 * Approach: Use two stacks - one for values, one for tracking minimums.
 * 
 * Time Complexity: O(1) for all operations
 * Space Complexity: O(n)
 */
public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }
    
    public void pop() {
        if (stack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
    
    // Test method
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println("Min: " + minStack.getMin()); // Expected: -3
        minStack.pop();
        System.out.println("Top: " + minStack.top());    // Expected: 0
        System.out.println("Min: " + minStack.getMin()); // Expected: -2
    }
}
