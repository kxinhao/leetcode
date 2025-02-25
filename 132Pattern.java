/*
 * LeetCode 456 132 Pattern (Medium)
 * Monotonic stack soln with preprocessed firstLower array
 * TC: O(N), SC: O(N)
 */

class Solution {
    public boolean find132pattern(int[] nums) {
        if(nums.length<3) return false;
        int[] firstLower = new int[nums.length];
        Arrays.fill(firstLower,0);
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i<nums.length; i++) {
            if(i==0) firstLower[i] = 0;
            else if(nums[i]<nums[firstLower[i-1]]) firstLower[i] = i;
            else firstLower[i] = firstLower[i-1];

            while(!stack.isEmpty() && nums[stack.peek()]<=nums[i]) {
                stack.pop();
            }

            if(!stack.isEmpty()) {
                if(nums[firstLower[stack.peek()]] < nums[i]) return true;
            }
            stack.push(i);
        }
        return false;
    }
}
