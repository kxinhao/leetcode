// 3rd impl, init alphabet occurence array for both strings 
// and increment on each ascii char ind appearance
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
        int arrsLength = s.length();
        Map<Character,Integer> sMap = new HashMap<>();
        Map<Character,Integer> tMap = new HashMap<>();
        for(int i = 0; i < arrsLength; i++) {
            sMap.put(s.charAt(i),sMap.getOrDefault(s.charAt(i),0)+1);
            tMap.put(t.charAt(i),tMap.getOrDefault(t.charAt(i),0)+1);
        }
        for(Map.Entry<Character, Integer> entry : sMap.entrySet()) {
            char ch = entry.getKey();
            int count = entry.getValue();
            if(!tMap.containsKey(ch) || count != tMap.get(ch)){
                return false;
            }
        }
    return true;
  */
}
