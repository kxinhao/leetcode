/**
 * LeetCode 118 Pascal's Triangle (Easy)
 * TC: O(N^2) where N is numRows
 */

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i<numRows; i++) {
            ans.add(new ArrayList<Integer>());
            for(int j = 0; j<=i; j++) {
                if(j==0||j==i) {
                    ans.get(i).add(j, 1);
                } else {
                    ans.get(i).add(j, ans.get(i-1).get(j-1) + ans.get(i-1).get(j));
                }
            }
        }
        return ans;
    }
}
