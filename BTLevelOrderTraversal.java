/**
 * LeetCode 102 Binary Tree Level Order Traversal (Medium)
 * DFS, uses answer list size to track levels that node values are added to
 * TC: O(N), SC: O(N)
 * BFS, uses null nodes in queue to track different levels
 * TC: O(N), SC: O(N)
 */

// DFS
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
        if(ans.size()==level) ans.add(new ArrayList<Integer>()); // confirm new level is reached
        ans.get(level).add(curr.val);
        levelTraverse(ans, curr.left, level+1);
        levelTraverse(ans, curr.right, level+1);
    }
}

// BFS
class Solution {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		List<Integer> currLevel = new ArrayList<Integer>();
		Queue<TreeNode> queue =  new LinkedList<TreeNode>();
		if(root != null) {
			queue.offer(root);
            // null acts as level separator in queue
			queue.offer(null);
		}
		while(!queue.isEmpty()) {
			TreeNode curr = queue.poll();
			if(curr != null) {
				currLevel.add(curr.val);
				if(curr.left != null) {
					queue.offer(curr.left);
				} 
				if(curr.right != null) {
					queue.offer(curr.right);
				}
			}
			else {
				ans.add(currLevel);
				if(!queue.isEmpty()) {
					currLevel = new ArrayList<Integer>();
					queue.offer(null);
				}
			}
		}
		return ans;
	}
}
