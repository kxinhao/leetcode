class Solution {
    public int pivotIndex(int[] nums) {
       for(int i = 0; i<nums.length; i++) {
           int left = 0;
           int right = 0;
           for(int j = 0; j < i; j++) {
                left += nums[j];
           }
           for(int k = i+1; k < nums.length; k++) {
               right += nums[k];
           }
           if(left == right) {
               return i;
           }
       } 
       return -1;
    }
}
