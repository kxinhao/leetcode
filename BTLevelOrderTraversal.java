/**
 * LeetCode 102 Binary Tree Level Order Traversal (Medium)
 * use ans.size to track level, root = 0
 */

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        levelTraverse(ans, root, 0); // root level call
        return ans;
    }

    private void levelTraverse(List<List<Integer>> ans, TreeNode curr, int level) {
        if(curr==null) return;
        // ans.size tracks curr level starting root = 0
        if(ans.size()==level) ans.add(new ArrayList<Integer>()); 
        ans.get(level).add(curr.val);
        levelTraverse(ans, curr.left, level+1);
        levelTraverse(ans, curr.right, level+1);
    }
}
