/*
 * LeetCode 383 Ransom Note (Easy)
 * using array to store char occurance using char unicode as rep index, compare occurances
 * TC: O(N), SC: O(1)
 */

// 2nd impl, using single arr 
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length()>magazine.length()) return false;
        int[] magArr = new int[26];
        for(char c : magazine.toCharArray()) {
            magArr[c - 'a']++;
        }
        for(char c : ransomNote.toCharArray()) {
            if(--magArr[c-'a']<0) return false;
        }
        return true;
    }
}
