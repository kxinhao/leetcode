class Solution {
    static int reverse = 0; //leetcode does not clear static var after each testcase, need to reset manually

    public boolean isPalindrome(int x) {

        /* iterative while (avg runtime: 4ms, memory: 43MB)
        int number = x, remainder = 0, reverse = 0;        
        // all negative values are not palindromes
        if(x<0)
            return false;
        // reversal of number
        while (number!=0) {
            remainder = number % 10; //get the last sf
            reverse = reverse * 10 + remainder; //build reversed with the last sf
            number = number / 10; //remove last sf until zeroed
        }
        // check value of reversed against original
        if(reverse-x==0)
            return true;
        return false;
        */

        // recursion method (avg runtime: 24ms, memory: 43 MB)
        int rev = 0;
        if(x<0)
            return false;
        rev = reverseNumber(x);
        reverse = 0; //reset static var
        if(rev - x == 0) 
            return true;
        return false;

    }

    // recursion method
    private static int reverseNumber(int number) {

        if(number == 0) {
            System.out.println(reverse);
            return reverse;
        }
        
        if(number > 0){
            //remainder
            int remainder = number%10;
            //reversed
            reverse = reverse * 10 + remainder;
            //original number to work through
            reverseNumber(number/10);
        }

        return reverse; 
    }
}
