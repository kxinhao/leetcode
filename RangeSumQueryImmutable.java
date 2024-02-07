// 2nd impl
class NumArray {

    int[] arr;
    public NumArray(int[] nums) {
      int n =  nums.length;
      arr = new int[n];
      // init first element of arr
      arr[0] = nums[0];
      // populate arr with cumulative sum of nums arr elements
      // summation operation at array population time, complexity O(n)
      for(int i = 1; i < n; i++) {
        arr[i] = nums[i] + arr[i-1];
      }

    }
    
    public int sumRange(int left, int right) {
      // account for left = 0 case else use summation prior to left ind
      return arr[right] - ((left == 0) ? 0: arr[left-1]); 
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
