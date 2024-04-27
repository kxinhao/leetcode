/**
 * LeetCode 704 Binary Search (Easy)
 */
// 2nd impl
// (O)log n assuming sorted array
// checks middle values of array against target, if lower than check right, if higher check left
// if m != target, new bounds excludes m (lower assigns new lo to m+1, higher assigns hi to m)
// essentially halving search area each pass
// m can be assigned to hi as formula deriving m results at max hi-1
class Solution {
    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length;
        // nums = [-1,0,3,5,9,12], target = 9
        do {
            int m = (int)Math.floor(lo + (hi-lo)/2); // m = 3, 5, 4
            int n = nums[m]; // n = 5, 12, 9
            if(n == target) {
                return m; // return 4
            } else if(n > target) {
                hi = m; // hi = 5
            } else {
                lo = m+1; // lo = 4
            }
        } while(lo<hi);
        return -1;
    }
}
