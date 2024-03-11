// 7th impl
class Solution {
    public int pivotIndex(int[] nums) {
      int sum = 0;
      for(int num : nums) {
        sum += num;
      }
      int lSum = 0;
      for(int i = 0; i < nums.length; i++) {
        // represent movement of ind to right, removal of index value from sum
        sum -= nums[i];
        // check if left sum == right sum and return ind if true,
        // index of 0 will check against lSum of 0
        if(lSum == sum) {
          return i;
        }
        // add element to left sum from sum for i+1 index comparison
        lSum += nums[i];
      }
      return -1;
    }
}
