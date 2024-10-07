/*
 * LeetCode 560 Subarray Sum Equals K (Medium)
 * Presum + Hashmap soln, single pass cumulative summation deriving K occurences from prev hits
 * find currSum by sequential summation of nums elements
 * base case of currSum-k = 0 and start increment count based off this
 * store currSum in preSumSeen preSumSeen for reference if another summation gives already seen sum
 * TC: O(N), SC: O(N)
 *
 */

// 9th impl
class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> preSumSeen = new HashMap<>();
        int count = 0, currSum = 0;
        preSumSeen.put(0,1);
        for (int i = 0; i<nums.length; i++) {
            currSum += nums[i];
            count += preSumSeen.getOrDefault(currSum-k,0);
            preSumSeen.put(currSum, preSumSeen.getOrDefault(currSum,0)+1);
        }
        return count;
    }
}
