/**
 * LeetCode 11 Container with Most Water (Medium)
 * TC: O(N), SC: O(1)
 */

class Solution {
    public int maxArea(int[] height) {
        int vol = 0, left = 0, right = height.length-1;
        while(left<right) {
            int lHeight = height[left], rHeight = height[right];
            int lower = Math.min(lHeight, rHeight);
            int newVol = lower * (right-left);
            if(newVol>vol) vol = newVol;
            while(left<right && height[left]<=lower) left++;
            while(left<right && height[right]<=lower) right--;
        }
        return vol;
    }
}
