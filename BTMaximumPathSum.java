/**
 * LeetCode 124 Binary Tree Maximum Path Sum (Hard)
 * PostOrder Traversal
 * TC: O(N)
 * SC: O(N)
 *
 */

class Solution {
    private int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    private int dfs(TreeNode root) {
        if(root==null) return 0;
        int leftSum = dfs(root.left);
        int rightSum = dfs(root.right);
       
        // max of subtree and maxSum
        int subtreeMax = Math.max(maxSum, leftSum+rightSum+root.val);
        // node path selection, choose left/right branch or only itself
        int maxNodePathSum = Math.max(Math.max(leftSum, rightSum) + root.val, root.val);
        // check if path sum is larger than subtreeMax, possible if a branch has negative
        maxSum = Math.max(subtreeMax, maxNodePathSum);
        // return upward path sum
        return maxNodePathSum;
    }
} 
