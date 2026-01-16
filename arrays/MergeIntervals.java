import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode 56: Merge Intervals
 * 
 * Problem: Given an array of intervals where intervals[i] = [starti, endi], 
 * merge all overlapping intervals.
 * 
 * Approach: Sort intervals by start time, then merge overlapping intervals.
 * 
 * Time Complexity: O(n log n) - due to sorting
 * Space Complexity: O(n) - for the result list
 */
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return new int[0][];
        
        // Sort intervals by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        List<int[]> merged = new ArrayList<>();
        
        for (int[] interval : intervals) {
            // If merged is empty or current interval doesn't overlap with the last one
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < interval[0]) {
                merged.add(interval);
            } else {
                // Merge overlapping intervals
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], interval[1]);
            }
        }
        
        return merged.toArray(new int[merged.size()][]);
    }
    
    // Test method
    public static void main(String[] args) {
        MergeIntervals solution = new MergeIntervals();
        
        // Test case 1: [[1,3],[2,6],[8,10],[15,18]]
        int[][] intervals1 = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] result1 = solution.merge(intervals1);
        System.out.print("Test 1: ");
        for (int[] interval : result1) {
            System.out.print("[" + interval[0] + "," + interval[1] + "] ");
        }
        System.out.println(); // Expected: [[1,6],[8,10],[15,18]]
    }
}
