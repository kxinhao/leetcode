/**
 * LeetCode 53 Maximum Subarray (Medium)
 * single pass dp soln, dp array stores larges subarray sum to date
 * Kadane's algorithm/divide and conquer optimized
 * TC: O(N), SC: O(N)
 */

// 6th impl using dp O(n) time complexity
// dp: single pass, using a negative result of previous element to reset window start to current index
// brute force approach is O(n^3) time complexity
class Solution {
    /*
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
    */

    // Kadane's algorithm TC: O(N), SC: O(1)
    // 3rd impl
    public int maxSubArray(int[] nums) {
        int max = nums[0], maxEndHere = nums[0];
        for(int i = 1; i<nums.length; i++) {
            maxEndHere = Math.max(maxEndHere+nums[i], nums[i]);
            max = Math.max(maxEndHere, max);
        }
        return max;
    }

    // Divide and Conquer (naive method)
    // TC: O(NLogN), SC: O(LogN) (Recursive stack requirement)
    // 2nd impl
    public int maxSubArray(int[] nums) {
        return dnc(nums, 0, nums.length-1);    
    }

    private int dnc(int[] nums, int l, int r) {
        if(l>r) return Integer.MIN_VALUE;
        int leftSum = 0, rightSum = 0;
        int mid = l + (r-l)/2;
        for(int i = mid-1, currSum = 0; i>=l; i--) {
            currSum += nums[i];
            leftSum = Math.max(leftSum, currSum);
        }
        for(int i = mid+1, currSum = 0; i<=r; i++) {
            currSum += nums[i];
            rightSum = Math.max(rightSum, currSum);
        }
        // T(N) = 2T(N/2) + O(N) -> master's theorem -> TC: O(NLogN)
        return Math.max(Math.max(dnc(nums, l, mid-1), dnc(nums, mid+1, r)), leftSum+rightSum+nums[mid]);
    }

    // Divide and Conquer (optimized), O(NLogN) -> O(N)
    // 1. each recursive call does constant time work
    // 2. split the problem into half each recursion
    // 3. total splits = log(n)
    // 4. work at each recursion level is essentially constant
    // 5. total work hence is proportionate to n, giving TC: O(n)
    // 6. space req is O(n) from precomputational space of pre and suf arrays
    // 2nd impl
    public int maxSubArray(int[] nums) {
       int[] pre = nums.clone();
       int[] suf = nums.clone();
       // pre[i] is max sum ending at i, O(N) 
       for(int i = 1; i<nums.length; i++) pre[i] += Math.max(0, pre[i-1]);
       // suf[i] is max sum starting i, O(N)
       for(int i = nums.length-2; i>=0; i--) suf[i] += Math.max(0, suf[i+1]);
       return dnc(nums, 0, nums.length-1, pre, suf);
    }

    private int dnc(int[] nums, int l, int r, int[] pre, int[] suf) {
        if(l==r) return nums[l];
        int mid = l + (r-l)/2;
        return Math.max(Math.max(dnc(nums, l, mid, pre, suf), dnc(nums, mid+1, r, pre, suf)), pre[mid] + suf[mid+1]); 
    }
}
