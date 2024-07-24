/**
 * LeetCode 199 Binary Tree Right Side View
 * solution modified from BT Level Order Traversal, with right side checked first before left and
 * level==path.size() ensures first element of the element visited in the right view order will be
 * added to the path
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
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        return walk(root, new ArrayList<Integer>(), 0);
    }
    private List<Integer> walk(TreeNode curr, List<Integer> path, int level) {
        if(curr==null) return path;
        if(level == path.size()) path.add(curr.val);
        walk(curr.right, path, level+1);
        walk(curr.left, path, level+1);
        return path;
    }
}
