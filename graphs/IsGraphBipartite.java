import java.util.LinkedList;
import java.util.Queue;

/**
 * LeetCode 785: Is Graph Bipartite?
 * 
 * Problem: Given an undirected graph, return true if and only if it is bipartite.
 * 
 * Approach: Graph coloring with BFS.
 * 
 * Time Complexity: O(V + E)
 * Space Complexity: O(V)
 */
public class IsGraphBipartite {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        
        for (int i = 0; i < n; i++) {
            color[i] = -1;
        }
        
        for (int i = 0; i < n; i++) {
            if (color[i] != -1) continue;
            
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(i);
            color[i] = 0;
            
            while (!queue.isEmpty()) {
                int node = queue.poll();
                
                for (int neighbor : graph[node]) {
                    if (color[neighbor] == -1) {
                        color[neighbor] = 1 - color[node];
                        queue.offer(neighbor);
                    } else if (color[neighbor] == color[node]) {
                        return false;
                    }
                }
            }
        }
        
        return true;
    }
    
    // Test method
    public static void main(String[] args) {
        IsGraphBipartite solution = new IsGraphBipartite();
        int[][] graph = {{1, 3}, {0, 2}, {1, 3}, {0, 2}};
        System.out.println("Is bipartite: " + solution.isBipartite(graph)); // Expected: true
    }
}
