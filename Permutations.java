/**
 * LeetCode 46 Permutations (Medium)
 * Find all unique permutations of number set by iterating size, incrementing temp list
 * and recursively calling same operations until temp list size == nums length
 * does not need to track ind as values already in temp are skipped over if present
 * TC: O(N*N!) Array.contains is O(N) operation, list insert at index is O(N) factorial TC
 * possible O(N!) if visited array is used to reduce contains check to O(1)
 * SC: O(N)
 */
// eg. nums = [1,2,3]
// 6th impl

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        backtrack(nums, ans, new LinkedList<>());
        return ans;
    }

    private void backtrack(int[] nums, List<List<Integer>> ans, LinkedList<Integer> curr, boolean[] visited) {
        if(curr.size()==nums.length) {
            ans.add(new ArrayList<>(curr));
        }
        else{
            for(int i=0; i<nums.length; i++) {
                if(visited[i]) continue;
                curr.add(nums[i]);
                visited[i] = true;
                backtrack(nums, ans, curr, visited);
                curr.removeLast();
                visited[i] = false
            }
        }
    }
}
/*
recurse 1: i=0, temp = [1]
	recurse 2: i=0, skip, i=1, temp = [1,2]
		recurse 3: i=0, skip, i=1, skip, i=2, temp = [1,2,3]
			recurse 4: ans = [[1,2,3]], return
		recurse 3: temp = [1,2], end recurse 3 loop
	recurse 2: temp = [1], i=2, temp = [1,3]
		recurse 3: i=0, skip, i=1, temp = [1,3,2]
			recurse 4: ans = [[1,2,3],[1,3,2]], return
		recurse 3: temp = [1,3], i=2, skip, end loop
	recurse 2: temp = [1], end loop
recurse 1: temp = [], i=1, temp = [2]
	recurse 2: i=0, temp = [2,1]
		recurse 3: i=0, skip, i=1, skip, i=2, temp = [2,1,3]
			recurse 4: ans = [[1,2,3],[1,3,2],[2,1,3]]
		recurse 3: temp = [2,1], end loop
	recurse 2: temp = [2], i=1, skip, i=2, temp = [2,3]
		recurse 3: i=0, temp = [2,3,1]
			recurse 4: ans = [[1,2,3],[1,3,2],[2,1,3],[2,3,1]]
		recurse 3: temp = [2,3], i=1, skip, i=2, skip, end loop
	recurse 2: temp = [2], end loop
recurse 1: temp = [], i=2, temp = [3]
	recurse 2: i=0, temp = [3,1]
		recurse 3: i=0, skip, i=1, temp=[3,1,2]
			recurse 4: ans = [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2]]
		recurse 3: temp = [3,1], i=2, skip, end loop
	recurse 2: temp=[3], i=1, temp=[3,2]
		recurse 3: i=0, temp = [3,2,1]
			recurse 4: ans = [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
		recurse 3: temp = [3,2], i=1, skip, i=2, skip, end loop
	recurse 2: temp = [3], i=2, skip, end loop
recurse 1: temp = [], end loop
return ans;
*/
