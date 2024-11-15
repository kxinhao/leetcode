/**
 * LeetCode 39 Combination Sum (Medium)
 * Distinct candidate integers and requires list of all unique combinations of candidates summing
 * to target integer.
 *
 * First sort to ensure we initate iterating from the lowest value candidate
 * Check each candidate integer to find if they sum to target, by discovering how many copies of the
 * integer may be used to find the target, if exceeds the target, move on to the next candidate value.
 * When remainder results in 0, we add the values considered in temp list to ans 
 *
 * TC: O(N^target) Exponential TC
 * Every time you have candidates.length choice (since you can use number repeatedly), 
 * and you can choose at most target times (actually it's smaller than target),
 * so we can assume the worst-case time complexity is O(N^target).
 */
// 6th impl **holy backtrack**
// eg. cand = [2,3,6,7], target = 7

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        combinate(list, new LinkedList<>(), candidates, target, 0);
    }

    private void combinate(List<List<Integer>> list, LinkedList<Integer> temp, 
        int[] candidates, int rem, int start) {

        if(rem<0) return;
        else if(rem==0) ans.add(new ArrayList<>(temp));
        else {
            for(int i = start; i<candidates.length; i++) {
                if(candidates[i]>rem) break;
                // r2. temp = [2,2], rem = 3
                // r3. temp = [2,2,2], rem = 1, break as 2>1, temp = [2,2]
                // r4. temp = [2,2,3], rem = 0, temp added to ans list, temp = [2,2], rem=3
                // r5. temp = [2,2], break as 6>3
                // r6. temp = [2], rem = 5, temp = [2,3], rem = 2, break as 3>2
                // r7. temp = [7], rem = 0, temp added to ans list
                temp.add(candidates[i]);
                // checking how many of candidate[i] we can add, remove after iterating through
                combinate(list, temp, candidates,  rem-candidates[i], i);
                temp.removeLast();
            }
        }
    }
}
