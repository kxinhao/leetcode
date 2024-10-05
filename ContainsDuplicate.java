/*
 * LeetCode 217 Contains Duplicate (Easy)
 * TC: O(N), SC: O(N)
 */

// 2nd impl
class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if(!set.add(num)) {
                return true;
            }
        }
        return false;
    }
}
