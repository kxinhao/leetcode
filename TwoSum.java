/*
 * LeetCode 1 Two Sum (Easy)
 * TC: O(N), SC: O(N)
 */

// 4th soln, use map to store int value and their occurance index, then subtract current from target to check map containsKey
// rmb to init array with values by new int[]{values};

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i<nums.length; i++) {
            int complement = target - nums[i];
            if(map.containsKey(complement)){ //check if complement of nums[i] in map
                return new int[]{i,map.get(complement)}; //return array of index checked and complement ind
            }
            map.put(nums[i], i); //nums[i] as key, index as value
        }
        return new int[]{};
    }
}
