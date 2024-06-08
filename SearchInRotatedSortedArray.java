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
            // nums[mid] belongs to the 1st part of nums
            if(nums[lo]<=nums[mid]) {
                // target belongs to 2nd half of nums, reposition left pointer
                if(target>nums[mid]||target<nums[lo]) lo = mid+1;
                // target belongs to 1st half of nums, decrement right pointer
                else hi = mid-1;
            } else { // nums[mid] < nums[lo], nums[mid] belongs to 2nd part of nums
                // target belongs to 1st half of nums, reposition right pointer
                if(target<nums[mid]||target>nums[hi]) hi = mid-1;
                // target belongs to 2nd half of nums, increment left pointer
                else lo = mid+1;
            }
        }
        return -1;
    }
}

