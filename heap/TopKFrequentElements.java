import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * LeetCode 347: Top K Frequent Elements
 * 
 * Problem: Given an integer array nums and an integer k, return the k most frequent elements.
 * 
 * Approach: HashMap for frequency counting + Min-heap of size k.
 * 
 * Time Complexity: O(n log k)
 * Space Complexity: O(n)
 */
public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        // Count frequencies
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        
        // Min-heap based on frequency
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(
            (a, b) -> freqMap.get(a) - freqMap.get(b)
        );
        
        for (int num : freqMap.keySet()) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        
        // Build result
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = minHeap.poll();
        }
        
        return result;
    }
    
    // Test method
    public static void main(String[] args) {
        TopKFrequentElements solution = new TopKFrequentElements();
        
        int[] nums1 = {1, 1, 1, 2, 2, 3};
        int[] result1 = solution.topKFrequent(nums1, 2);
        System.out.print("Test 1: ");
        for (int num : result1) System.out.print(num + " ");
        System.out.println(); // Expected: 1 2 (order may vary)
    }
}
