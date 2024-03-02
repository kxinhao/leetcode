// 3rd solution (using L to R + R to L pass, using curr to store curr prod prog)
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
        // L to R pass results ans[1,1,2,6]
        // nums[1,2,3,4]
        // representing exclusion of rightmost element
        curr = 1;
        // layer population of right to left with existing prod arr, excluding curr elem
        for(int i = nums.length-1; i>= 0; i--) {
            ans[i] *= curr; // mult with curr as 2nd pass: 6x1=6, 2*4=8, 1*12=12, 1*24=24
            // formulation of curr value for index i-1 calculation of ans[i]
            curr *= nums[i]; // prep ans[i] right to left: 1*4=4, 4*3=12, 12*2=24, 24*1=24(not used)
        }
        // R to L pass results ans[24,12,8,6]
        return ans;

    }
}
