// 8th solution (first pass L to R, then R to L; curr init to 1 on start of both runs to rep prod except self)
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        // representing exclusion of leftmost element
        int curr = 1;
        // populate prod of left to right excluding curr element
        for(int i = 0; i < nums.length; i++) {
            ans[i] = curr;  // first pass population of values, no mult
            curr *= nums[i]; // prep for next ans[i] left to right
        }
        // example: nums[1,2,3,4]
        // L to R pass results ans[1,1,2,6]
        // represents mult result of values to left of curr ind, excluding right of curr ind values 
        curr = 1;
        // layer population of right to left with existing ans arr, excluding curr elem
        for(int i = nums.length-1; i>= 0; i--) {
            ans[i] *= curr; // mult with curr as 2nd pass: 6x1=6, 2*4=8, 1*12=12, 1*24=24
            // formulation of curr value for index i-1 calculation of ans[i]
            curr *= nums[i]; // calc curr for 2nd pass R to L: 1*4=4, 4*3=12, 12*2=24, 24*1=24(not used)
        }
        // R to L pass results ans[24,12,8,6]
        return ans;

    }
}
