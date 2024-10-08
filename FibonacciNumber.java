/**
 * LeetCode 509 Fibonacci Number (Easy)
 * thought process: recursion first, optimize by exploring constraints
 * optimal soln is memoization, optimize further by using defined constraints in qn
 * optimize further by using O(1) space
 */

class Solution {
    public int fib(int n) {
        if(n<=1) return n;
        int a = 0, b = 1;
        for(int i=2; i<=n; i++) {
            int sum = a+b;
            a = b;
            b = sum;
        }
        return sum;
    }
}
