class Solution {
    public int[] getConcatenation(int[] nums) {
        int[] ans = Arrays.copyOf(nums, nums.length*2);
        System.arraycopy(nums, 0, ans, nums.length, nums.length);
        return ans;
    }
}
