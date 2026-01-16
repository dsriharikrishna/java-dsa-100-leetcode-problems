import java.util.LinkedList;
import java.util.Queue;

/**
 * LeetCode 225: Implement Stack using Queues
 * 
 * Problem: Implement a last-in-first-out (LIFO) stack using only two queues.
 * 
 * Approach: Use two queues, rotate elements on push to maintain LIFO order.
 * 
 * Time Complexity: O(n) for push, O(1) for pop and top
 * Space Complexity: O(n)
 */
public class ImplementStackUsingQueues {
    private Queue<Integer> q1;
    private Queue<Integer> q2;
    
    public ImplementStackUsingQueues() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }
    
    public void push(int x) {
        q2.offer(x);
        while (!q1.isEmpty()) {
            q2.offer(q1.poll());
        }
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }
    
    public int pop() {
        return q1.poll();
    }
    
    public int top() {
        return q1.peek();
    }
    
    public boolean empty() {
        return q1.isEmpty();
    }
    
    // Test method
    public static void main(String[] args) {
        ImplementStackUsingQueues stack = new ImplementStackUsingQueues();
        stack.push(1);
        stack.push(2);
        System.out.println("Top: " + stack.top());   // Expected: 2
        System.out.println("Pop: " + stack.pop());   // Expected: 2
        System.out.println("Empty: " + stack.empty()); // Expected: false
    }
}
