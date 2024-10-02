/**
 * LeetCode 704 Binary Search (Easy)
 */
// 3rd impl
// (O)log n assuming sorted array
// checks middle values of array against target, if lower than check right, if higher check left
// if m != target, new bounds excludes m (lower assigns new lo to m+1, higher assigns hi to m)
// essentially halving search area each pass
// m can be assigned to hi as formula deriving m results at max hi-1

class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length-1;
        while(l<=r){ // for when 2 element in boundary 
            int mid = l+(r-l)/2; // prevents int overflow
            if(nums[mid]==target) return mid;
            else if(nums[mid]>target) r = mid-1;
            else l = mid +1;
        }
        return -1;
    }
}
