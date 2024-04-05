class Solution {
    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length;
        do {
            int m = (int)Math.floor(lo + (hi-lo)/2);
            int n = nums[m];
            if(n == target) {
                return m;
            } else if(n > target) {
                hi = m;
            } else {
                lo = m+1;
            }
        } while(lo<hi);
        return -1;
    }
}
