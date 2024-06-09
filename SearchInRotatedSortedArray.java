/**
 * LeetCode 33 Search in Rotated Sorted Array (Medium)
 * First determine nums[mid] is in sorted or rotated part of array
 * then disregard 1st or 2nd half of array based on comparison to target value
 * repeat until target appears at arr[mid] then return ind value
 */
// binary search for TC O(logn)
// eg [4,5,6,7,0,1,2], target = 0

class Solution {
    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length-1;
        while (lo<=hi) {
            int mid = (lo+hi)/2;
            if(target==nums[mid]) return mid;

            // nums[mid] is in the sorted part of nums (7)
            if(nums[lo]<=nums[mid]) { // 4<7, 0<1
                // check lo and hi(mid) of 1st half against target
                // target is in 2nd half of nums, disregard 1st half (0<4, must be in right half)
                if(target>nums[mid]||target<nums[lo]) lo = mid+1;
                // target is in 1st half of nums, disregard 2nd half (0<1)
                else hi = mid-1;
            } else { // nums[mid] < nums[lo], nums[mid] is in rotated part of nums
                // target is in 1st half of nums, disregard 2nd half
                if(target<nums[mid]||target>nums[hi]) hi = mid-1;
                // target is in 2nd half of nums, disregard 1st half
                else lo = mid+1;
            }
        }
        return -1;
    }
}

