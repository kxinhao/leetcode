// 7th impl, store occurences of (subarraySum - k) in map
class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0, sum = 0;
        // init map of sum values with 0 count 1 to account for first pass starting from nums[0] to get sum = k
        map.put(0,1);
        for (int i = 0; i<nums.length; i++) {
            sum += nums[i];
            // [1,2,3] , k = 3
            // k = sum[end] - sum[start] (meaning sum of vals seq from start to end = k)
            // 3 = 1+2 - 0
            // 3 = 1+2+3 - 1+2
            // sum[start] = sum[end] - k,
            // 0 = 1+2 - 3
            // 1+2 = 1+2+3 - 3
            // retrieve occurences of sum[start] to find how many possible variations of deriving k
            count += map.getOrDefault(sum-k,0);
            // sum value count increment and update in map
            map.put(sum, map.getOrDefault(sum,0)+1);
        }
        return count;
    }
}
