/*
 * LeetCode 496 Next Greater Element 1 (Easy)
 * Use HashMap to store the next greater element rather than use arrays and indexes to cut
 * down runtime
 */

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        int nums1Ind = 0;
        for(int i = 0; i<nums2.length; i++){
            while(!stack.isEmpty() && stack.peek()<nums2[i]) {
                map.put(stack.pop(), nums2[i]);
            }
            stack.push(nums2[i]);
        }
        int[] ans = new int[nums1.length];
        Arrays.fill(ans, -1);
        for(int i = 0; i<nums1.length; i++) {
            ans[i] = map.getOrDefault(nums1[i], -1);
        }
        return ans;
    }
}
