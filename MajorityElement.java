// Boyer-Moore Majority Vote Algorithm
class Solution {
    public int majorityElement(int[] nums) {
        int majElem = nums[0], count = 1;
        for(int i=1; i<nums.length; i++) {
            if(count == 0) {
                majElem = nums[i];
                count++;
            }
            else if(majElem == nums[i]) {
                count++;
            }
            else count--;
        }
        return majElem;
    }
}
