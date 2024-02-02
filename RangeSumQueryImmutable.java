class NumArray {

    int[] prefix;
    public NumArray(int[] nums) {
      int n =  nums.length;
      prefix = new int[n];
      // init first element of prefix arr
      prefix[0] = nums[0];
      // populate prefix arr with cumulative sum of nums arr elements
      for(int i = 1; i < n; i++) {
        prefix[i] = nums[i] + prefix[i-1];
      }

    }
    
    public int sumRange(int left, int right) {
      // if left index is not 0, use left-1 (sum thus far before index of left) 
      return prefix[right] - ((left == 0) ? 0: prefix[left-1]); 
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
