/**
 * LeetCode 76 Minimum Window Substring (Hard)
 * TC: O(N), SC: O(1) constant due to predefined array size and string formation only at return time
 *
 */

class Solution {
    public String minWindow(String s, String t) {
        if(t.length()>s.length()) return "";

        // cant rmb exact ascii, just lump upper and lower case with inbetween special chars together
        int[] tFreq = new int[58];
        for(char c: t.toCharArray()) {
            tFreq[c - 'A']++;
        }

        int start = 0, end = 0, minStart = 0, minLength = Integer.MAX_VALUE, counter = t.length();

        while (end < s.length()) {
            char cEnd = s.charAt(end);
            if(tFreq[cEnd - 'A'] > 0) counter--;
            tFreq[cEnd - 'A']--;
            end++;
            while(counter==0) {
                if(minLength > end - start) {
                    minLength = end - start;
                    minStart = start;
                }
                char cStart = s.charAt(start);
                tFreq[cStart - 'A']++;
                if(tFreq[cStart - 'A'] > 0) counter++;
                start++;
            }
        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart+minLength);
    }
}
