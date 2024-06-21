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
 * Every time you have N choice (since you can use number repeatedly), 
 * and you can choose at most target times (actually it's smaller than target),
 * so we can assume the worst-case time complexity is O(N^target).
 */
// 3rd impl
// eg. cand = [2,3,6,7], target = 7

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        // new ArrayList instantiated in combinate method for temp storage of candidate ints
        return combinate(list, new ArrayList<>(), candidates, target, 0);
    }

    private List<List<Integer>> combinate(List<List<Integer>> list, List<Integer> temp, 
        int[] candidates, int rem, int start) {

        if(rem<0) return list;
        // when summed to target value, we add the candidate value in temp to ans list
        else if(rem==0) {
            list.add(new ArrayList<>(temp));
            return list;
        } else {
            for(int i = start; i<candidates.length; i++) {
                // if candidate[i] causes rem to be negative, skip subsequent calcs
                if(candidates[i]>rem) break;
                // r2. temp = [2,2], rem = 3
                // r3. temp = [2,2,2], rem = 1
                // r4. temp = [2,2,2,2], rem = -1, returned list, temp = [2,2,2]
                // r5. temp = [2,2,2,3], rem = -2, returned list, temp = [2,2,2]
                // r6,r7 same as r5 giving rem<0, thus candidates at temp=[2,2,2] are not added
                // and last temp element is removed temp = [2,2]
                // r8. temp = [2,2,3], rem = 0, temp added to ans list
                // r9. temp = [2,3,3], rem = -1, skip candidates. [3,3,3], rem = -2
                // r10. temp = [7], rem = 0, temp added to ans list
                temp.add(candidates[i]);
                // checking how many of candidate[i] we can add, remove after iterating through
                // all candidates
                combinate(list, temp, candidates,  rem-candidates[i], i);
                temp.remove(temp.size()-1);
            }
        }
        return list;
    }
}
