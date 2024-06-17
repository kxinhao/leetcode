/**
 * LeetCode 39 Combination Sum (Medium)
 *
 */
// 2nd impl

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        return combinate(list, new ArrayList<>(), candidates, target, 0);
    }
    private List<List<Integer>> combinate(List<List<Integer>> list, List<Integer> temp, int[] candidates, int rem, int start) {
        if(rem<0) return list;
        else if(rem==0) {
            list.add(new ArrayList<>(temp));
            return list;
        } else {
            for(int i = start; i<candidates.length; i++) {
                temp.add(candidates[i]);
                combinate(list, temp, candidates,  rem-candidates[i],i);
                temp.remove(temp.size()-1);
            }
        }
        return list;
    }
}
