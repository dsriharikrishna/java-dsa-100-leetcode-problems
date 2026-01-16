import java.util.PriorityQueue;

/**
 * LeetCode 973: K Closest Points to Origin
 * 
 * Problem: Given an array of points, return the k closest points to the origin (0, 0).
 * 
 * Approach: Max-heap of size k based on distance. Keep k closest points.
 * 
 * Time Complexity: O(n log k)
 * Space Complexity: O(k)
 */
public class KClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int k) {
        // Max-heap based on distance
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> (b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1])
        );
        
        for (int[] point : points) {
            maxHeap.offer(point);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        
        // Build result
        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = maxHeap.poll();
        }
        
        return result;
    }
    
    // Test method
    public static void main(String[] args) {
        KClosestPointsToOrigin solution = new KClosestPointsToOrigin();
        
        int[][] points = {{1, 3}, {-2, 2}, {5, 8}, {0, 1}};
        int[][] result = solution.kClosest(points, 2);
        
        System.out.println("K closest points:");
        for (int[] point : result) {
            System.out.println("[" + point[0] + ", " + point[1] + "]");
        }
        // Expected: [0,1] and [-2,2] (order may vary)
    }
}
