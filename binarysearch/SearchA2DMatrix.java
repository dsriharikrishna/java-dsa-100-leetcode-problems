/**
 * LeetCode 74: Search a 2D Matrix
 * 
 * Problem: Write an efficient algorithm that searches for a value target in an m x n integer matrix.
 * 
 * Approach: Treat 2D matrix as 1D sorted array and apply binary search.
 * 
 * Time Complexity: O(log(m*n))
 * Space Complexity: O(1)
 */
public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int left = 0;
        int right = rows * cols - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midElement = matrix[mid / cols][mid % cols];
            
            if (midElement == target) {
                return true;
            } else if (midElement < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return false;
    }
    
    // Test method
    public static void main(String[] args) {
        SearchA2DMatrix solution = new SearchA2DMatrix();
        
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        System.out.println("Test 1: " + solution.searchMatrix(matrix, 3));  // Expected: true
        System.out.println("Test 2: " + solution.searchMatrix(matrix, 13)); // Expected: false
    }
}
