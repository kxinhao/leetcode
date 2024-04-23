// 1st soln using dp
class Solution {
    public int maxSubArray(int[] nums) {
        int largestSum = nums[0];
        int[]dp = new int[nums.length]; // dp[i] is max subarray ending with nums[i]
        dp[0] = nums[0];
        for(int i=1; i<nums.length; i++) {
            dp[i] = nums[i] + (dp[i-1] > 0 ? dp[i-1] : 0);
            largestSum = Math.max(largestSum, dp[i]);
        }
        return largestSum;
    }
}
