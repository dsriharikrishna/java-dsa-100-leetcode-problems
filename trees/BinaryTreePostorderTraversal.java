import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * LeetCode 145: Binary Tree Postorder Traversal
 * 
 * Problem: Given the root of a binary tree, return the postorder traversal of its nodes' values.
 * 
 * Approach: Iterative postorder using stack.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 */

// Definition for a binary tree node
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode lastVisited = null;
        
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode node = stack.peek();
                if (node.right != null && node.right != lastVisited) {
                    root = node.right;
                } else {
                    result.add(node.val);
                    lastVisited = node;
                    stack.pop();
                }
            }
        }
        
        return result;
    }
    
    // Test method
    public static void main(String[] args) {
        BinaryTreePostorderTraversal solution = new BinaryTreePostorderTraversal();
        
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        
        System.out.println("Postorder: " + solution.postorderTraversal(root)); // Expected: [3,2,1]
    }
}
