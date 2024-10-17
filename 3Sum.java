/**
 * LeetCode 15 3Sum (Medium)
 * sort input array, then select non-duplicate element and use 2 pointer l + r to find triplet
 * TC: O(N^2), TC: O(N)
 */

// 5th impl
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // sort input array avg O(NlogN), wc O(N^2)
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        if(nums[0]>0) return ans;
        // i is value under consideration, other 2 values l & r will be based off this
        // end nums.length-2 as l will be i+1
        for(int i = 0; i<nums.length-2; i++) {
            if(i>0 && nums[i] == nums[i-1]) continue;
            int l = i+1, r = nums.length-1;
            while(l<r) {
                int sum = nums[i] + nums[l] + nums[r];
                if(sum>0) r--;
                else if(sum<0) l++;
                else {
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[l]);
                    triplet.add(nums[r]);
                    ans.add(triplet);
                    l++;
                    r--;
                    while(nums[l]==nums[l-1] && l<r) {
                        l++;
                    }
                    while(nums[r]==nums[r+1] && l<r) {
                        r--;
                    }
                }
            }
        }
        return ans;
    }
}
