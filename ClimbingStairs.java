// modified fibonacci sequence, n=1 and n=0 both result in 1 step taken 
// to give n=2 total of 2 ways (2+0),(1+1);
// uses 2 variables to track n-1 and n-2 to get n ways to climb stairs
class Solution {
    public int climbStairs(int n) {
        if(n==1||n==0) return 1; // modified from fibonacci as n = 2 has 2 ways
        int curr = 1, prev = 1; // base n-1, n-2, capped at n=2
        for(int i = 2; i<=n; i++){
            int tmp = curr; // store n-1 from prev loop to use as n-2 in next loop
            curr = curr + prev; // n = n-1 + n-2
            prev = tmp; // set n-2 for next calc
        }
        return curr;
    }
}
