/*
 * LeetCode 543 Diameter of Binary Tree (Easy)
 * TC: O(N), SC: O(1)
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
// 2nd impl
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
        // total path travelable from this node's subtrees
        result = Math.max(result, l+r);
        // return the longest path to this node + 1
        return 1+ Math.max(l,r);
    }
}
