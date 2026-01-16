/**
 * LeetCode 160: Intersection of Two Linked Lists
 * 
 * Problem: Given the heads of two singly linked-lists headA and headB, 
 * return the node at which the two lists intersect.
 * 
 * Approach: Two-pointer technique - when one pointer reaches the end, 
 * redirect it to the other list's head.
 * 
 * Time Complexity: O(m + n)
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

public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        
        while (a != b) {
            a = (a != null) ? a.next : headB;
            b = (b != null) ? b.next : headA;
        }
        
        return a;
    }
    
    // Test method
    public static void main(String[] args) {
        IntersectionOfTwoLinkedLists solution = new IntersectionOfTwoLinkedLists();
        
        // Create intersection node
        ListNode intersection = new ListNode(8);
        intersection.next = new ListNode(4);
        intersection.next.next = new ListNode(5);
        
        // Create listA: 4 -> 1 -> 8 -> 4 -> 5
        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = intersection;
        
        // Create listB: 5 -> 6 -> 1 -> 8 -> 4 -> 5
        ListNode headB = new ListNode(5);
        headB.next = new ListNode(6);
        headB.next.next = new ListNode(1);
        headB.next.next.next = intersection;
        
        ListNode result = solution.getIntersectionNode(headA, headB);
        System.out.println("Intersection at node with value: " + (result != null ? result.val : "null")); 
        // Expected: 8
    }
}
