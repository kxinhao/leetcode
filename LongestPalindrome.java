// run through each letter, increment in array of lower/uppercase ascii representing indexes
// longest possible palindrome calculated by summing up all even freq letters and 
// odd freq letters -1 and add 1 back at end of calculation if odd number was present.
// Time Complexity O(n)
// Space Complexity O(1)
class Solution {
    public int longestPalindrome(String s) {
        // a palindrome can only have 1 odd number letter freq count, result in odd length
        if(s.length()==1) return 1;
        int[] letterFreq = new int[52];
        for(int i = 0; i<s.length(); i++) {
            if(s.codePointAt(i)<91) { // for uppercase letters
                letterFreq[s.charAt(i) - 'A']++;
            } else {// for lowercase letters
                letterFreq[s.charAt(i) - 'a' + 26]++;
            }
        }
        int pLength = 0;
        boolean hasOdd = false;
        for(int i = 0; i<letterFreq.length; i++) {
            // add letters with even freq directly
            if(letterFreq[i]%2 == 0) {
                pLength = pLength + letterFreq[i];
            } else {
                // add letters with odd freq and sub 1 to make even
                hasOdd = true;
                pLength = pLength+letterFreq[i]-1;
            }
        }
        // add back 1 if odd numbered char freq present
        if(hasOdd) return pLength+1;
        return pLength;
    }
}
