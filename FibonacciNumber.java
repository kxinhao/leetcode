/**
 * LeetCode 509 Fibonacci Number (Easy)
 * optimal soln is memoization, optimize further by using defined constraints in qn
 */

class Solution {
    public int fib(int n) {
        int[] mem = new int[31];
        for(int i=0;i<=n;i++) {
            if(i<=1) mem[i] = i;
            else mem[i] = mem[i-1]+mem[i-2];
        }
        return mem[n];
    }
}
