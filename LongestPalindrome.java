/**
 * LeetCode 409 Longest Palindrome (Easy)
 * TC: O(N), SC: O(1)
 */

// run through each letter, increment in array of lower/uppercase ascii representing indexes
// longest possible palindrome calculated by summing up all even freq letters and 
// odd freq letters -1 and add 1 back at end of calculation if odd number was present.
// simulates adding characters to left and right ends to form palindrome, drop in 1 char with 
// odd freq to middle at the end if they exist
class Solution {
    public int longestPalindrome(String s) {
        if(s.length()==1) return 1;
        int[] freq = new int[60];
        int maxLength = 0;
        boolean hasOdd = false;
        for(char c : s.toCharArray()) freq[c-'A']++;
        for(int charFreq : freq) {
            if(charFreq%2==0) maxLength += charFreq;
            else {
                maxLength += charFreq-1;
                hasOdd = true;
            }
        }
        if(hasOdd) return maxLength+1;
        return maxLength;
    }
}
