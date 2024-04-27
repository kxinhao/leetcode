// 4th soln using dp O(n) time complexity
// dp: single pass, using a negative result of previous element to reset window start to current index
// brute force approach is O(n^3) time complexity
class Solution {
    public int maxSubArray(int[] nums) {
        // [-2,1,-3,4,-1,2,1,-5,4]
        int largestSum = nums[0]; 
        int[]dp = new int[nums.length]; // dp array represents the max subarray up to each i index
        dp[0] = nums[0]; // -2
        for(int i=1; i<nums.length; i++) {
            // single pass to assign current dp[i] element using previously found values
            // if prev dp element is negative, 
            // drop dp[i-1] value to represent start of new subarray sum
            // with formula, resultant element will only be lower than prev if nums[i] is negative
            dp[i] = nums[i] + (dp[i-1] > 0 ? dp[i-1] : 0); 
            // dp[1] = 1+0 = 1 (drop -2 as below val is negative thus subarray only ind 1)
            // dp[2] = -3+1 = -2
            // dp[3] = 4+0 = 4 (drop -2, subarray takes only ind 4)
            // dp[4] = -1+4 = 3
            // dp[5] = 2+3 = 5
            // dp[6] = 1+5 = 6
            // dp[7] = -5+6 = 1
            // dp[8] = 4+1 = 5
            // [-2,1,-2,4,3,5,6,1,5]
            // compare largestSum to dp array element (max subarray ending nums[i]) and take max
            largestSum = Math.max(largestSum, dp[i]);
        }
        return largestSum;
    }
}
