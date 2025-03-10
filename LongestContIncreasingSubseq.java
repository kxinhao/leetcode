/*
 * LeetCode 674 Longest Continuous Increasing Subsequence (Easy)
 * TC: O(N), SC: O(1)
 */

class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int ans = 1, currLen = 1;
        for(int i = 1; i<nums.length; i++) {
            if(nums[i]>nums[i-1]) currLen++;
            else currLen = 1;
            if(currLen>ans) ans = currLen;
        }
        return ans;
    }
}
