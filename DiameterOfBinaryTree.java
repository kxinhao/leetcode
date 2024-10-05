/*
 * LeetCode 543 Diameter of Binary Tree (Easy)
 *
 */

// Diameter = max travelable distance of node's subtrees
// soln: for each node, count left + right heights and replace largest total if larger
// Hint: Balanced Binary Tree derivation
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int result = 0;
    public int diameterOfBinaryTree(TreeNode root) {
       getDiameter(root);
       return result;
    }
    public int getDiameter(TreeNode root) {
        if(root==null) return 0;
        int l = getDiameter(root.left);
        int r = getDiameter(root.right);
        result = Math.max(result, l+r);
        return 1+ Math.max(l,r);
    }
}
