/*
 * LeetCode 456 132 Pattern (Medium)
 * Monotonic decreasing stack soln with preprocessed firstLower array
 * i<j<k, nums[i]<nums[k]<nums[j] (eg. [1,6,5])
 * nums[firstLower[stack.peek()]]<nums[i]<nums[stack.peek()]
 * TC: O(N), SC: O(N)
 * eg. nums[3,1,4,2]
 */

// 4th impl
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

            while(!stack.isEmpty() && nums[stack.peek()]<=nums[i]) stack.pop();

            // nums[i] = nums[firstLower[stack.peek()]], (aka lowest elem to left of j)
            // nums[j] = nums[stack.peek()], (aka prev greater value before k)
            // nums[k] = nums[curr]
            if(!stack.isEmpty() && nums[firstLower[stack.peek()]] < nums[i]) return true;

            stack.push(i);
        }
        return false;
    }
}

// simplified soln w/o array preprocess
// 2nd impl
class Solution {
    public boolean find132pattern(int[] nums) {
        if(nums.length<3) return false;
        int numk = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();
        for(int i=nums.length-1; i>=0; i--) {
            if(nums[i]<numsk) return true;
            while(!stack.isEmpty() && stack.peek()<nums[i]) numk = stack.pop();
            stack.push(nums[i]);
        }
        return false;
    }
}
