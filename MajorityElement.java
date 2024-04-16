// Boyer-Moore Majority Vote Algorithm; linear TC O(n), constant SC O(1)
// sort and get middle element; logarithmic TC O(nlogn), constant SC O(1)
// hashmap population; linear TC O(n), linear SC O(n)
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
