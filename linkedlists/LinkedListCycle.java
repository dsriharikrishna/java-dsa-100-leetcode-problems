/**
 * LeetCode 141: Linked List Cycle
 * 
 * Problem: Given head, the head of a linked list, determine if the linked list has a cycle in it.
 * 
 * Approach: Floyd's Cycle Detection Algorithm (Tortoise and Hare).
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

// Definition for singly-linked list
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if (slow == fast) {
                return true;
            }
        }
        
        return false;
    }
    
    // Test method
    public static void main(String[] args) {
        LinkedListCycle solution = new LinkedListCycle();
        
        // Create list with cycle: 3 -> 2 -> 0 -> -4 -> (back to 2)
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next; // Create cycle
        
        System.out.println("Has cycle: " + solution.hasCycle(head)); // Expected: true
        
        // Create list without cycle: 1 -> 2
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        
        System.out.println("Has cycle: " + solution.hasCycle(head2)); // Expected: false
    }
}
