/**
 * LeetCode 322 Coin Change (Medium)
 * DP
 * coin denomination that can be used increases as dp array is formed from bottom up,
 * thus coin count may decrease when replacing lower value denominations in consideration
 * of summation to amount
 */
// eg. [1,2,5], 11

class Solution {
    public int coinChange(int[] coins, int amount) {
        final int fillVal = 100000;

        int dp = new int[amount+1]; // +1 for zero indexing
        Arrays.fill(dp, fillVal); // fill dp array with unreachable val to indicate unseen/invalid

        dp[0] = 0;

        // calculating the no of coins needed for each amt value from 0 to amt 
        for(int sum = 1; sum<=amount; sum++) {
            // going through each coin in coin bag
            for(int coin : coins) {
                // sum >= coin prevents overflowing desired amt from large coin value, 
                // dp[sum-coin]!=fillVal checks that the sum less this coin value has been calculated
                // take min of coins needed for sum vs (coins needed for sum-coin val)+1 coin
                // this replaces smaller denomination coins with larger denom, reducing coins needed
                if(sum >= coin && dp[sum-coin] != fillVal) dp[sum] = Math.min(dp[sum],dp[sum-coin]+1);
            }
        }
        // return -1 if amount is not able to be formed with given coin denominations
        return dp[amount] == fillVal ? -1 : dp[amount];
    }
}
