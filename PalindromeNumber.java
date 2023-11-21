class Solution {
    public boolean isPalindrome(int x) {
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
    }
}
