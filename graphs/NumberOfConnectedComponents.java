import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 323: Number of Connected Components in an Undirected Graph
 * 
 * Problem: Given n nodes labeled from 0 to n - 1 and a list of undirected edges,
 * return the number of connected components in the graph.
 * 
 * Approach: DFS to count connected components.
 * 
 * Time Complexity: O(V + E)
 * Space Complexity: O(V + E)
 */
public class NumberOfConnectedComponents {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        boolean[] visited = new boolean[n];
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++;
                dfs(graph, visited, i);
            }
        }
        
        return count;
    }
    
    private void dfs(List<List<Integer>> graph, boolean[] visited, int node) {
        visited[node] = true;
        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(graph, visited, neighbor);
            }
        }
    }
    
    // Test method
    public static void main(String[] args) {
        NumberOfConnectedComponents solution = new NumberOfConnectedComponents();
        int[][] edges = {{0, 1}, {1, 2}, {3, 4}};
        System.out.println("Components: " + solution.countComponents(5, edges)); // Expected: 2
    }
}
