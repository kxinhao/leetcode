/**
 * LeetCode 70 Climbing Stairs (Easy)
 * TC: O(N), SC: O(1)
 */

// fibonacci seq skipping 0 value due to constraints, track last 2 steps and start from step 3
// updates last 2 step with each step taken, returns last step after it has been assigned curr
class Solution {
    public int climbStairs(int n) {
        if(n==1) return 1;
        int prev1 = 1, prev2 = 2;
        for(int i = 3; i<=n; i++) {
            int curr = prev1 + prev2;
            prev1 = prev2;
            prev2 = curr;
        }
        return prev2;
    }
}
