/**
 * LeetCode 3 Longest SubString Without Repeating Characters (Medium)
 * dual pointers soln, increment left pointer to right of already mapped character
 * to start new substring if not use prev left value
 * remember to +1 to length calculations
 * TC: O(N), SC: O(N)
 */

// 3rd impl
class Solution {
  public int lengthOfLongestSubstring(String s) {
    if(s.length()<2) return s.length;
    int maxLength = 0;
    HashMap<Character,Integer> map = HashMap<Character,Integer>();
    for(int left=0, right=0; right<s.length();right++) {
        // if map alr has right char, set left ind to 
        // max of comparison between most recent occurence ind of char and left ind(new ss start)
        // decides if substring continues from previous start, or starts from current index
        if(map.containsKey(s.charAt(right))) left = Math.max(left,map.get(s.charAt(right))) + 1;
        // 1st loop adds 0 pos character to hashmap as (char,0);
        // same char alr in map will have ind position updated to new ind
        map.put(s.charAt(right),right);
        maxLength = Math.max(maxLength, right-left+1);
    }
    return maxLength;
  }
}
