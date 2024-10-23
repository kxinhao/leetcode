/**
 * LeetCode 98 Validate Binary Search Tree (Medium)
 * Recursion with helper method that takes TreeNode, int min, int max input params
 * helper method is initially called in main class, then recursively called by itself
 * until all leaves have been checked or an invalidating node has been found
 * recursion called on child nodes and using parent as min when checking right child lesser than
 * and parent as max when checking left child larger than parent
 */
// 3rd impl without Integer max/min check

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
    public boolean isValidBST(TreeNode root) {
        return check(root, null, null);
    }
    private boolean check(TreeNode node, Integer min, Integer max) {
        if(node == null) return true;
        // if right node is smaller than parent or left node is larger than parent, BST invalid
        if((min != null && node.val <= min) || (max!=null && node.val>=max)) return false;
        // check left child using curr.val as max to ensure left child is smaller than curr
        // check right child using curr.val as min to ensure right child is larger than curr
        return check(node.left, min, node.val) && check(node.right, node.val, max);
    }
}
