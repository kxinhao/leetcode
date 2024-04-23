// 8th impl, store occurences of (subarraySum - k) in map
class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0, sum = 0;
        // init map of sum values with 0 count 1 to account for test case where
        // first pass starting from nums[0] results in sum = k
        map.put(0,1);
        for (int i = 0; i<nums.length; i++) {
            sum += nums[i];
            // [1,2,3] , k = 3
            // (value k obtained from sum of vals to end ind - sum of vals to start ind)
            // k = sum[end] - sum[start] 
            // 3 = 1+2 - 0 (3 obtained from starting with value at start of array and end ind 1)
            // 3 = 1+2+3 - 1+2 (value sum starting ind 1 and end ind 2)
            // sum[start] = sum[end] - k,
            // contiguous array starting seq sum = cont array final seq sum - k value
            // 0 = 1+2 - 3
            // 1+2 = 1+2+3 - 3
            // retrieve occurences of sum[start] to find how many possible variations of deriving k

            // if there already has been an occurrence of k and the new sum - k will give k, +1 occurence
            count += map.getOrDefault(sum-k,0);
            // sum value count increment and update in map
            map.put(sum, map.getOrDefault(sum,0)+1);
        }
        return count;
    }
}
