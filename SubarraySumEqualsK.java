// 2nd soln, using map to store remainder count
class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0, sum = 0;
        map.put(0,1);
        for (int i = 0; i<nums.length; i++) {
            sum += nums[i];
            int remainder = sum - k;
            if(map.containsKey(remainder)){
                count += map.get(remainder);
            }
            // sum += map.getOrDefault(sum-k,0);
            map.put(sum, map.getOrDefault(sum,0)+1);
        }
        return count;
    }
}
