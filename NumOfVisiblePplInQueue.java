/*
 * LeetCode 1944 Number of Visible People in a Queue (Hard)
 * Monotonic stack
 * For each person in the queue, the next person with greater or equal height will be visible,
 * but will block view of anyone after due to constraint of everyone in between must be shorter
 * than both persons in consideration (+1)
 * Each person with a previous greater height person will also add to the count of that prev
 * greater height person (+n)
 */

// optimized monotonic stack soln with 1 less iteration and without storing next/prevGreater in arrs
// 2nd impl
class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        if(heights.length<2) return new int[] {0};
        int[] ans = new int[heights.length];
        Arrays.fill(ans, 0);
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i<heights.length; i++) {
            // both persons must be greater height than everyone in btwn
            // i person is to the right of stacktop, heights[i]>=heights[stacktop]
            // those behind can only see up to curr person
            while(!stack.isEmpty() && heights[stack.peek()]<=heights[i]) {
                ans[stack.pop()]++;
            }
            // prev greater for each i, heights[stackpeek()]>heights[i]
            if(!stack.isEmpty()) {
                ans[stack.peek()]++;
            }
            stack.push(i);
        }
        return ans;
    }
}
// initial soln, TC: O(N), SC: O(N)
class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        if(heights.length==1) return new int[]{0};
        int[] ans = new int[heights.length];
        Arrays.fill(ans, 0);
        // theory: find next greater and prev greater height ppl in queue,
        // then calc the no of times their index occurs in prevGreater and add 1
        // if nextGreater exists for them to see the person
        int[] prevGreater = new int[heights.length];
        int[] nextGreater = new int[heights.length];
        Arrays.fill(prevGreater, -1);
        Arrays.fill(nextGreater, heights.length);
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i<heights.length; i++) {
            while(!stack.isEmpty() && heights[stack.peek()]<heights[i]) {
                int stacktop = stack.pop();
                nextGreater[stacktop] = i;
            }
            if(!stack.isEmpty()) {
                prevGreater[i] = stack.peek();
            }
            stack.push(i);
        }
        for(int i = 0; i<heights.length; i++) {
            if(prevGreater[i]>-1) {
                ans[prevGreater[i]]++;
            }
            if(nextGreater[i]<heights.length) {
                ans[i]++;
            }
        }
        return ans;
    }
}
