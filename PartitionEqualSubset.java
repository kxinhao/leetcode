/**
 * LeetCode 416 Partition Equal Subset Sum (Medium)
 * dp solution with TC: O(N^2) where N is sum of array elements/2
 * O(N*Sum(nums)), worst case O(N^2)
 * SC: O(Sum(nums))
 * find sum, must be divisible by 2 for equal partition to 2 subsets
 * build dp array until summation to partSum is possible upon adding an unsummed nums[] val
 */
// 7th impl using soln

class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums) sum += num;
        if(sum%2!=0) return false;
        int partSum = sum/2;
        boolean[] dp = new boolean[partSum+1];
        dp[0] = true;
        for(int num : nums) {
            // iterate decrementally from partSum to num so as to find possible summations for 
            // the in between values
            for(int i = partSum; i>=num; i--) {
                // take formation of sum i value and store as boolean in dp[i]
                // use || to prevent already dp[i] = true overwrite from dp[i-num] = false
                dp[i] = dp[i] || dp[i-num];
                if(dp[partSum]) return true;
            }
        }
        return dp[partSum];
    }
}
