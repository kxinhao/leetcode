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
        if(root==null) return 1;
        int l = getDiameter(root.left);
        int r = getDiameter(root.right);
        int dia = l+r;
        if(result<dia) result = dia;
        return 1+ Math.max(l,r);
    }
}
