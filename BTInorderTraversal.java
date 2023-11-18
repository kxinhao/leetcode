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
    public List<Integer> inorderTraversal(TreeNode root) {
        return walk(root, new ArrayList<Integer>());
    }

    private List<Integer> walk(TreeNode curr, List<Integer> path) {
        if(curr==null) return path;

        walk(curr.left,path);

        path.add(curr.val);

        walk(curr.right,path);

        return path;
    }
}
