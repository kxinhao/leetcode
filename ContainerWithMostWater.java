/**
 * LeetCode 11 Container with Most Water (Medium)
 * TC: O(N), SC: O(1)
 */
// 2nd impl

class Solution {
    public int maxArea(int[] height) {
        int vol = 0, left = 0, right = height.length-1;
        while(left<right) {
            int lHeight = height[left], rHeight = height[right];
            int minHeight = Math.min(lHeight, rHeight);
            int newVol = minHeight * (right-left);
            if(newVol>vol) vol = newVol;
            // skip left and right that give less volume
            while(left<right && height[left]<=lower) left++;
            while(left<right && height[right]<=lower) right--;
        }
        return vol;
    }
}
