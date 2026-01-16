import java.util.Stack;

/**
 * LeetCode 232: Implement Queue using Stacks
 * 
 * Problem: Implement a first in first out (FIFO) queue using only two stacks.
 * 
 * Approach: Use two stacks - one for push operations, one for pop operations.
 * 
 * Time Complexity: Amortized O(1) for all operations
 * Space Complexity: O(n)
 */
public class ImplementQueueUsingStacks {
    private Stack<Integer> s1;
    private Stack<Integer> s2;
    
    public ImplementQueueUsingStacks() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }
    
    public void push(int x) {
        s1.push(x);
    }
    
    public int pop() {
        peek();
        return s2.pop();
    }
    
    public int peek() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.peek();
    }
    
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
    
    // Test method
    public static void main(String[] args) {
        ImplementQueueUsingStacks queue = new ImplementQueueUsingStacks();
        queue.push(1);
        queue.push(2);
        System.out.println("Peek: " + queue.peek());  // Expected: 1
        System.out.println("Pop: " + queue.pop());    // Expected: 1
        System.out.println("Empty: " + queue.empty()); // Expected: false
    }
}
