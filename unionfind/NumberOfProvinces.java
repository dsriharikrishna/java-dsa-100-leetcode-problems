/**
 * LeetCode 547: Number of Provinces
 * 
 * Problem: Given an n x n matrix isConnected where isConnected[i][j] = 1 if city i and j are connected,
 * return the total number of provinces.
 * 
 * Approach: Union-Find to group connected cities.
 * 
 * Time Complexity: O(n²)
 * Space Complexity: O(n)
 */
public class NumberOfProvinces {
    private int[] parent;
    private int[] rank;
    
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        parent = new int[n];
        rank = new int[n];
        
        // Initialize
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
        
        int provinces = n;
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    if (union(i, j)) {
                        provinces--;
                    }
                }
            }
        }
        
        return provinces;
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
        
        if (rootX == rootY) return false;
        
        // Union by rank
        if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;
        } else if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
        } else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }
        
        return true;
    }
    
    // Test method
    public static void main(String[] args) {
        NumberOfProvinces solution = new NumberOfProvinces();
        
        int[][] isConnected1 = {{1,1,0},{1,1,0},{0,0,1}};
        System.out.println("Test 1: " + solution.findCircleNum(isConnected1)); // Expected: 2
        
        int[][] isConnected2 = {{1,0,0},{0,1,0},{0,0,1}};
        System.out.println("Test 2: " + solution.findCircleNum(isConnected2)); // Expected: 3
    }
}
