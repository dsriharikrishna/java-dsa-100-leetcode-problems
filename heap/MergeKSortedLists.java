import java.util.PriorityQueue;

/**
 * LeetCode 23: Merge k Sorted Lists
 * 
 * Problem: Merge k sorted linked lists and return it as one sorted list.
 * 
 * Approach: Min-heap to track smallest element among k lists.
 * 
 * Time Complexity: O(N log k) where N is total nodes
 * Space Complexity: O(k) for heap
 */

// Definition for singly-linked list
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(
            (a, b) -> a.val - b.val
        );
        
        // Add first node of each list to heap
        for (ListNode list : lists) {
            if (list != null) {
                minHeap.offer(list);
            }
        }
        
        ListNode dummy = new ListNode();
        ListNode current = dummy;
        
        while (!minHeap.isEmpty()) {
            ListNode node = minHeap.poll();
            current.next = node;
            current = current.next;
            
            if (node.next != null) {
                minHeap.offer(node.next);
            }
        }
        
        return dummy.next;
    }
    
    // Test method
    public static void main(String[] args) {
        MergeKSortedLists solution = new MergeKSortedLists();
        
        // Create lists: [[1,4,5],[1,3,4],[2,6]]
        ListNode[] lists = new ListNode[3];
        lists[0] = new ListNode(1, new ListNode(4, new ListNode(5)));
        lists[1] = new ListNode(1, new ListNode(3, new ListNode(4)));
        lists[2] = new ListNode(2, new ListNode(6));
        
        ListNode result = solution.mergeKLists(lists);
        System.out.print("Result: ");
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
        System.out.println(); // Expected: 1 1 2 3 4 4 5 6
    }
}
