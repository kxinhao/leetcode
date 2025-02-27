/*
 * LeetCode 231 Power of Two (Easy)
 *
 */

class Solution {
    public boolean isPowerOfTwo(int n) {
        // rmb powered integers will not result in 0
        if(n<1) return false;
        return (n&(n-1))==0;
        // bitwise n AND n-1 negates both variables into resultant 0 if in power of 2
    }
}
