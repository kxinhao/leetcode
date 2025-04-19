/*
 * LeetCode 680 Valid Palindrome II (Easy)
 * TC: O(N), SC: O(1)
 */

class Solution {
    public boolean validPalindrome(String s) {
        int l = 0, r = s.length()-1;
        while(l<r) {
            if(s.charAt(l)!=s.charAt(r)) return isPalin(s, l+1, r)||isPalin(s,l,r-1);
            l++;
            r--;
        }
        return true;
    }
    private boolean isPalin(String s, int l, int r) {
        while(l<r) {
            if(s.charAt(l)!=s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}
