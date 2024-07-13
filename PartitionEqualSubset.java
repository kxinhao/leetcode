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
        for(int num : nums) {
            for(int i = partSum; i>0; i--) {
                if(i>=num) dp[i] = dp[i] || dp[i-num];
            }
        }
        return dp[partSum];
    }
}
