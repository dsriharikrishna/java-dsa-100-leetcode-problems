import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 51: N-Queens
 * 
 * Problem: Place n queens on an n×n chessboard such that no two queens attack each other.
 * 
 * Approach: Backtracking with safety checking.
 * 
 * Time Complexity: O(n!)
 * Space Complexity: O(n²)
 */
public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        solve(0, board, result, n);
        return result;
    }
    
    private void solve(int row, char[][] board, List<List<String>> result, int n) {
        if (row == n) {
            result.add(construct(board));
            return;
        }
        
        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col, n)) {
                board[row][col] = 'Q';
                solve(row + 1, board, result, n);
                board[row][col] = '.';
            }
        }
    }
    
    private boolean isSafe(char[][] board, int row, int col, int n) {
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') return false;
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }
        return true;
    }
    
    private List<String> construct(char[][] board) {
        List<String> res = new ArrayList<>();
        for (char[] row : board) {
            res.add(new String(row));
        }
        return res;
    }
    
    // Test method
    public static void main(String[] args) {
        NQueens solution = new NQueens();
        System.out.println("Result: " + solution.solveNQueens(4));
    }
}
