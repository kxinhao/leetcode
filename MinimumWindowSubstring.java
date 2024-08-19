/**
 * LeetCode 76 Minimum Window Substring (Hard)
 * TC: O(N), SC: O(1) constant due to predefined array size and string formation only at return time
 * Check substring that is valid using 2 pointer system, start and end pointers
 * Use counter of t length to check if we should increment start or end pointers
 * Use minStart and minLength to keep track of the min valid substring for return as answer
 */
// 6th impl

class Solution {
    public String minWindow(String s, String t) {
        if(t.length()>s.length()) return "";

        // cant rmb exact ascii, just lump upper and lower case with inbetween special chars together
        int[] tFreq = new int[58];
        for(char c: t.toCharArray()) {
            tFreq[c - 'A']++;
        }

        int start = 0, end = 0, minStart = 0, minLength = Integer.MAX_VALUE, counter = t.length();

        // loop while end pointer is not at eos
        while (end < s.length()) {
            char cEnd = s.charAt(end);
            // reduce target substring counter if end char is in it and freq is not at 0
            // (meaning it's occurance had already happened)
            if(tFreq[cEnd - 'A'] > 0) counter--;
            // reduce tFreq for end char, duplicates cause value to be in negatives
            // and hence help with counter value being able to sieve out unneeded duplicates in ss
            tFreq[cEnd - 'A']--;
            // increment end pointer(move right)
            end++;

            // valid ss found
            while(counter==0) {
                // if min possible length found so far is greater than length of formed ss 
                if(minLength > end - start) {
                    // set min length to the length of current formed ss
                    minLength = end - start;
                    // set min start point to the current start pointer
                    minStart = start;
                }
                // condition to move increment start pointer to narrow down valid ss size
                char cStart = s.charAt(start);
                // add back the freq of cStart char as we are moving away from it
                tFreq[cStart - 'A']++;
                // if cStart is in t and does not have duplicates in the formed ss,
                // added back freq of cStart will be back to 1, hence we can increment the counter and
                // move the end pointer
                if(tFreq[cStart - 'A'] > 0) counter++;
                // increment start pointer(move right)
                start++;
            }
        }
        // if target substring is not found, return empty string else use minStart and minLength
        // to substring the answer from string s
        return minLength == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart+minLength);
    }
}
