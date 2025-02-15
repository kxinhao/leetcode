/*
 * Leetcode 503 Next Greater Element II (Medium)
 * Monotonic soln, trick to circular traversal is to loop twice
 * return array must contain values, hence assign values to return array elements using stack ind
 * TC: O(N), SC: O(N)
 */

// 2nd impl
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if(nums.length==1) return new int[]{-1};
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[nums.length];
        Arrays.fill(ans, -1);
        for(int j = 0; j<2; j++) {
            for(int i = 0; i<nums.length; i++) {
                while(!stack.isEmpty() && nums[stack.peek()]<nums[i]) {
                    int stackTop = stack.pop();
                    ans[stackTop] = nums[i];
                }
                stack.push(i);
            }
        }
        return ans;
    }
}
