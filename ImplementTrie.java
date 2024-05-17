/**
 * LeetCode 208 Implement Trie (Medium)
 *
 */

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
                curr.children[c-'a'] = new TrieNode();
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

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
