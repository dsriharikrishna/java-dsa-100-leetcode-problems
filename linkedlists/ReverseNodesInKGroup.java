/**
 * LeetCode 25: Reverse Nodes in k-Group
 * 
 * Problem: Given the head of a linked list, reverse the nodes of the list k at a time.
 * 
 * Approach: Recursive reversal of k nodes at a time.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n/k) due to recursion
 */

// Definition for singly-linked list
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        // Check if there are k nodes left
        ListNode temp = head;
        for (int i = 0; i < k; i++) {
            if (temp == null) return head;
            temp = temp.next;
        }
        
        // Reverse k nodes
        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;
        
        for (int i = 0; i < k; i++) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        
        // Recursively reverse the rest
        head.next = reverseKGroup(next, k);
        
        return prev;
    }
    
    // Test method
    public static void main(String[] args) {
        ReverseNodesInKGroup solution = new ReverseNodesInKGroup();
        
        // Create list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        
        ListNode result = solution.reverseKGroup(head, 2);
        
        System.out.print("Result: ");
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
        System.out.println(); // Expected: 2 1 4 3 5
    }
}
