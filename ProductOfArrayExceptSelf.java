// 1st solution from ans (first pass R to L using curr * nums[i])
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        // representing exclusion of leftmost element
        int curr = 1;
        // populate prod of left to right excluding curr element
        for(int i = 0; i < nums.length; i++) {
            ans[i] = curr;
            curr *= nums[i]; // prep for next ans[i] left to right
        }
        // representing exclusion of rightmost element
        curr = 1;
        // layer population of right to left with existing prod arr, excluding curr elem
        for(int i = nums.length-1; i>= 0; i--) {
            ans[i] *= curr;
            curr *= nums[i]; // prep ans[i] right to left
        }
        return ans;

    }
}
