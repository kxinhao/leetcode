/*
 * LeetCode 739 Daily Temperatures (Medium)
 * TC: O(N), SC: O(N)
 */

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Arrays.fill(ans, 0);
        if(temperatures.length==1) return ans;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i<temperatures.length; i++) {
            while(!stack.isEmpty() && temperatures[stack.peek()]<temperatures[i]) {
                int stacktop = stack.pop();
                ans[stacktop] = i - stacktop;
            }
            stack.push(i);
        }
        return ans;
    }
}
