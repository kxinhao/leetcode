/**
 * LeetCode 75 Sort Colors (Medium)
 * algo choices: digit freq count and repopulation, counting sort, Dutch National Flag(DNF)
 */
// first impl using 2 pass count digit occurences and reimplement on index iteration TC: O(N) SC: O(1) 
// 3rd impl using DNF TC: O(N), SC: O(1)

class Solution {
    public void sortColors(int[] nums) {
        // target nums[0] to nums[lo-1] to be 0
        // nums[lo] to nums[mid] is 1
        // nums[hi+1] to nums[nums.length-1] is 2
        int lo = 0, hi = nums.length-1, mid = 0;

        while(mid<=hi) {
            // arr[mid] = 0, then swap arr[lo] and arr[mid] and increment lo by 1 
            // because all the zeros are till index lo – 1 and move to the next element 
            // so increment mid by 1.
            if(nums[mid]==0) {
                nums[mid] = nums[lo];
                nums[lo] = 0;
                mid++;
                lo++;
            }
            // arr[mid] = 2, then swap arr[mid] and arr[hi] and decrement hi by 1
            // because all the twos are from index hi + 1 to N – 1. Now, we don’t move
            // to the next element because the element which is now at index mid can be a 0
            // and therefore needs to be checked again.
            else if(nums[mid]==2) {
                nums[mid] = nums[hi];
                nums[hi] = 2;
                hi--;
            }
            // arr[mid] = 1, then move to the next element so increment mid by 1.
            else mid++;
        }
    }
}
