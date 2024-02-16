// 2nd sol, using array summation and subtraction of indv elements
class Solution {
    public int pivotIndex(int[] nums) {
      int sum = 0;
      for(int num : nums) {
        sum += num;
      }
      int lSum = 0;
      for(int i = 0; i < nums.length; i++) {
        // represent movement of ind to right
        sum -= nums[i];
        // check if left sum == right sum and return ind if true
        if(lSum == sum) {
          return i;
        }
        // add element to left sum for next index comparison
        lSum += nums[i];
      }
      return -1;
    }
}
