/**
 * LeetCode 139 Word Break (Medium)
 * Many diff approaches
 * Trie/DP method, TC(n*k^2), n = length of s, k = length of longest word in wordDict
 */
// 1st impl using trie impl and dp

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
        boolean[] dp = new boolean [s.length()+1];
        dp[0] = true;
        for (int i = 0; i<s.length(); i++) {
            if(!dp[i]) continue;
            for(int j = i+1; j<=s.length(); j++) {
                if(!words.startsWith(s.substring(i,j))) {
                    break;
                }
                else if(words.search(s.substring(i,j))) {
                    dp[j] = true;
                }
            }
        }
        return dp[s.length()];
    }
}
