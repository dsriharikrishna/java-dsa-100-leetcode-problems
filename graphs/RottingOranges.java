import java.util.LinkedList;
import java.util.Queue;

/**
 * LeetCode 994: Rotting Oranges
 * 
 * Problem: You are given an m x n grid where each cell can have one of three values:
 * 0 representing an empty cell, 1 representing a fresh orange, or 2 representing a rotten orange.
 * Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
 * Return the minimum number of minutes that must elapse until no cell has a fresh orange.
 * 
 * Approach: Multi-source BFS.
 * 
 * Time Complexity: O(m * n)
 * Space Complexity: O(m * n)
 */
public class RottingOranges {
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        
        int minutes = 0;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        while (!queue.isEmpty() && fresh > 0) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int x = curr[0], y = curr[1];
                
                for (int[] dir : directions) {
                    int nx = x + dir[0], ny = y + dir[1];
                    
                    if (nx >= 0 && ny >= 0 && nx < m && ny < n && grid[nx][ny] == 1) {
                        grid[nx][ny] = 2;
                        queue.offer(new int[]{nx, ny});
                        fresh--;
                    }
                }
            }
            minutes++;
        }
        
        return fresh == 0 ? minutes : -1;
    }
    
    // Test method
    public static void main(String[] args) {
        RottingOranges solution = new RottingOranges();
        int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        System.out.println("Minutes: " + solution.orangesRotting(grid)); // Expected: 4
    }
}
