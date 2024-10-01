/**
 * LeetCode 125 Valid Palindrome (Easy)
 * 2 pointer soln
 * TC: O(N), SC: O(1)
 */
// 2nd impl
// using dual pointers converging
class Solution {
    public boolean isPalindrome(String s) {
        int lInd = 0, rInd = s.length()-1;

        while(lInd < rInd) {
          char lChar = s.charAt(lInd), rChar = s.charAt(rInd);
          if(!Character.isLetterOrDigit(lChar)) {
            lInd++;
            continue;
          }
          if(!Character.isLetterOrDigit(rChar)) {
            rInd--;
            continue;
          }
          if(Character.toLowerCase(lChar) != Character.toLowerCase(rChar)) {
            return false;
          }
          lInd++;
          rInd--;
        }
        return true;
    }
}
