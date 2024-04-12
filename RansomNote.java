// using array to store char occurance using char unicode as rep index, compare occurances
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length()>magazine.length()) return false;
        int[] magArr = new int[26];
        int[] rnArr = new int[26];
        for(char c : magazine.toCharArray()) {
            magArr[c - 'a']++;
        }
        for(char c : ransomNote.toCharArray()) {
            rnArr [c-'a']++;
        }
        for(int i = 0; i<rnArr.length; i++) {
            if(rnArr[i]>magArr[i]) return false;
        }
        return true;
    }
}
