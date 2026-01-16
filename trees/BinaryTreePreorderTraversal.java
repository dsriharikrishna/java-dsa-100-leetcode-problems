import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * LeetCode 144: Binary Tree Preorder Traversal
 * 
 * Problem: Given the root of a binary tree, return the preorder traversal of its nodes' values.
 * 
 * Approach: Iterative preorder using stack.
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

public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        
        if (root != null) {
            stack.push(root);
        }
        
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            result.add(curr.val);
            
            if (curr.right != null) {
                stack.push(curr.right);
            }
            if (curr.left != null) {
                stack.push(curr.left);
            }
        }
        
        return result;
    }
    
    // Test method
    public static void main(String[] args) {
        BinaryTreePreorderTraversal solution = new BinaryTreePreorderTraversal();
        
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        
        System.out.println("Preorder: " + solution.preorderTraversal(root)); // Expected: [1,2,3]
    }
}
