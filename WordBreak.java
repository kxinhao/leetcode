/**
 * LeetCode 139 Word Break (Medium)
 * Many diff approaches
 * Trie/DP method, quadratic time complexity or 
 * TC(n * k^2), n = length of s, k = length of longest word in wordDict
 * Java substring has linear tc O(N) after java 7 update 6 where N is numbers in substring,
 * prev was constant tc O(1)
 * Trie search is linear time complexity or 
 * TC(w*l) where w is num of words and l is max length of word 
 * outer loops for s.length(), 
 */
// 3rd impl using trie ds impl and dp

class Solution {

    class Trie {
        class TrieNode {
            TrieNode[] children;
            boolean isWord;
            public TrieNode() {
                children = new TrieNode[26];
            }
        }

        private TrieNode root;
        
        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode curr = root;
            for(char c : word.toCharArray()) {
                if(null == curr.children[c - 'a']) {
                    curr.children[c - 'a'] = new TrieNode();
                }
                curr = curr.children[c - 'a'];
            }
            curr.isWord = true;
        }

        public boolean search(String word) {
            TrieNode curr = root;
            for(char c : word.toCharArray()) {
                if(null == curr.children[c - 'a']) return false;
                curr = curr.children[c - 'a'];
            }    
            return curr.isWord;
        }

        public boolean startsWith(String prefix) {
            TrieNode curr = root;
            for(char c : prefix.toCharArray()) {
                if(null == curr.children[c - 'a']) return false;
                curr = curr.children[c - 'a'];
            }
            return true;
        }
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Trie words = new Trie();
        for(String word : wordDict) {
            words.insert(word);
        }
        // array with s.length+1 for substring end ind exclusive
        boolean[] dp = new boolean [s.length()+1];
        // initialize dp[0] with true to start loop
        // dp[x] gives result of s[0:x] as substring is end index exclusive and to allow start of
        // next word from last found word
        dp[0] = true;
        for (int i = 0; i<s.length(); i++) {
            // skip impossible prefixes
            if(!dp[i]) continue;
            // finding all suffixes of letter s.charAt(i) found in wordDict
            // eg. word formed from 1st letter is ind[0:1]
            for(int j = i+1; j<=s.length(); j++) {
                // break when no further possible suffixes are found
                if(!words.startsWith(s.substring(i,j))) {
                    break;
                }
                // set end excl ind to true when word is found
                else if(words.search(s.substring(i,j))) {
                    dp[j] = true;
                }
            }
        }
        return dp[s.length()];
    }
}
