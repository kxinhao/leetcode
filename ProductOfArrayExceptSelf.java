/*
 * LeetCode 238 Product of Array except self (Medium)
 * TC: O(N) 2 loops iterating N times each
 * SC: O(N)
 * eg. input: [1,2,3,4] output: [24,12,8,6] 
 */

// 9th solution
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        // prefix and postfix of 1 to account for left and right edge cases
        int prefix = 1, postfix = 1;
        // pre[i] = pre[i-1] * ans[i-1];
        for(int i = 0; i < nums.length; i++) {
            ans[i] = prefix;  // first pass population of values, no mult
            prefix *= nums[i]; // calculation for next prefix -> ans[i] assignment
        }
        // suff[i] = suff[i+1] * ans[i+1]
        for(int i = nums.length-1; i>= 0; i--) {
            ans[i] *= postfix; // mult with curr as 2nd pass: 6x1=6, 2*4=8, 1*12=12, 1*24=24
            postfix *= nums[i]; // calc curr for 2nd pass R to L: 1*4=4, 4*3=12, 12*2=24, 24*1=24(not used)
        }
        return ans;
    }
}
