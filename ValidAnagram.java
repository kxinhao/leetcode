/**
 * LeetCode 242 Valid Anagram (Easy)
 */
// 4th impl, init alphabet occurence array for both strings 
// and increment on each ascii char ind appearance
// to account for unicode chars, use HashMap and codePointAt method on String/Character
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        int[] sFreq = new int[26];
        int[] tFreq = new int[26];
        for(char c : s.toCharArray()) {
            sFreq[c - 'a']++;
        }
        for(char c : t.toCharArray()) {
            tFreq[c - 'a']++;
        }
        if(Arrays.equals(sFreq,tFreq)){
            return true;
        }
        return false;
    }
  /*
    if(s.length()!=t.length()) return false;
        HashMap<Integer, Integer> sMap = new HashMap<>();
        HashMap<Integer, Integer> tMap = new HashMap<>();
        for(int i = 0; i<s.length(); i++) {
            sMap.put(s.codePointAt(i), sMap.getOrDefault(s.codePointAt(i), 0) +1);
            tMap.put(t.codePointAt(i), tMap.getOrDefault(t.codePointAt(i), 0) +1);
        }
        if(sMap.equals(tMap)) {
            return true;
        }
        return false;
    }
   */
}
