// 4th impl, added logic of sum - k count storage and retrieval in map
class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0, sum = 0;
        // init map of sum values with 0 count 1 to account for first item = k
        map.put(0,1);
        for (int i = 0; i<nums.length; i++) {
            sum += nums[i];
            /* int remainder = sum - k;
            if(map.containsKey(remainder)){
                count += map.get(remainder);
            } */
            // if sum[start] = sum[end] - k,
            // k = sum[end] - sum[start] (meaning sum of vals seq from start to end = k)
            // retrieve occurences of sum[start] to find how many possible variations of deriving k
            count += map.getOrDefault(sum-k,0);
            // sum value count increment and update in map
            map.put(sum, map.getOrDefault(sum,0)+1);
        }
        return count;
    }
}
