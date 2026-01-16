/**
 * LeetCode 684: Redundant Connection
 * 
 * Problem: In this problem, a tree is an undirected graph that is connected and has no cycles.
 * Given edges that will form a tree plus one extra edge, return the edge that can be removed.
 * 
 * Approach: Union-Find to detect cycle. The edge that creates a cycle is redundant.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class RedundantConnection {
    private int[] parent;
    
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n + 1];
        
        // Initialize
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        
        for (int[] edge : edges) {
            if (!union(edge[0], edge[1])) {
                return edge; // This edge creates a cycle
            }
        }
        
        return new int[0];
    }
    
    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]); // Path compression
        }
        return parent[x];
    }
    
    private boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        
        if (rootX == rootY) {
            return false; // Already in same set, would create cycle
        }
        
        parent[rootX] = rootY;
        return true;
    }
    
    // Test method
    public static void main(String[] args) {
        RedundantConnection solution = new RedundantConnection();
        
        int[][] edges1 = {{1,2},{1,3},{2,3}};
        int[] result1 = solution.findRedundantConnection(edges1);
        System.out.println("Test 1: [" + result1[0] + "," + result1[1] + "]"); // Expected: [2,3]
        
        int[][] edges2 = {{1,2},{2,3},{3,4},{1,4},{1,5}};
        int[] result2 = solution.findRedundantConnection(edges2);
        System.out.println("Test 2: [" + result2[0] + "," + result2[1] + "]"); // Expected: [1,4]
    }
}
