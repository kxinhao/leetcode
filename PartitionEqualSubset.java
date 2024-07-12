/**
 * LeetCode 416 Partition Equal Subset Sum (Medium)
 * dp solution with TC: O(N^2) where N is sum of array elements/2
 */
// 1st impl using soln,

class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums) sum += num;
        if(sum%2!=0) return false;
        int partSum = sum/2;
        boolean[] dp = new boolean[partSum+1];
        dp[0] = true;
        for(int i : nums) {
            for(int j = partSum; j>0; j--) {
                if(j>=i) dp[j] = dp[j] || dp[j-i];
            }
        }
        return dp[partSum];
    }
}
