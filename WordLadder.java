/**
 * LeetCode 127 Word Ladder (Hard)
 * Double ended BFS
 * cost of exploring each layer increases exponentially, so 2 half depth BFS is superior
 * to a single full depth BFS
 *
 * /

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return 0;
        Set<String> dict = new HashSet<>(wordList), startSet = new HashSet<>(),
                    endSet = new HashSet<>(), visited = new HashSet<>();
        startSet.add(beginWord);
        endSet.add(endWord);
        int len = 1;
        while(!startSet.isEmpty() && !endSet.isEmpty()) {
            // swap if startSet is larger then endSet
            if(startSet.size()>endSet.size()) {
                Set<String> tmp = startSet;
                startSet = endSet;
                endSet = tmp;
            }
            Set<String> tmpSet = new HashSet<>();
            for(String word : dict) {
                char[] wordArr = word.toCharArray();
                for(int i = 0; i<wordArr.length; i++) {
                    for(char c = 'a'; c<='z'; c++) {
                        char tmpChar = wordArr[i];
                        wordArr[i] = c;
                        String target = new String(wordArr);

                        if(endSet.contains(target)) return len+1;
                        if(!visited.contains(target) && dict.contains(target)) {
                            tmpSet.add(target);
                            visited.add(target);
                        }
                        wordArr[i] = tmpChar;
                    }
                }
            }
            startSet = tmpSet;
            len++;
        }
        return 0;
    }
}
