import java.util.PriorityQueue;

/**
 * LeetCode 215: Kth Largest Element in an Array
 * 
 * Problem: Given an integer array nums and an integer k, return the kth largest element.
 * 
 * Approach: Min-heap of size k. Keep only k largest elements in heap.
 * The root of min-heap will be the kth largest.
 * 
 * Time Complexity: O(n log k)
 * Space Complexity: O(k)
 */
public class KthLargestElement {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        
        return minHeap.peek();
    }
    
    // Test method
    public static void main(String[] args) {
        KthLargestElement solution = new KthLargestElement();
        
        int[] nums1 = {3, 2, 1, 5, 6, 4};
        System.out.println("Test 1: " + solution.findKthLargest(nums1, 2)); // Expected: 5
        
        int[] nums2 = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        System.out.println("Test 2: " + solution.findKthLargest(nums2, 4)); // Expected: 4
    }
}
