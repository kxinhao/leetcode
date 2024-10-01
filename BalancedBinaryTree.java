/**
 * LeetCode 110 Balanced Binary Tree (Easy)
 * TC: O(N), SC: O(1)
 */
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
// 3rd impl: goes all the way to deepest node and calculates difference in height with sibling

// no global var
class Solution {
    public boolean isBalanced(TreeNode root) {
        return maxDepth(root)!=-1;
    }
    private int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        if(l==-1||r==-1||Math.abs(l-r)>1) return -1;
        return Math.max(l, r) + 1;
    }
}

/* using global var
class Solution {
    private boolean result = true;
    public boolean isBalanced(TreeNode root) {
        maxDepth(root);
        return result;
    }
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        // use Math.abs to get true height diff
        if(Math.abs(l-r)>1) {
            result = false;
        }
        return 1 + Math.max(l,r);
    }
}
*/
