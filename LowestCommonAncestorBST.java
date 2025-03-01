/**
 * LeetCode 235 Lowest Common Ancestor of a BST (Medium)
 * TC: O(LogN), SC: O(N)
 */
// 3rd impl with recursion

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // if lesser than root, enter left branch
        // if more than, enter right branch
        // return root if p and q are not on same branch or p/q is root
        if(root.val>p.val && root.val>q.val) return lowestCommonAncestor(root.left,p,q);
        else if(root.val<p.val && root.val<q.val) return lowestCommonAncestor(root.right,p,q);
        else return root;
    }
}
