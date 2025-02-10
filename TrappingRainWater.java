/**
 * LeetCode 42 Trapping Rain Water (Hard)
 * TC: O(N), SC: O(1)
 * single pass soln, 2 pointer l and r moving inward, calc vol at each point
 */
// 4th impl, rmb to use right/left as ind for height array for comparison with
// height val/maxLeft/maxRight

class Solution {
    public int trap(int[] height) {
        if(height==null || height.length<2) return 0;
        int left = 0, right = height.length-1, maxLeft = 0, maxRight = 0, waterVol = 0;
        while(left<right) {
            if(height[left]<height[right]) {
                if(height[left]>=maxLeft) maxLeft = height[left];
                else {
                    waterVol += maxLeft - height[left];
                }
                left++;
            } else {
                if(height[right]>=maxRight) maxRight = height[right];
                else {
                    waterVol += maxRight - height[right];
                }
                right--;
            }
        }
        return waterVol;
    }
}
