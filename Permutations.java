/**
 * LeetCode 46 Permutations (Medium)
 *
 */
// eg. nums = [1,2,3]
// 1st impl

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(nums, 0, ans, new LinkedList<>());
        return ans;
    }

    private void backtrack(int[] nums, int ind, List<List<Integer>> ans, List<Integer> curr) {
        if(curr.size()==nums.length) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        // interate through the positions in the nums array to populate same ind in ans list
        for(int i=0; i<=curr.size(); i++) {
            curr.add(i, nums[ind]);
            if(curr.size()>nums.length) continue;
            backtrack(nums, ind+1, ans, curr);
            curr.remove(i);
        }
    }
}
