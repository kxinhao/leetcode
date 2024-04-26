// 3rd soln using dp O(n) time complexity
// dp: single pass, using a negative result of previous element to reset window start to current index
// brute force approach is O(n^3) time complexity
class Solution {
    public int maxSubArray(int[] nums) {
        // [-2,1,-3,4,-1,2,1,-5,4]
        int largestSum = nums[0]; 
        int[]dp = new int[nums.length]; // dp[i] is max subarray ending with nums[i]
        dp[0] = nums[0]; // -2
        for(int i=1; i<nums.length; i++) {
            // single pass to check current ind element using previous values
            // if prev dp element is negative, 
            // use only current nums[i] value as guaranteed higher sum vs subtraction
            // subarray starts from current ind
            dp[i] = nums[i] + (dp[i-1] > 0 ? dp[i-1] : 0); 
            // dp[1] = 1+0 = 1 (drop -2 as below val is negative thus subarray only ind 1)
            // dp[2] = -3+1 = -2
            // dp[3] = 4+0 = 4 (drop -2, subarray takes only ind 4)
            // dp[4] = -1+2 = 1
            // dp[5] = 2+1 = 3
            // dp[6] = 2+3 = 5
            // dp[7] = 1+5 = 6
            // dp[8] = -5+6 = 1
            // dp[9] = 4+1 = 5
            // compare largestSum to dp array element (max subarray ending nums[i]) and take max
            largestSum = Math.max(largestSum, dp[i]);
        }
        return largestSum;
    }
}
