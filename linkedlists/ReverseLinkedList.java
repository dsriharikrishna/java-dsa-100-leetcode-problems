/**
 * LeetCode 206: Reverse Linked List
 * 
 * Problem: Given the head of a singly linked list, reverse the list, and return the reversed list.
 * 
 * Approach: Iterative reversal using three pointers.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

// Definition for singly-linked list
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        
        while (current != null) {
            ListNode nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        
        return prev;
    }
    
    // Test method
    public static void main(String[] args) {
        ReverseLinkedList solution = new ReverseLinkedList();
        
        // Create list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        
        ListNode reversed = solution.reverseList(head);
        
        System.out.print("Reversed list: ");
        while (reversed != null) {
            System.out.print(reversed.val + " ");
            reversed = reversed.next;
        }
        System.out.println(); // Expected: 5 4 3 2 1
    }
}
