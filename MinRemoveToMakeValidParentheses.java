/**
 * LeetCode 1249 (Medium) Minimum Remove to Make Valid Parentheses
 * TC: O(N), SC: O(N) StringBuilder linear space taken
 */

class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder(s);
        int compare = 0;
        for(int i = 0; i<sb.length(); i++) {
            if(sb.charAt(i)=='(') compare++;
            else if(sb.charAt(i)==')' && compare>0) compare--;
            else if(sb.charAt(i)==')' && compare==0) {
                sb.deleteCharAt(i);
                i--;
            }
        }
        compare = 0;
        for(int i = sb.length()-1; i>=0; i--) {
            if(sb.charAt(i)==')') compare++;
            else if(sb.charAt(i)=='(' && compare>0) compare--;
            else if(sb.charAt(i)=='(' && compare==0) sb.deleteCharAt(i);
        }
        return sb.toString();
    }
}
