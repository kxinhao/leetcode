/**
 * LeetCode 11 Container with Most Water (Medium)
 * Single double pointer pass with skipping of <= heights
 * TC: O(N), SC: O(1)
 */
// 3rd impl

class Solution {
    public int maxArea(int[] height) {
        int vol = 0, left = 0, right = height.length-1;
        while(left<right) {
            int minHeight = Math.min(height[l], height[r]);
            int newVol = minHeight * (right-left);
            if(newVol>vol) vol = newVol;
            // skip left and right that give less volume
            // rmb to use array accesser instead of loop variable so we get up to date l/r heights
            while(left<right && height[left]<=lower) left++;
            while(left<right && height[right]<=lower) right--;
        }
        return vol;
    }
}
