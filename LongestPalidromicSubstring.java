/**
 * LeetCode 5 Longest Palindromic Substring (Medium)
 * 2 pointer, TC: O(N^2)
 */

class Solution {
    public String longestPalindrome(String s) {
        String max="";
        for(int i = 0; i<s.length(); i++) {
            String s1 = extend(s,i,i);
            String s2 = extend(s,i,i+1);
            if(s1.length() > max.length()) max = s1;
            if(s2.length() > max.length()) max = s2;
        }
        return max;
    }

    private String extend(String s, int left, int right) {
        while(left>=0 && right<s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left+1, right);
    }
}
