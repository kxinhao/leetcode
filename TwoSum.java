class Solution {
    public int[] twoSum(int[] nums, int target) {
        java.util.Map<Integer,Integer> hashtable = new java.util.HashMap<>();
        for(int i = 0; i<nums.length; i++) {
            int complement = target - nums[i];
            if(hashtable.containsKey(complement)){ //check if complement of nums[i] in hashtable
                return new int[]{i,hashtable.get(complement)}; //return array of index checked and complement ind
            }
            hashtable.put(nums[i], i); //nums[i] as key, index as value
        }
        return new int[]{};
    }
}
