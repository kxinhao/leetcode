/**
 * LeetCode 75 Sort Colors (Medium)
 *
 */
// first impl using 2 pass count digit occurences and reimplement on index iteration TC: O(N) SC: O(1) 

class Solution {
    public void sortColors(int[] nums) {
        if(nums.length==1)return;
        int zeroCount = 0, oneCount = 0, twoCount = 0;
        for(int i = 0; i<nums.length; i++) {
            if(nums[i] == 0) zeroCount++;
            else if(nums[i] == 1) oneCount++;
            else twoCount++;
        }
        for(int i = 0; i<nums.length; i++) {
            if(i<zeroCount) nums[i] = 0;
            else if(i<zeroCount+oneCount) nums[i] = 1;
            else nums[i] = 2;
        }   
    }
}
