/**
 * LeetCode 46 Permutations (Medium)
 *
 */
// eg. nums = [1,2,3]
// 2nd impl

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
        // loop 0 to curr.size() for each recursion call
        for(int i=0; i<=curr.size(); i++) {
            curr.add(i, nums[ind]);
            // i=0, ind=0, curr=[1];
            //                       i=0, ind=1, curr=[2,1]; i=0, ind=2, curr=[3,2,1]
            //                                   curr=[2,1]; i=1, ind=2, curr=[2,3,1] 
            //                                   curr=[2,1]; i=2, ind=2, curr=[2,1,3]
            //                                   curr=[2,1];
            //                                   curr=[1];
            //                       i=1, ind=1, curr=[1,2]; i=0, ind=2, curr=[3,1,2]
            //                                   curr=[1,2]; i=1, ind=2, curr=[1,3,2]
            //                                   curr=[1,2]; i=2, ind=2, curr=[1,2,3]
            if(curr.size()>nums.length) break;
            backtrack(nums, ind+1, ans, curr);
            curr.remove(i);
        }
    }
}
