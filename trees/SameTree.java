/**
 * LeetCode 100: Same Tree
 * 
 * Problem: Given the roots of two binary trees p and q, check if they are the same.
 * 
 * Approach: Recursive comparison.
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

public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null || p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
    
    // Test method
    public static void main(String[] args) {
        SameTree solution = new SameTree();
        
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);
        
        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(2);
        q.right = new TreeNode(3);
        
        System.out.println("Same tree: " + solution.isSameTree(p, q)); // Expected: true
    }
}
