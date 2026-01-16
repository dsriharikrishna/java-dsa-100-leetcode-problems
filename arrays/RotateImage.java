/**
 * LeetCode 48: Rotate Image
 * 
 * Problem: You are given an n x n 2D matrix representing an image, 
 * rotate the image by 90 degrees (clockwise).
 * 
 * Approach: 
 * 1. Transpose the matrix (swap matrix[i][j] with matrix[j][i])
 * 2. Reverse each row
 * 
 * Time Complexity: O(n²)
 * Space Complexity: O(1)
 */
public class RotateImage {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        
        // Step 1: Transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        // Step 2: Reverse each row
        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = n - 1;
            while (left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
    }
    
    // Test method
    public static void main(String[] args) {
        RotateImage solution = new RotateImage();
        
        // Test case 1: [[1,2,3],[4,5,6],[7,8,9]]
        int[][] matrix1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        solution.rotate(matrix1);
        System.out.println("Test 1:");
        for (int[] row : matrix1) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        // Expected: [[7,4,1],[8,5,2],[9,6,3]]
    }
}
