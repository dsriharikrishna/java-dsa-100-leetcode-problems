import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * LeetCode 94: Binary Tree Inorder Traversal
 * 
 * Problem: Given the root of a binary tree, return the inorder traversal of its nodes' values.
 * 
 * Approach: Iterative inorder using stack.
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

public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            result.add(curr.val);
            curr = curr.right;
        }
        
        return result;
    }
    
    // Test method
    public static void main(String[] args) {
        BinaryTreeInorderTraversal solution = new BinaryTreeInorderTraversal();
        
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        
        System.out.println("Inorder: " + solution.inorderTraversal(root)); // Expected: [1,3,2]
    }
}
