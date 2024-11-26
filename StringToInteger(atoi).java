/**
 * LeetCode 8 String to Integer (atoi) (Medium)
 * TC: O(N), SC: O(1)
 */

class Solution {
    public int myAtoi(String s) {
        int index = 0, total = 0, sign = 1;
        // end of string case for 0 length string
        if(s.length()==0) return 0;
        // ignore whitespaces
        while(index<s.length() && s.charAt(index)==' ') index++;
        // after skip whitespace is end of string case
        if(index==s.length()) return total;
        // set signedness (ie. +ve or -ve)
        if(s.charAt(index)=='+'||s.charAt(index)=='-') {
            sign = s.charAt(index) == '+' ? 1 : -1;
            index++;
        }
        // go through rest of string after skips and signedness
        while(index<s.length()) {
            int digit = s.charAt(index) - '0';
            // if non-digit char, break from while loop
            if(digit<0||digit>9) break;
            // rounding if < -2^31 or > 2^31 - 1
            if(Integer.MAX_VALUE/10 < total || Integer.MAX_VALUE/10 == total && Integer.MAX_VALUE%10 < digit)
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            total = total*10 + digit;
            index++;
        }
        return total*sign;
    }
}
