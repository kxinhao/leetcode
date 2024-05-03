/**
 * LeetCode 3 Longest SubString Without Repeating Characters (Medium)
 * dual pointers soln, increment left pointer to right of already mapped character
 */

class Solution {
  public int lengthOfLongestSubstring(String s) {
    if(s.length()<2) return s.length;
    int maxLength = 0;
    HashMap<Character,Integer> map = HashMap<Character,Integer>();
    for(int i=0, j=0; i<s.length();i++) {
      if(map.containsKey(s.charAt(i))) j = Math.max(j,map.get(s.charAt(i))) + 1;
      map.put(s.charAt(i),i);
      maxLength = Math.max(maxLength, i-j+1);
    }
    return maxLength;
  }
}
