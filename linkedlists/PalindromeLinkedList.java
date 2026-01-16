/**
 * LeetCode 234: Palindrome Linked List
 * 
 * Problem: Given the head of a singly linked list, return true if it is a palindrome.
 * 
 * Approach: Find middle, reverse second half, compare both halves.
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

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        
        // Find middle using slow and fast pointers
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            
            // Reverse first half while finding middle
            ListNode temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }
        
        // If odd number of nodes, skip middle
        if (fast != null) {
            slow = slow.next;
        }
        
        // Compare both halves
        while (slow != null) {
            if (slow.val != prev.val) {
                return false;
            }
            slow = slow.next;
            prev = prev.next;
        }
        
        return true;
    }
    
    // Test method
    public static void main(String[] args) {
        PalindromeLinkedList solution = new PalindromeLinkedList();
        
        // Create list: 1 -> 2 -> 2 -> 1
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(2);
        head1.next.next.next = new ListNode(1);
        
        System.out.println("Test 1: " + solution.isPalindrome(head1)); // Expected: true
        
        // Create list: 1 -> 2
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        
        System.out.println("Test 2: " + solution.isPalindrome(head2)); // Expected: false
    }
}
