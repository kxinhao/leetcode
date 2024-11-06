/**
 * LeetCode 236 Lowest Common Ancestor of Binary Tree (Medium)
 * Solution predicated on constraint that p and q nodes exist in tree
 * TC: O(N) where N is number of nodes in BT
 */
// 3rd impl, post order traversal

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // when end of subtree or subtree l/r contains a target
        if(root==null||root==p||root==q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // not in one subtree, must be in the other, if not in either, go back up to root
        if(left==null) return right;
        else if(right==null) return left;
        else return root;
    }
}
