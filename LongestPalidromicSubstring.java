/**
 * LeetCode 5 Longest Palindromic Substring (Medium)
 * 2 pointer, TC: O(N^2), O(N) going through each char in s, O(N) substring operation after java7
 * alternatively, Manacher's Algo TC: O(N)
 * naive/brute force is O(N^3), O(N^2) for every substring formation and palindrome check is O(N)
 */

class Solution {
    public String longestPalindrome(String s) {
        String max="";
        for(int i = 0; i<s.length(); i++) {
            // check for odd length palindrome, expanding l and r from i
            String s1 = extend(s,i,i);
            // check for even length palindrome, expanding l from i and r from i+1
            String s2 = extend(s,i,i+1);
            if(s1.length() > max.length()) max = s1;
            if(s2.length() > max.length()) max = s2;
        }
        return max;
    }

    private String extend(String s, int left, int right) {
        // enters while only if a palindrome is found from left and right chars
        while(left>=0 && right<s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // return empty string if right index is smaller than left+1,
        // as substring is end index exclusive
        if(left+1>=right) return "";
        return s.substring(left+1, right);
    }
}
