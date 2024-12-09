/**
 * LeetCode 8 String to Integer (atoi) (Medium)
 * TC: O(N), SC: O(1)
 */

// 4th impl
class Solution {
    public int myAtoi(String s) {
        int index = 0, total = 0, sign = 1;
        // end of string case for 0 length string
        if(s.length()==0) return 0;
        // ignore whitespaces, check ind if out of scope
        while(index<s.length() && s.charAt(index)==' ') index++;
        // return total if we reached end of string ie ind>s.length
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
            // here we round total to either Integer.MIN_VALUE or Integer.MAX_VALUE if
            // absolute value of total > MAX_VALUE
            // check for the next sf total so we can safely add next digit without overflow
            // if curr total = 214748364 we will need to check the digit if it is greater than
            // int MAX_VALUE last digit 7 
            if(Integer.MAX_VALUE/10 < total || Integer.MAX_VALUE/10 == total &&
               Integer.MAX_VALUE%10 < digit)
            // immediately return if over/underflow
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            // building the digit left to right by shifting current total left by 1 decimal
            total = total*10 + digit;
            index++;
        }
        // taking into account signage
        return total*sign;
    }
}
