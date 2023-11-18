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
    public List<Integer> preorderTraversal(TreeNode root) {
        return walk(root, new ArrayList<>());
    }

    public List<Integer> walk(TreeNode curr, List<Integer> path) {
        if(curr==null)
            return path;

        // pre
        path.add(curr.val);

        // recurse
        walk(curr.left,path);
        walk(curr.right,path);

        //post
        return path;
    }
}
