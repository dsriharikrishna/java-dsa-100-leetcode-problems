import java.util.PriorityQueue;

/**
 * LeetCode 295: Find Median from Data Stream
 * 
 * Problem: Design a data structure that supports adding integers and finding the median.
 * 
 * Approach: Two heaps pattern - max-heap for smaller half, min-heap for larger half.
 * Keep heaps balanced so median is always at top of one or both heaps.
 * 
 * Time Complexity: O(log n) for addNum, O(1) for findMedian
 * Space Complexity: O(n)
 */
public class FindMedianFromDataStream {
    private PriorityQueue<Integer> maxHeap; // smaller half
    private PriorityQueue<Integer> minHeap; // larger half
    
    public FindMedianFromDataStream() {
        maxHeap = new PriorityQueue<>((a, b) -> b - a); // max-heap
        minHeap = new PriorityQueue<>(); // min-heap
    }
    
    public void addNum(int num) {
        // Add to max-heap first
        maxHeap.offer(num);
        
        // Balance: move largest from max-heap to min-heap
        minHeap.offer(maxHeap.poll());
        
        // Ensure max-heap has equal or one more element
        if (maxHeap.size() < minHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }
    
    public double findMedian() {
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        }
        return (maxHeap.peek() + minHeap.peek()) / 2.0;
    }
    
    // Test method
    public static void main(String[] args) {
        FindMedianFromDataStream medianFinder = new FindMedianFromDataStream();
        
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println("Median: " + medianFinder.findMedian()); // Expected: 1.5
        
        medianFinder.addNum(3);
        System.out.println("Median: " + medianFinder.findMedian()); // Expected: 2.0
    }
}
