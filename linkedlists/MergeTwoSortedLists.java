/**
 * LeetCode 21: Merge Two Sorted Lists
 * 
 * Problem: Merge two sorted linked lists and return it as a sorted list.
 * 
 * Approach: Recursive merge.
 * 
 * Time Complexity: O(m + n)
 * Space Complexity: O(m + n) due to recursion
 */

// Definition for singly-linked list
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        
        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }
    
    // Test method
    public static void main(String[] args) {
        MergeTwoSortedLists solution = new MergeTwoSortedLists();
        
        // Create list1: 1 -> 2 -> 4
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);
        
        // Create list2: 1 -> 3 -> 4
        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);
        
        ListNode merged = solution.mergeTwoLists(list1, list2);
        
        System.out.print("Merged list: ");
        while (merged != null) {
            System.out.print(merged.val + " ");
            merged = merged.next;
        }
        System.out.println(); // Expected: 1 1 2 3 4 4
    }
}
