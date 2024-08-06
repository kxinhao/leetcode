/**
 * LeetCode 17 Letter Combinations of a Phone Number (Medium)
 * Backtracking TC: O(4^N * N) simplified O(4^N), SC: O(3^N)
 */
// 1st impl

class Solution {
    // mapping of letters to keys
    Map<Integer, String[]> keys = initKeys();
    private static Map<Integer, String[]> initKeys() {
        Map<Integer, String[]> keys = new HashMap<>();
        keys.put(2, new String[]{"a","b","c"});
        keys.put(3, new String[]{"d","e","f"});
        keys.put(4, new String[]{"g","h","i"});
        keys.put(5, new String[]{"j","k","l"});
        keys.put(6, new String[]{"m","n","o"});
        keys.put(7, new String[]{"p","q","r","s"});
        keys.put(8, new String[]{"t","u","v"});
        keys.put(9, new String[]{"w","x","y","z"});
        return keys;
    }

    // backtrack
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if(digits == null || digits.length() == 0) return ans;
        combinate(digits, ans, new StringBuilder(), 0);
        return ans;
    }

    private void combinate(String digits, List<String> ans, StringBuilder sb, int ind) {
        if(ind == digits.length()) {
            ans.add(new String(sb));
            return;
        } 
        // for retrieval from mapping, each digit in digit string
        int digit = digits.charAt(ind) - '0'; // ascii numeration
        // for each digit pressed, get possible letters
        for(int i = 0; i<keys.get(digit).length; i++) {
            sb.append(keys.get(digit)[i]);
            combinate(digits, ans, sb, ind+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
