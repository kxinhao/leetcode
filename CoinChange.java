/**
 * LeetCode 322 Coin Change (Medium)
 * DP
 */
// eg. [1,2,5], 11

class Solution {
    public int coinChange(int[] coins, int amount) {
        final int fillVal = 100000;

        int dp = new int[amount+1]; // +1 for zero indexing
        Arrays.fill(dp, fillVal); // fill dp array with unreachable val to indicate unseen/invalid

        dp[0] = 0;

        for(int sum = 1; sum<=amount; sum++) {
            // going through each coin in coin bag
            for(int coin : coins) {
                if(sum >= coin && dp[sum-coin] != fillVal) dp[sum] = Math.min(dp[sum],dp[sum-c]+1);
            }
        }
        return dp[amount] == fillVal ? -1 : dp[amount];
    }
}
