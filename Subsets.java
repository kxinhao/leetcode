/**
 * LeetCode 78 Subsets (Medium)
 * recursion, TC: O(2^n)
 */
// 3rd impl
/*
start = 0; ans = []; temp = [1]; i=1
start = 1; ans = [],[1]; temp = [1,2]; i=2
start = 2; ans = [],[1],[1,2]; temp = [1,2,3]; i=3
start = 3; ans = [],[1],[1,2],[1,2,3]; i=3==nums.length, doesnt enter loop
start = 2; ans = [],[1],[1,2],[1,2,3]; temp = [1,2]; start = 2 < nums.length, doesnt continue with loop
start = 1; temp = [1], i = 2; temp = [1,3];
start = 3; ans = [],[1],[1,2],[1,2,3],[1,3]
start = 1; i=2; temp = [1]
start = 0; temp = []; i=1; temp=[2]; i+1=2
start = 2; ans = [],[1],[1,2],[1,2,3],[1,3],[2]; temp = [2,3]; i+1=3
start = 3; ans = [],[1],[1,2],[1,2,3],[1,3],[2],[2,3]; i=3==nums.length, doesnt enter loop
start = 2; temp = [2]
start = 1; temp = []; i=2; temp = [3]; ans = [],[1],[1,2],[1,2,3],[1,3],[2],[2,3],[3]
*/

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(nums, ans, new ArrayList<>(), 0);
        return ans;
    }
    private void backtrack(int[] nums, List<List<Integer>> ans, List<Integer> temp, int start) {
        ans.add(new ArrayList<>(temp));
        for(int i = start; i<nums.length; i++) {
            temp.add(nums[i]);
            backtrack(nums, ans, temp, i+1);
            temp.remove(temp.size()-1);
        }
    }
}
