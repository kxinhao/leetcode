/**
 * LeetCode 102 Binary Tree Level Order Traversal (Medium)
 * use ans.size to track level based on prev level added lists, root starts at 0 
 * element addition occurs after ans.size/level check but before traversal left/right
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        levelTraverse(ans, root, 0); // root level call
        return ans;
    }

    private void levelTraverse(List<List<Integer>> ans, TreeNode curr, int level) {
        if(curr==null) return;
        // ans.size tracks curr level starting root = 0 to add in root
        // adds arraylist only if level matches size from previous level
        // once new level is accounted for, ans.size will be larger than level, no new arraylist added
        // only element will be added to level arraylist
        // ie. ans.size() = 0, level = 0 for root addition, ans.size() = 1
        // ans.size() = 1, level = 1, {{3},{9}}; ans.size = 2, level 1, {{3},{9,20}}
        if(ans.size()==level) ans.add(new ArrayList<Integer>()); 
        ans.get(level).add(curr.val);
        levelTraverse(ans, curr.left, level+1);
        levelTraverse(ans, curr.right, level+1);
    }
}
