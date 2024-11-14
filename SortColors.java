/**
 * LeetCode 75 Sort Colors (Medium)
 * algo choices: digit freq count and repopulation, counting sort, Dutch National Flag(DNF)
 */
// first impl using 2 pass count digit occurences and reimplement on index iteration TC: O(N) SC: O(1) 
// 5th impl using DNF TC: O(N), SC: O(1)

class Solution {
    public void sortColors(int[] nums) {
        // target nums[0] to nums[lo-1] to be 0
        // nums[lo] to nums[curr] is 1
        // nums[hi+1] to nums[nums.length-1] is 2
        int lo = 0, hi = nums.length-1, curr = 0;

        while(curr<=hi) {
            // arr[curr] = 0, then swap arr[lo] and arr[curr] and increment lo by 1 
            // because all the zeros are till index lo – 1 and move to the next element 
            // so increment curr by 1.
            if(nums[curr]==0) {
                nums[curr] = nums[lo];
                nums[lo] = 0;
                curr++;
                lo++;
            }
            // arr[curr] = 2, then swap arr[curr] and arr[hi] and decrement hi by 1
            // because all the twos are from index hi + 1 to N – 1. Now, we don’t move
            // to the next element because the element which is now at index curr can be a 0
            // and therefore needs to be checked again.
            else if(nums[curr]==2) {
                nums[curr] = nums[hi];
                nums[hi] = 2;
                hi--;
            }
            // arr[curr] = 1, then move to the next element so increment curr by 1.
            else curr++;
        }
    }
}
