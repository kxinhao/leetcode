/*
 * LeetCode 26 Remove Duplicates from Sorted Array (Easy)
 * 2 pointer
 * TC: O(N), SC: O(1)
 */

class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length==1) return 1;
        int currVal = nums[0], currInd = 0, distinctCnt = 1;
        for(int i = 1; i<nums.length; i++) {
            if(nums[i]!=currVal) {
                nums[++currInd] = nums[i];
                currVal = nums[i];
                distinctCnt++;
            }
       } 
       return distinctCnt;
    }
}
