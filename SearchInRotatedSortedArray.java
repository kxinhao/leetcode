/**
 * LeetCode 33 Search in Rotated Sorted Array (Medium)
 * First determine nums[mid] belongs to 1st or 2nd half of rotated array
 * then reposition lo and hi pointers based on comparison to target value
 * repeat until target appears at arr[mid] then return ind value
 */
// binary search for TC O(logn)

class Solution {
    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length-1;
        while (lo<=hi) {
            int mid = (lo+hi)/2;
            if(target==nums[mid]) return mid;
            if(nums[lo]<=nums[mid]) {
                if(target>nums[mid]||target<nums[lo]) lo = mid+1;
                else hi = mid-1;
            } else {
                if(target<nums[mid]||target>nums[hi]) hi = mid-1;
                else lo = mid+1;
            }
        }
        return -1;
    }
}

